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
    @FindBy(xpath = "//*[text()=' Tesla ']")
    private WebElement elementPlatformTesla;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Tesla']")
    private WebElement elementActiveTesla;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='AMC']")
    private WebElement elementActiveAmc;
    @FindBy(xpath = "//*[text()=' AMC ']")
    private WebElement elementPlatformAmc;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Nvidia']")
    private WebElement elementActiveNvidia;
    @FindBy(xpath = "//*[text()=' Nvidia ']")
    private WebElement elementPlatformNvidia;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='AMD']")
    private WebElement elementActiveAmd;
    @FindBy(xpath = "//*[text()=' AMD ']")
    private WebElement elementPlatformAmd;
    @FindBy(xpath = "//div[@class='state-item-button active selected']//div[text()='Apple']")
    private WebElement elementActiveApple;
    @FindBy(xpath = "//*[text()=' Apple ']")
    private WebElement elementPlatformApple;
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
}
