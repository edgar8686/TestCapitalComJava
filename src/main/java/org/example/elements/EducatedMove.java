package org.example.elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.opentest4j.TestSkippedException;

import java.time.Duration;

public class EducatedMove extends AbstractPage {
    @FindBy(css = "a[data-type='nav_id96']")
    private WebElement educated;
    @FindBy(xpath = "//a[contains(@data-type,'nav_id243')]")
    private WebElement etfTrading;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookie;
    @FindBy(css = "div[class='form-container-small-header s-between'] div[class='h1']")
    private WebElement signUpForm;
    @FindBy(css = "input[name='ff01']")
    private WebElement email;
    @FindBy(xpath = "//button[contains(@class,'button-cleared small s_cancel')]//*[name()='svg']")
    private WebElement closeWindow;

    public EducatedMove(WebDriver driver) {
        super(driver);
    }

    public EducatedMove clickETFTrading() {
        try {
            fluentWaitLocators(educated);
            new Actions(getDriver())
                    .moveToElement(educated)
                    .perform();
            fluentWaitLocators(etfTrading);
            etfTrading.click();
            return this;
        } catch (NoSuchElementException e) {
            logException(e);
            throw new TestSkippedException("Test Skipped: ETF trading not found. For tests on language the page Education->ETF trading doesn't exist on production");
        }

    }

    public void acceptAllCookies() {
        try {
            if (cookie.isDisplayed() && getDriver() != null) {
                cookie.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("All cookies have been accepted");
        } catch (ElementClickInterceptedException a) {
            System.out.println("Не найден");
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
        //wait.until(driver -> {
        // return webElement;
        //});
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public EducatedMove closeLogInForm() {
        fluentWaitLocators(closeWindow);
        closeWindow.click();
        return this;
    }

    @Step("logException")
    public void logException(Exception e) {
        Allure.addAttachment("Exception Details", e.toString());
    }

}
