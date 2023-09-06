package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class LogInFormElements extends AbstractPage {
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

    public LogInFormElements(WebDriver driver) {
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
}
