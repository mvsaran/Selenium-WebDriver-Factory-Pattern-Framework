package tests;

import factory.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Parameters({"appUrl","user","pass"})
    @Test
    public void validLogin(@Optional("https://www.saucedemo.com/") String appUrl,
                           @Optional("standard_user") String user,
                           @Optional("secret_sauce") String pass) {
        var driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(appUrl);
        loginPage.login(user, pass);

        // After successful login, URL should contain inventory.html
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login failed or did not navigate to inventory page. Current URL: " + driver.getCurrentUrl());
    }
}
