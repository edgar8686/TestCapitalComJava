package org.example.manage_elements;

import io.qameta.allure.Allure;
import org.example.abstractClass.AbstractPage;
import org.example.move_page.MovePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.opentest4j.TestSkippedException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class EducatedMove extends AbstractPage implements MovePage<EducatedMove> {
    static String baseUrl = "https://capital.com/";
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
    @FindBy(css = ".regSteps__item.js_signup.js-analyticsClick.js-analyticsVisible")
    private WebElement createVerifyYourAccountTest;
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
    @FindBy(css = "input[class='fieldDropdown__control fieldDropdown__control--hidden']")
    private WebElement dropDownCountry;
    @FindBy(css = "input[class='fieldDropdown__control js-countriesSearchInput']")
    private WebElement searchCountry;
    @FindBy(css = ".gI.gXs.gCenter.js-switchCountry")
    private WebElement selectCountry;
    @FindBy(css = "a[data-iid='22855552501634244']")
    private WebElement tesla;
    @FindBy(css = "a[data-iid='16150730595456196']")
    private WebElement nvidia;
    @FindBy(css = "a[data-iid='21178483823812']")
    private WebElement amc;
    @FindBy(css = "a[data-iid='21182778791108']")
    private WebElement amd;
    @FindBy(css = "a[data-iid='1147941679092932']")
    private WebElement apple;


    public WebElement getEducated() {
        return educated;
    }

    public EducatedMove(WebDriver driver) {
        super(driver);
    }

    //--------------------------------------------------------------------------------------------------------------------
    //Move page
    public EducatedMove clickPage(WebElement main, WebElement page) {

        try {
            fluentWaitLocators(main);
            new Actions(getDriver())
                    .moveToElement(main)
                    .perform();
            fluentWaitLocators(page);
            page.click();
            return this;
        } catch (NoSuchElementException e) {
            throw new TestSkippedException("Test Skipped: ETF trading not found. For tests on language the page Education->ETF trading doesn't exist on production");
        }
    }

    //-------------------------------------------------------------------------------------------------------------------------
    public void fluentWaitLocators(WebElement webElement) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(java.util.NoSuchElementException.class);
        //wait.until(driver -> {
        //    return webElement;
        // });
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void randomElementClick() {
        Random random = new Random();

        ArrayList<WebElement> elements = new ArrayList<>();
        elements.add(tesla);
        elements.add(nvidia);
        elements.add(amc);
        elements.add(amd);
        elements.add(apple);

        int randomIndex = random.nextInt(elements.size());
        WebElement randomElement = elements.get(randomIndex);

        Actions actions = new Actions(getDriver());
        actions.moveToElement(randomElement)
                .click()
                .perform();

        System.out.println("Случайный элемент: " + randomElement);
    }


    public static String getBaseUrl() {
        return baseUrl;
    }

    public WebElement getEtfTrading() {
        return etfTrading;
    }

    public WebElement getCookie() {
        return cookie;
    }

    public WebElement getSignUpForm() {
        return signUpForm;
    }

    public WebElement getEmail() {
        return email;
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

    public WebElement getCreateVerifyYourAccountTest() {
        return createVerifyYourAccountTest;
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

    public WebElement getSelectCountry() {
        return selectCountry;
    }
}

