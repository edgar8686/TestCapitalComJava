package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageCheckElements extends AbstractPage {
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

    public PageCheckElements logInClick() {
        new EducatedMainPageElements(getDriver())
                .fluentWaitLocators(logIn);
        logIn.click();
        return this;
    }

    public PageCheckElements signUpClick() {
        new EducatedMainPageElements(getDriver())
                .fluentWaitLocators(signUp);
        signUp.click();
        return this;
    }

    public PageCheckElements startTradingClick() {
        new EducatedMainPageElements(getDriver())
                .fluentWaitLocators(startTrading);
        startTrading.click();
        return this;
    }

    public PageCheckElements tryDemoClick() throws InterruptedException {
        EducatedMainPageElements move = new EducatedMainPageElements(getDriver());
        move.fluentWaitLocators(tryDemo);
        tryDemo.click();
        //Thread.sleep(2000);
        //move.fluentWaitLocators(getAccountDemo());
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

    public PageCheckElements(WebDriver driver) {
        super(driver);
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

    public WebElement getLogo2() {
        return logo2;
    }
}

