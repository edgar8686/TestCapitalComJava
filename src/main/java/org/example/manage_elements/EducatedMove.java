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
import org.opentest4j.TestSkippedException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class EducatedMove extends AbstractPage implements MovePage<EducatedMove> {
    @FindBy(css = "a[data-type='nav_id96']")
    private WebElement educated;
    @FindBy(xpath = "//a[contains(@data-type,'nav_id243')]")
    private WebElement etfTrading;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement cookie;
    @FindBy(xpath = "//button[contains(@class,'button-cleared small s_cancel')]//*[name()='svg']")
    private WebElement closeWindow;
    //------------------------------------------------------------------------------------
    // platform elements
    @FindBy(css = ".iconex-arrow-down-mini.icon-square.arrow-down")
    private WebElement buttonLive;
    @FindBy(css = "div[data-qa='logout']")
    private WebElement logout;
    @FindBy(css = "button[class='iconex-close-small icon-square modal__header-btn']")
    private WebElement iconClose;
    @FindBy(css = "button[class='solid default large']")
    private WebElement ok;
    @FindBy(css = ".licLangSw__btn.gI.gCenter.gXs.js-licLangSwBtn.js-countries")
    private WebElement hdrIcon;
    //------------------------------------------------------------------------------
    //Choice country
    @FindBy(css = "input[class='fieldDropdown__control fieldDropdown__control--hidden']")
    private WebElement dropDownCountry;
    @FindBy(css = "input[class='fieldDropdown__control js-countriesSearchInput js-fieldDropdownFilterSearch']")
    private WebElement searchCountry;
    @FindBy(css = ".licLangSw__countries.grid.gXs.js-countriesList")
    private WebElement countryList;
    @FindBy(css = "a[data-country='gb']")
    private WebElement countryGb;
    @FindBy(css = "a[data-country='hu']")
    private WebElement countryHu;
    @FindBy(css = "a[data-country='de']")
    private WebElement countryDe;


    public WebElement getEducated() {
        return educated;
    }

    public EducatedMove(WebDriver driver) {
        super(driver);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Move page
    @Step("Step: Educated move")
    public EducatedMove clickPage(WebElement main, WebElement page) {
        Allure.step("Move to ETF trading");
        try {
            fluentWaitLocators(main);
            new Actions(getDriver())
                    .moveToElement(main)
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
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(40))
                .ignoring(ElementNotInteractableException.class);
        //wait.until(driver -> {
        //    return webElement;
        // });
        wait.until(driver -> webElement.isDisplayed());
        // wait.until(ExpectedConditions.elementToBeClickable(webElement));
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

    public WebElement getButtonLive() {
        return buttonLive;
    }

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getIconClose() {
        return iconClose;
    }

    public WebElement getOk() {
        return ok;
    }


    public WebElement getHdrIcon() {
        return hdrIcon;
    }

    public WebElement getDropDownCountry() {
        return dropDownCountry;
    }

    public WebElement getSearchCountry() {
        return searchCountry;
    }

    public WebElement getCountryList() {
        return countryList;
    }

    public WebElement getCountryGb() {
        return countryGb;
    }

    public WebElement getCountryHu() {
        return countryHu;
    }

    public WebElement getCountryDe() {
        return countryDe;
    }
}

