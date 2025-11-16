package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * LoginPage for SauceDemo (https://www.saucedemo.com/)
 * Now includes handling for unexpected JS alerts after login.
 */
public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // correct SauceDemo locators
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(String url) {
        driver.get(url);
    }

    /**
     * Login with given credentials.
     * - clicks login
     * - handles any JS alert that may appear
     * - waits for inventory page or error message
     */
    public void login(String user, String pass) {
        WebElement userField = wait.until(ExpectedConditions.elementToBeClickable(username));
        userField.clear();
        userField.sendKeys(user);

        WebElement passField = wait.until(ExpectedConditions.elementToBeClickable(password));
        passField.clear();
        passField.sendKeys(pass);

        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        btn.click();

        // short graceful wait for alert (non-blocking)
        handleAlertIfPresent(5);

        // wait for either inventory page or error message (up to 10s)
        wait.until(driver1 -> driver1.getCurrentUrl().contains("inventory.html")
                || !driver1.findElements(errorMessage).isEmpty());
    }

    /**
     * Try to wait for alert up to given seconds and accept it.
     * If no alert appears, just return.
     */
    private void handleAlertIfPresent(int secondsToWait) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
            // optional: read the alert text for logging
            String text = alert.getText();
            System.out.println("Alert detected after login: " + text);
            alert.accept(); // or alert.dismiss() depending on expected behavior
            // give a tiny pause for the page to resume
            try { Thread.sleep(300); } catch (InterruptedException ignored) {}
        } catch (Exception e) {
            // No alert appeared within the short wait — nothing to do
        }
    }

    public String getLoginError() {
        try {
            return driver.findElement(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
