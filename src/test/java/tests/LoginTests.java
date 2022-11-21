package tests;

import base.Pages;
import io.qameta.allure.*;
import models.User;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.TopHeaderPage;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Regression")
@Feature("Login tests")
@Severity(SeverityLevel.CRITICAL)
public class LoginTests extends Pages {

    User validUser = new User("qualitymatters@qa.pl", "12345", "Quality matters");
    User invalidUser = new User("invalidemail@qa.test", "54321", "invalid user");

    @Test
    @Step("Verify if username is visible at the top header")
    @Description("Method tests login mechanize with correct data")
    @Story("valid email and password")
    public void user_shouldBeAbleToLogin_whenPutValidData() {
        at(TopHeaderPage.class).goToLoginPage();
        at(LoginPage.class)
                .fillLoginData(validUser)
                .signIn();

        assertThat(at(TopHeaderPage.class).getUserName()).isEqualTo(validUser.getUserName());
    }

    @Test
    @Step("Verify if invalid username is able to login")
    @Description("Method tests authentication mechanize")
    @Story("invalid email and password")
    @Issue("124")
    @Flaky
    public void user_shouldBeNotAbleToLogin_WhenPutIncorrectData() {
        at(TopHeaderPage.class).goToLoginPage();
        at(LoginPage.class)
                .fillLoginData(invalidUser)
                .signIn();

        assertThat(at(MyAccountPage.class).getAlertText()).isEqualTo("Invalid password.");
    }

}
