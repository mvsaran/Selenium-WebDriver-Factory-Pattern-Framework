package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Robust InventoryPage with fallbacks and debug output when product lookup fails.
 */
public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Duration defaultTimeout = Duration.ofSeconds(20);

    private final By inventoryContainer = By.id("inventory_container");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By productNameLocator = By.cssSelector(".inventory_item_name");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, defaultTimeout);
    }

    public boolean isLoaded() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryContainer));
        return driver.getCurrentUrl().contains("inventory.html");
    }

    public List<WebElement> getAllProducts() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));
    }

    /**
     * Add product to cart with robust search & logging. Attempts:
     *  1) exact match using normalize-space(text())
     *  2) contains(text()) fallback
     *  3) case-insensitive check by comparing lower-cased texts of visible products
     *
     * If it can't find the product, it prints all product names on the page (debug) and throws a clear exception.
     */
    public void addProductToCart(String productName) {
        // ensure inventory loaded
        isLoaded();

        // 1) Try exact match (normalize-space)
        By exact = By.xpath("//div[@class='inventory_item_name' and normalize-space(text())='" + productName + "']");
        try {
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(exact));
            clickAddButton(product);
            waitForCartBadgeUpdate();
            return;
        } catch (Exception ignored) { /* fallback below */ }

        // 2) Try contains text (partial match)
        By contains = By.xpath("//div[@class='inventory_item_name' and contains(normalize-space(text()), '" + productName + "')]");
        try {
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(contains));
            clickAddButton(product);
            waitForCartBadgeUpdate();
            return;
        } catch (Exception ignored) { /* fallback below */ }

        // 3) Case-insensitive search across visible product names
        List<WebElement> names = driver.findElements(productNameLocator);
        for (WebElement n : names) {
            if (n.getText() != null && n.getText().trim().equalsIgnoreCase(productName.trim())) {
                clickAddButton(n);
                waitForCartBadgeUpdate();
                return;
            }
        }

        // If we reach here, product not found. Log what we saw and fail with an informative exception.
        List<String> visibleNames = names.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(">>> DEBUG: Unable to find product: \"" + productName + "\"");
        System.out.println(">>> DEBUG: Products visible on Inventory page (" + visibleNames.size() + "):");
        for (String n : visibleNames) {
            System.out.println(" - " + n);
        }

        // Also dump current URL and a small snapshot of page title for extra context
        System.out.println(">>> DEBUG: Current URL: " + driver.getCurrentUrl());
        System.out.println(">>> DEBUG: Page title: " + driver.getTitle());

        throw new IllegalStateException("Product not found on inventory page: \"" + productName + "\". " +
                "See console debug output for visible product list.");
    }

    private void clickAddButton(WebElement productNameElement) {
        // go up to parent inventory_item and click its button
        WebElement parent = productNameElement.findElement(By.xpath("./ancestor::div[contains(@class,'inventory_item')]"));
        WebElement addBtn = parent.findElement(By.cssSelector("button.btn_inventory"));
        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
    }

    private void waitForCartBadgeUpdate() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        } catch (Exception e) {
            // badge might be delayed or site might not show it for certain items; ignore
        }
    }

    public String getCartCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }
}
