package org.example.assert_class;

import org.example.abstractClass.AbstractPage;
import org.example.manage_elements.LogInFormElements;
import org.example.manage_elements.PlatformTradingViewElements;
import org.example.manage_elements.SignUpFormElements;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AssertClass extends AbstractPage {
    private LogInFormElements logIn = new LogInFormElements(getDriver());
    private SignUpFormElements signUp = new SignUpFormElements(getDriver());
    private PlatformTradingViewElements platformElements = new PlatformTradingViewElements(getDriver());
    public AssertClass(WebDriver driver) {
        super(driver);
    }
    public void assertLogInForm() {
        Assertions.assertAll("Failed: Opened a 'SignUp' form instead of a 'Login' form",
                () ->
                        Assertions.assertTrue(logIn.getNameLogIn().isDisplayed(), "Login is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getLinkSignUp().isDisplayed(), "Link SignUp is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getInputEmail().isDisplayed(), "Email input is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getInputPassword().isDisplayed(), "Password input is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getLinkForgotPassword().isDisplayed(), "Password forgot link is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getButtonContinue().isDisplayed(), "Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getCheckBox().isDisplayed(), "CheckBox is not displayed")
        );
    }
    public void assertSignUpForm() {
        Assertions.assertAll("Failed: Opened a 'Login' form instead of a 'SignUp' form",
                () ->
                        Assertions.assertTrue(signUp.getNameSignUp().isDisplayed(), "Name SignUp field is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getLinkLogin().isDisplayed(), "Login link is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getInputSignUpEmail().isDisplayed(), "SignUp Email input is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getInputSignUpPassword().isDisplayed(),"SignUp Password input is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getButtonSignUpContinue().isDisplayed(), "SignUp Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getLinkPrivate().isDisplayed(), "Private link is not displayed")
        );
    }
    public void assertPlatformPage() {
        Assertions.assertAll("Failed: Platform is not opened (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"), "Platform title is not displayed"),
                () ->
                        Assertions.assertTrue(platformElements.getLogo().isDisplayed(), "Logo is not displayed")
        );
    }
    public void assertPlatformDemo() {
        Assertions.assertAll("Failed: Trade element is not opened (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"), "Platform title is not displayed"),
                () ->
                        Assertions.assertTrue(platformElements.getAccountDemo().isDisplayed(), "Demo button is not displayed"),
                () ->
                        Assertions.assertTrue(platformElements.getLogo().isDisplayed(), "Logo is not displayed")
        );
    }
}
