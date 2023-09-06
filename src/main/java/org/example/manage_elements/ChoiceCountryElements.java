package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChoiceCountryElements extends AbstractPage {
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
    @FindBy(css = "a[data-country='es']")
    private WebElement countryEs;
    @FindBy(css = "a[data-country='fr']")
    private WebElement countryFr;
    @FindBy(css = "a[data-country='pl']")
    private WebElement countryPl;
    @FindBy(css = "a[data-country='hk']")
    private WebElement countryHk;
    public ChoiceCountryElements(WebDriver driver) {
        super(driver);
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

    public WebElement getCountryEs() {
        return countryEs;
    }

    public WebElement getCountryFr() {
        return countryFr;
    }

    public WebElement getCountryPl() {
        return countryPl;
    }

    public WebElement getCountryHk() {
        return countryHk;
    }
}
