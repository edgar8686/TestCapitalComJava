package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageElements extends AbstractPage {
    @FindBy(css = "div[class='registrationPromo']")
    private WebElement signUpPageName;
    @FindBy(css = "a[href='/trading/login']")
    private WebElement linkLoginPage;
    @FindBy(css = "label[id='s2_f_email'] input[name='ff01']")
    private WebElement inputEmailPage;
    @FindBy(css = "label[id='s2_f_pass'] input[name='ff11']")
    private WebElement inputPasswordPage;
    @FindBy(css = ".btn.btn--md.btn--wide.rg_btn.brickXs.disabled.hasPointer")
    private WebElement buttonContinuePage;
    @FindBy(css = "div[class='reg-desc']")
    private WebElement linkPrivatePage;
    public SignUpPageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement getSignUpPageName() {
        return signUpPageName;
    }

    public WebElement getLinkLoginPage() {
        return linkLoginPage;
    }

    public WebElement getInputEmailPage() {
        return inputEmailPage;
    }

    public WebElement getInputPasswordPage() {
        return inputPasswordPage;
    }

    public WebElement getButtonContinuePage() {
        return buttonContinuePage;
    }

    public WebElement getLinkPrivatePage() {
        return linkPrivatePage;
    }
}
