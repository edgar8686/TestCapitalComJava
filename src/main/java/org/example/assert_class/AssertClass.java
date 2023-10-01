package org.example.assert_class;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.example.abstractClass.AbstractPage;
import org.example.manage_elements.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Random;

public class AssertClass extends AbstractPage {
    private WebElement elementPlatform;
    private WebElement elementPlatform2;
    private WebElement randomElement;
    private ArrayList<WebElement> elements = new ArrayList<>();
    private LogInFormElements logIn = new LogInFormElements(getDriver());
    private SignUpFormElements signUp = new SignUpFormElements(getDriver());
    private PlatformTradingViewElements platformElements = new PlatformTradingViewElements(getDriver());
    private PageCheckElements checkElements = new PageCheckElements(getDriver());
    private SignUpPageElements signUpPage = new SignUpPageElements(getDriver());
    private LoginPageElements loginPage = new LoginPageElements(getDriver());

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
    public void assertLogInPage() {
        Assertions.assertAll("Failed: Opened a 'SignUp' form page instead of a 'Login' form page",
                () ->
                        Assertions.assertTrue(loginPage.getLoginNamePage().isDisplayed(), "Login is not displayed"),
                () ->
                        Assertions.assertTrue(loginPage.getSignUpLinkPage().isDisplayed(), "Link SignUp is not displayed"),
                () ->
                        Assertions.assertTrue(loginPage.getInputEmailPageLogin().isDisplayed(), "Email input is not displayed"),
                () ->
                        Assertions.assertTrue(loginPage.getInputPasswordPageLogin().isDisplayed(), "Password input is not displayed"),
                () ->
                        Assertions.assertTrue(loginPage.getForgotPasswordPageLogin().isDisplayed(), "Password forgot link is not displayed"),
                () ->
                        Assertions.assertTrue(loginPage.getForgotPasswordPageLogin().isDisplayed(), "Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(loginPage.getCheckBoxPageLogin().isDisplayed(), "CheckBox is not displayed")
        );
    }

    public void assertSignUpForm() {
        Assertions.assertAll("Failed: Opened a 'Login' form page instead of a 'SignUp' form page",
                () ->
                        Assertions.assertTrue(signUp.getNameSignUp().isDisplayed(), "Name SignUp field is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getLinkLogin().isDisplayed(), "Login link is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getInputSignUpEmail().isDisplayed(), "SignUp Email input is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getInputSignUpPassword().isDisplayed(), "SignUp Password input is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getButtonSignUpContinue().isDisplayed(), "SignUp Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(signUp.getLinkPrivate().isDisplayed(), "Private link is not displayed")
        );
    }

    public void assertSignUpPage() {
        Assertions.assertAll("Failed: Opened a 'Login' form instead of a 'SignUp' form",
                () ->
                        Assertions.assertTrue(signUpPage.getSignUpPageName().isDisplayed(), "Name SignUp field is not displayed"),
                () ->
                        Assertions.assertTrue(signUpPage.getLinkLoginPage().isDisplayed(), "Login link is not displayed"),
                () ->
                        Assertions.assertTrue(signUpPage.getInputEmailPage().isDisplayed(), "SignUp Email input is not displayed"),
                () ->
                        Assertions.assertTrue(signUpPage.getInputPasswordPage().isDisplayed(), "SignUp Password input is not displayed"),
                () ->
                        Assertions.assertTrue(signUpPage.getButtonContinuePage().isDisplayed(), "SignUp Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(signUpPage.getLinkPrivatePage().isDisplayed(), "Private link is not displayed")
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

    public void assertPlatformInstrument() {
        Assertions.assertAll("Failed: Trade element is not active on the platform (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"), "Platform is not displayed"),
                () ->
                        Assertions.assertTrue(platformElements.getLogo2().isDisplayed(), "Logo is not displayed"),
                () ->
                        Assertions.assertTrue(elementPlatform.isDisplayed(), "Trade element is not displayed"),
                () ->
                        Assertions.assertTrue(elementPlatform2.isDisplayed(), "Trade active element is not displayed")
        );
    }

    @Step("Step: random selection of an element on the Widget")
    public void randomElementMethod() {
        Random random = new Random();

        elements.add(checkElements.getTesla());
        elements.add(checkElements.getNvidia());
        elements.add(checkElements.getAmd());
        elements.add(checkElements.getAmc());
        elements.add(checkElements.getApple());

        int randomIndex = random.nextInt(elements.size());
        randomElement = elements.get(randomIndex);

        Allure.step("Element: " + randomElement);

        if (randomElement == checkElements.getTesla()) {
            elementPlatform = platformElements.getElementPlatformTesla();
            elementPlatform2 = platformElements.getElementActiveTesla();
        } else if (randomElement == checkElements.getNvidia()) {
            elementPlatform = platformElements.getElementPlatformNvidia();
            elementPlatform2 = platformElements.getElementActiveNvidia();
        } else if (randomElement == checkElements.getAmc()) {
            elementPlatform = platformElements.getElementPlatformAmc();
            elementPlatform2 = platformElements.getElementActiveAmc();
        } else if (randomElement == checkElements.getAmd()) {
            elementPlatform = platformElements.getElementPlatformAmd();
            elementPlatform2 = platformElements.getElementActiveAmd();
        } else if (randomElement == checkElements.getApple()) {
            elementPlatform = platformElements.getElementPlatformApple();
            elementPlatform2 = platformElements.getElementActiveApple();
        }
    }

    public WebElement getRandomElement() {
        return randomElement;
    }
}
