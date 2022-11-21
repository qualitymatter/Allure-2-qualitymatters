package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Page {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".page-heading")
    private WebElement myAccountSiteHeading;
    @FindBy(css = ".alert ol li")
    private WebElement alertText;

    @Step("Get header name")
    public String getHeaderName() {
        return myAccountSiteHeading.getText();
    }

    @Step("Get alert text")
    public String getAlertText() {
        return alertText.getText();
    }
}
