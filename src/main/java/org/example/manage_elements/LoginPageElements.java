package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements extends AbstractPage {
    @FindBy(css = "div[class='form-container-white form-container-small modal']")
    private WebElement loginNamePage;
    @FindBy(css = "div[class='form-container-small-header'] a[class='l_btn_signup']")
    private WebElement signUpLinkPage;
    @FindBy(css = "input[name='email']")
    private WebElement inputEmailPageLogin;
    @FindBy(css = "input[name='password']")
    private WebElement inputPasswordPageLogin;
    @FindBy(css = "button[class='btn btn--md btn--wide l_btn']")
    private WebElement buttonContinuePageLogin;
    @FindBy(css = ".l_btn_forgot")
    private WebElement forgotPasswordPageLogin;
    @FindBy(css = "label[class='checkbox'] span")
    private WebElement checkBoxPageLogin;
    public LoginPageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginNamePage() {
        return loginNamePage;
    }

    public WebElement getSignUpLinkPage() {
        return signUpLinkPage;
    }

    public WebElement getInputEmailPageLogin() {
        return inputEmailPageLogin;
    }

    public WebElement getInputPasswordPageLogin() {
        return inputPasswordPageLogin;
    }

    public WebElement getButtonContinuePageLogin() {
        return buttonContinuePageLogin;
    }

    public WebElement getForgotPasswordPageLogin() {
        return forgotPasswordPageLogin;
    }

    public WebElement getCheckBoxPageLogin() {
        return checkBoxPageLogin;
    }
}
