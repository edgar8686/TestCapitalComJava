package org.example.manage_elements;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.example.abstractClass.AbstractPage;
import org.example.move_page.MovePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.opentest4j.TestAbortedException;

import java.time.Duration;

public class EducatedMainPageElements extends AbstractPage implements MovePage<EducatedMainPageElements> {
    @FindBy(css = "a[data-type='nav_id96']")
    private WebElement educated;
    @FindBy(xpath = "//a[contains(@data-type,'nav_id243')]")
    private WebElement etfTrading;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookie;
    @FindBy(xpath = "//button[contains(@class,'button-cleared small s_cancel')]//*[name()='svg']")
    private WebElement closeWindow;

    public WebElement getEducated() {
        return educated;
    }

    public EducatedMainPageElements(WebDriver driver) {
        super(driver);
    }

    //Move page
    @Step("Step: Educated move")
    public EducatedMainPageElements clickPage(WebElement main, WebElement page) {
        Allure.step("Move to ETF trading");
        try {
            fluentWaitLocators(main);
            new Actions(getDriver())
                    .pause(Duration.ofSeconds(1))
                    .moveToElement(main)
                    .pause(Duration.ofSeconds(1))
                    .perform();
            fluentWaitLocators(page);
            page.click();
            return this;
        } catch (NoSuchElementException e) {
            throw new TestAbortedException("Test Skipped: ETF trading not found. For tests on language the page Education->ETF trading doesn't exist on production");
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------
    public void fluentWaitLocators(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(1))
                .pollingEvery(Duration.ofSeconds(40))
                .ignoring(ElementNotInteractableException.class);
        //wait.until(driver -> {
        //    return webElement;
        // });
        //wait.until(driver -> webElement.isDisplayed());
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement getEtfTrading() {
        return etfTrading;
    }

    public WebElement getCookie() {
        return cookie;
    }

    public WebElement getCloseWindow() {
        return closeWindow;
    }

}

