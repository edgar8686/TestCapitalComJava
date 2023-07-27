package org.example.elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.opentest4j.TestSkippedException;

import java.time.Duration;

public class SmokeMain extends AbstractPage {
    @FindBy(css = ".cc-nav__link.cc-nav__link--lvl1.js-analyticsClick")
    private WebElement educated;
    @FindBy(xpath = "//a[contains(@data-type,'nav_id243')]")
    private WebElement etfTrading;
    @FindBy(css = "#onetrust-accept-btn-handler")
    private WebElement cookie;
    @FindBy(css = "div[class='form-container-small-header s-between'] div[class='h1']")
    private WebElement signUpForm;
    @FindBy(css = "input[name='ff01']")
    private WebElement email;
    @FindBy(xpath = "//button[contains(@class,'button-cleared small s_cancel')]//*[name()='svg']")
    private WebElement closeWindow;

    public SmokeMain(WebDriver driver) {
        super(driver);
    }

    public SmokeMain clickETFTrading() {
        try {
            fluentWaitLocators(educated);
            new Actions(getDriver())
                    .moveToElement(educated)
                    .perform();
            fluentWaitLocators(etfTrading);
            etfTrading.click();
            return this;
        } catch (NoSuchElementException e) {
            throw new TestSkippedException("Test Skipped: ETF trading not found. For tests on 'fr' language the page \"Education->ETF trading\" doesn't exist on production");
        }
    }

    public void acceptAllCookies() {
        try {
            if (cookie.isDisplayed() && getDriver() != null) {
                cookie.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("All cookies have been accepted");
        }
    }

    public void checkWindow() {
        try {
            if (signUpForm.isDisplayed() && email.isDisplayed() && getDriver() != null) {
                closeWindow.click();
                System.out.println("The SignUp form is closed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("SignUp form don't surfaced");
        }
    }

    public WebElement fluentWaitLocators(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);
        wait.until(driver -> {
            return webElement;
        });
        return webElement;
    }

    public SmokeMain closeLogInForm() {
        fluentWaitLocators(closeWindow);
        closeWindow.click();
        return this;
    }

}
