package org.example.manage_elements;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlatformTradingViewElements extends AbstractPage {
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

    public WebElement getHdrIcon() {
        return hdrIcon;
    }
}
