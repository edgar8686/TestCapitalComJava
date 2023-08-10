package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsCheck extends AbstractPage {
    //LogIn Trade buttons
    @FindBy(css = "#wg_loginBtn")
    private WebElement logIn;
    @FindBy(css = ".cc-header__btn.js_signup.js-analyticsVisible.js-analyticsClick")
    private WebElement signUp;
    @FindBy(css = ".cc-banner__btn.btn.btn--darkText.js_signup.js-analyticsClick")
    private WebElement startTrading;
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
    //Check TradeForm
    @FindBy(css = "div[class='form-container-small-header s-between'] div[class='h1']")
    private WebElement nameSignUp;
    @FindBy(css = "div[class='form-container-small-header s-between'] a[class='l_btn_signup'][href='#']")
    private WebElement linkLogin;
    @FindBy(css = "input[name='ff01']")
    private WebElement inputSignUpEmail;
    @FindBy(css = "input[name='ff11']")
    private WebElement inputSignUpPassword;
    @FindBy(css = "button[class='btn btn--md btn--wide s2_btn']")
    private WebElement buttonSignUpContinueIncluded;

    public WebElement getButtonSignUpContinueIncluded() {
        return buttonSignUpContinueIncluded;
    }

    @FindBy(css = "button[class='btn btn--md btn--wide s2_btn disabled hasPointer']")
    private WebElement buttonSignUpContinue;
    @FindBy(css = "div[class='reg-desc textCenter'] p a")
    private WebElement linkPrivate;
    //-----------------------------------------------------------------------------------
    //Auth check
    @FindBy(css = "object[class='logo'][data='./assets/pic/logo.svg'][type='image/svg+xml']")
    private WebElement logo;

    public ElementsCheck logInClick() {
        new EducatedMove(getDriver())
                .fluentWaitLocators(logIn);
        logIn.click();
        return this;
    }

    public ElementsCheck signUpClick() {
        new EducatedMove(getDriver())
                .fluentWaitLocators(signUp);
        signUp.click();
        return this;
    }

    public ElementsCheck startTradingClick() {
        new EducatedMove(getDriver())
                .fluentWaitLocators(startTrading);
        startTrading.click();
        return this;
    }

    public WebElement getSignUp() {
        return signUp;
    }

    public WebElement getLogIn() {
        return logIn;
    }

    public WebElement getTrade() {
        return signUp;
    }

    public WebElement getNameSignUp() {
        return nameSignUp;
    }

    public WebElement getLinkLogin() {
        return linkLogin;
    }

    public WebElement getInputSignUpEmail() {
        return inputSignUpEmail;
    }

    public WebElement getInputSignUpPassword() {
        return inputSignUpPassword;
    }

    public WebElement getButtonSignUpContinue() {
        return buttonSignUpContinue;
    }

    public WebElement getLinkPrivate() {
        return linkPrivate;
    }

    public ElementsCheck(WebDriver driver) {
        super(driver);
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

    public WebElement getLogo() {
        return logo;
    }
}
