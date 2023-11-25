package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    @FindBy(css = ".button-main.rounded-lg.__cp_b.ln-auto.js-analyticsClick[data-type='b_vert_s2_166']")
    private WebElement createAccount;
    @FindBy(css = ".button-main.rounded-lg.__cp_b.ln-auto.js-analyticsClick[data-type='b_hor_s1_167']")
    private WebElement freeDemoAccount;
    private List<WebElement> freeDemoAccount2;
    @FindBy(css = ".button-main.rounded-lg.__cp_b.ln-auto.js-analyticsClick")
    private WebElement freeTrial;


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

    public WebElement getSignUp() {
        return signUp;
    }

    public WebElement getLogIn() {
        return logIn;
    }

    public WebElement getTrade() {
        return signUp;
    }

    public PageCheckElements(WebDriver driver) {
        super(driver);
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

    public WebElement getCreateAccount() {
        return createAccount;
    }

    public WebElement getFreeDemoAccount() {
        return freeDemoAccount;
    }

    public WebElement getFreeTrial() {
        return freeTrial;
    }
}

