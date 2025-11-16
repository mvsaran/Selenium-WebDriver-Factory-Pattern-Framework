package tests;

import factory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    @Parameters({"appUrl","user","pass","product"})
    @Test
    public void addItemToCart(@Optional("https://www.saucedemo.com/") String appUrl,
                              @Optional("standard_user") String user,
                              @Optional("secret_sauce") String pass,
                              @Optional("Sauce Labs Backpack") String product) {
        var driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        loginPage.open(appUrl);
        loginPage.login(user, pass);

        // ensure inventory page loaded; otherwise fail early
        Assert.assertTrue(inventoryPage.isLoaded(), "Inventory page did not load after login");

        try {
            inventoryPage.addProductToCart(product);
        } catch (Exception e) {
            // print stack and rethrow so the test fails but we have debug output in console
            System.err.println("Failed to add product '" + product + "' to cart: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }

        // verify cart badge shows 1 (or >0)
        Assert.assertTrue(Integer.parseInt(inventoryPage.getCartCount()) >= 1,
                "Cart count did not increase after adding product. Current count: " + inventoryPage.getCartCount());
    }
}
