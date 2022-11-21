package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverThreadLocal {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver() {
        driver.set(new ChromeDriver());
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void teardown() {
        driver.get().quit();
        driver.remove();
    }


}