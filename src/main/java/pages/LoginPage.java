package pages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input#email")
    private WebElement inputEmail;
    @FindBy(css = "input#passwd")
    private WebElement inputPassword;
    @FindBy(css = "#login_form span")
    private WebElement signInButton;

    @FindBy(css = ".page-heading")
    private WebElement myLoginSiteHeading;

    @Step("Sign in with: {user.email} | {user.password}")
    public LoginPage fillLoginData(User user) {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    @Step("Go to my account page...")
    public LoginPage signIn() {
        signInButton.click();
        return this;
    }

    @FindBy(css = ".texfield")
    private WebElement textField;
    @FindBy(css = ".button")
    private WebElement btn;

    public void passNumber(String digit) {
        driver.findElement(By.cssSelector(".textfield")).sendKeys(digit);
        driver.findElement(By.id("accept-button")).click();
    }
}
