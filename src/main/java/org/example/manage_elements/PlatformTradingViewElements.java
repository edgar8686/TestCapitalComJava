package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlatformTradingViewElements extends AbstractPage {
    //logout
    @FindBy(css = ".iconex-arrow-down-mini.icon-square.arrow-down")
    private WebElement buttonLive;
    @FindBy(css = "div[data-qa='logout']")
    private WebElement logout;
    //----------------------------------------------------------------------------------
    //Surfaced window
    @FindBy(css = "button[class='iconex-close-small icon-square modal__header-btn']")
    private WebElement iconClose;
    @FindBy(css = "button[class='solid default large']")
    private WebElement ok;
    //-----------------------------------------------------------------------------------
    //Elements platform
    @FindBy(xpath = "//*[text()=' Tesla Inc (Extended Hours) ']")
    private WebElement elementPlatformTesla;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Tesla Inc (Extended Hours)']")
    private WebElement elementActiveTesla;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='AMC Entertainment Holdings Inc (Extended Hours)']")
    private WebElement elementActiveAmc;
    @FindBy(xpath = "//*[text()=' AMC Entertainment Holdings Inc (Extended Hours) ']")
    private WebElement elementPlatformAmc;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='NVIDIA Corp (Extended Hours)']")
    private WebElement elementActiveNvidia;
    @FindBy(xpath = "//*[text()=' NVIDIA Corp (Extended Hours) ']")
    private WebElement elementPlatformNvidia;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Advanced Micro Devices Inc (Extended Hours)']")
    private WebElement elementActiveAmd;
    @FindBy(xpath = "//*[text()=' Advanced Micro Devices Inc (Extended Hours) ']")
    private WebElement elementPlatformAmd;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Apple Inc (Extended Hours)']")
    private WebElement elementActiveApple;
    @FindBy(xpath = "//*[text()=' Apple Inc (Extended Hours) ']")
    private WebElement elementPlatformApple;
    //Auth check
    @FindBy(css = "object[class='logo__icon']")
    private WebElement logo;
    @FindBy(css = ".logo")
    private WebElement logo2;
    @FindBy(xpath = "//div[@class='account__mode account__mode_demo']")
    private WebElement accountDemo;
    public PlatformTradingViewElements(WebDriver driver) {
        super(driver);
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

    public WebElement getElementPlatformTesla() {
        return elementPlatformTesla;
    }

    public WebElement getElementActiveTesla() {
        return elementActiveTesla;
    }

    public WebElement getElementActiveAmc() {
        return elementActiveAmc;
    }

    public WebElement getElementPlatformAmc() {
        return elementPlatformAmc;
    }

    public WebElement getElementActiveNvidia() {
        return elementActiveNvidia;
    }

    public WebElement getElementPlatformNvidia() {
        return elementPlatformNvidia;
    }

    public WebElement getElementActiveAmd() {
        return elementActiveAmd;
    }

    public WebElement getElementPlatformAmd() {
        return elementPlatformAmd;
    }

    public WebElement getElementActiveApple() {
        return elementActiveApple;
    }

    public WebElement getElementPlatformApple() {
        return elementPlatformApple;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getLogo2() {
        return logo2;
    }

    public WebElement getAccountDemo() {
        return accountDemo;
    }
}
