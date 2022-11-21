package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class Page {

    private static final Logger logger = LoggerFactory.getLogger(Page.class);
    private static final Duration TIMEOUT = Duration.ofSeconds(15);
    private static final Duration POOLING = Duration.ofMillis(10);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public Page(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public Page(WebDriver driver, WebElement element) {
        initDriver(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(element), this);
    }

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POOLING);
        actions = new Actions(driver);
        logger.debug("Created WebDriverWait with timeout: " + TIMEOUT + "s and sleep: " + POOLING + "ms");
    }
}
