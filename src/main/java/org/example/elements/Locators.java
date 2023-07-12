package org.example.elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators extends AbstractPage {
    //LogIn Trade
    @FindBy(css = "#wg_loginBtn")
    private WebElement logIn;
    @FindBy(css = ".cc-header__btn.js_signup.js-analyticsVisible.js-analyticsClick")
    private WebElement trade;
    //-------------------------------------------------
    //Check LogInForm
    @FindBy(css = "div[class='form-container-white form-container-small modal'] div[class='h1']")
    private WebElement nameLogIn;
    @FindBy(css = "div[class='form-container-small-header'] a[class='l_btn_signup']")
    private WebElement linkSignUp;
    @FindBy(css = "input[name='email']")
    private WebElement inputEmail;
    @FindBy(css = "input[name='password']")
    private WebElement inputPassword;
    @FindBy(css = "button[class='btn btn--md btn--wide l_btn']")
    private WebElement buttonContinue;
    @FindBy(css = ".l_btn_forgot")
    private WebElement linkForgotPassword;
    @FindBy(css = "label[class='checkbox'] span")
    private WebElement checkBox;
    //-------------------------------------------------------

    public Locators(WebDriver driver) {
        super(driver);
    }

    public Locators logInClick() {
        new SmokeMain(getDriver())
                .fluentWaitLocators(logIn);
        logIn.click();
        return this;
    }

    public Locators tradeClick() {
        new SmokeMain(getDriver())
                .fluentWaitLocators(trade);
        trade.click();
        return this;
    }

    public WebElement getNameLogIn() {
        return nameLogIn;
    }

    public WebElement getLinkSignUp() {
        return linkSignUp;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonContinue() {
        return buttonContinue;
    }

    public WebElement getLinkForgotPassword() {
        return linkForgotPassword;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }
}
