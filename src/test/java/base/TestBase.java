package base;

import config.AllureFeatures;
import helpers.ScreenShotCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static helpers.UrlProvider.BASE_URL;

public class TestBase {

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    protected WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        AllureFeatures.generateEnvironmentVariablesForAllure();
    }

    @BeforeEach
    public void setupDriver() {
        WebDriverThreadLocal.setDriver();
        this.driver = WebDriverThreadLocal.getDriver();
        driver.get(BASE_URL);
    }

    @AfterEach
    public void closeDriver() {
        ScreenShotCreator.takeScreenShot(driver);
        WebDriverThreadLocal.teardown();
    }


}
