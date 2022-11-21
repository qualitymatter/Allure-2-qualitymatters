package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopHeaderPage extends Page {
    public TopHeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".login")
    private WebElement logInBtn;
    @FindBy(css = ".header_user_info span")
    private WebElement loggedUsername;

    @Step("Go to login page...")
    public LoginPage goToLoginPage() {
        logInBtn.click();
        return new LoginPage(driver);
    }

    @Step("Get logged username from top header")
    public String getUserName() {
        wait.until(ExpectedConditions.visibilityOf(loggedUsername));
        return loggedUsername.getText();
    }
}
