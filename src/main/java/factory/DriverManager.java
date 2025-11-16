package factory;


import org.openqa.selenium.WebDriver;


// Thread-safe WebDriver holder so tests can run in parallel
public class DriverManager {
private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();


public static void setDriver(WebDriver webDriver) {
driver.set(webDriver);
}


public static WebDriver getDriver() {
return driver.get();
}


public static void quitDriver() {
WebDriver d = driver.get();
if (d != null) {
d.quit();
driver.remove();
}
}
}