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
    @FindBy(css = ".cc-banner__btn.btn.btn--emptyblack.js_signup.hideXs.js-analyticsClick")
    private WebElement tryDemo;
    @FindBy(css = ".regSteps__item.js_signup.js-analyticsClick.js-analyticsVisible")
    private WebElement createVerifyYourAccount;
    @FindBy(css = ".mostTraded__btn.btn.btn--xs.ln-auto.js_signup_new.js-analyticsClick[data-iid='22855552501634244']")
    private WebElement tesla;
    @FindBy(css = ".mostTraded__btn.btn.btn--xs.ln-auto.js_signup_new.js-analyticsClick[data-iid='16150730595456196']")
    private WebElement nvidia;
    @FindBy(css = ".mostTraded__btn.btn.btn--xs.ln-auto.js_signup_new.js-analyticsClick[data-iid='21178483823812']")
    private WebElement amc;
    @FindBy(css = ".mostTraded__btn.btn.btn--xs.ln-auto.js_signup_new.js-analyticsClick[data-iid='21182778791108']")
    private WebElement amd;
    @FindBy(css = ".mostTraded__btn.btn.btn--xs.ln-auto.js_signup_new.js-analyticsClick[data-iid='1147941679092932']")
    private WebElement apple;
    @FindBy(css = ".cc-box.grid.gSm.brickSm.mostTraded.js-mostTraded.js-analyticsVisible")
    private WebElement widget;
    //-----------------------------------------------------
    @FindBy(xpath = "//*[text()=' Tesla ']")
    private WebElement elementPlatformTesla;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Tesla']")
    private WebElement elementActiveTesla;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='AMC']")
    private WebElement elementActiveAmc;
    @FindBy(xpath = "//*[text()=' AMC ']")
    private WebElement elementPlatformAmc;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Nvidia']")
    private WebElement elementActiveNvidia;
    @FindBy(xpath = "//*[text()=' Nvidia ']")
    private WebElement elementPlatformNvidia;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='AMD']")
    private WebElement elementActiveAmd;
    @FindBy(xpath = "//*[text()=' AMD ']")
    private WebElement elementPlatformAmd;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Apple']")
    private WebElement elementActiveApple;
    @FindBy(xpath = "//*[text()=' Apple ']")
    private WebElement elementPlatformApple;

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

    @FindBy(css = "button[class='btn btn--md btn--wide s2_btn disabled hasPointer']")
    private WebElement buttonSignUpContinue;
    @FindBy(css = "div[class='reg-desc textCenter'] p a")
    private WebElement linkPrivate;
    //-----------------------------------------------------------------------------------
    //Auth check
    @FindBy(css = "object[class='logo__icon']")
    private WebElement logo;
    @FindBy(css = ".logo")
    private WebElement logo2;
    @FindBy(xpath = "//div[@class='account__mode account__mode_demo']")
    private WebElement accountDemo;

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

    public ElementsCheck tryDemoClick() throws InterruptedException {
        new EducatedMove(getDriver())
                .fluentWaitLocators(tryDemo);
        tryDemo.click();
        Thread.sleep(2000);
        return this;
    }


    public WebElement getButtonSignUpContinueIncluded() {
        return buttonSignUpContinueIncluded;
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

    public WebElement getAccountDemo() {
        return accountDemo;
    }

    public WebElement getTesla() {
        return tesla;
    }

    public WebElement getNvidia() {
        return nvidia;
    }

    public WebElement getAmc() {
        return amc;
    }

    public WebElement getAmd() {
        return amd;
    }

    public WebElement getApple() {
        return apple;
    }

    public WebElement getCreateVerifyYourAccount() {
        return createVerifyYourAccount;
    }

    public WebElement getWidget() {
        return widget;
    }

    public WebElement getElementPlatformTesla() {
        return elementPlatformTesla;
    }

    public WebElement getElementActiveTesla() {
        return elementActiveTesla;
    }

    public WebElement getElementActiveAmc() {
        return elementActiveAmc;
    }

    public WebElement getElementPlatformAmc() {
        return elementPlatformAmc;
    }

    public WebElement getElementActiveNvidia() {
        return elementActiveNvidia;
    }

    public WebElement getElementPlatformNvidia() {
        return elementPlatformNvidia;
    }

    public WebElement getElementActiveAmd() {
        return elementActiveAmd;
    }

    public WebElement getElementPlatformAmd() {
        return elementPlatformAmd;
    }

    public WebElement getElementActiveApple() {
        return elementActiveApple;
    }

    public WebElement getElementPlatformApple() {
        return elementPlatformApple;
    }

    public WebElement getLogo2() {
        return logo2;
    }
}

