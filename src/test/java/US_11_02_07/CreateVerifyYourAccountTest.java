package US_11_02_07;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.example.manage_elements.EducatedMove;
import org.example.manage_elements.ElementsCheck;
import org.example.move_page.MovePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.SelenideConfiguration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import static settings.SeleniumConfiguration.getDriver;

public class CreateVerifyYourAccountTest extends SelenideConfiguration {
    EducatedMove smoke = new EducatedMove(getDriver());
    MovePage move = new EducatedMove(getDriver());
    ElementsCheck locators = new ElementsCheck(getDriver());

    @ParameterizedTest
    @Disabled
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create & verify your account]")
    @DisplayName("TC_11-02-07_06 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void startTradingUnReg(String languages, String countries) throws InterruptedException {
        openPage(languages, countries);
        $(smoke.getCookie()).shouldBe(visible).click();
        $(smoke.getCloseWindow()).shouldBe(visible).click();
        $(smoke.getEducated()).click();
        $(smoke.getEtfTrading()).click();
        $(smoke.getCreateVerifyYourAccountTest()).scrollIntoView(true);
        $(smoke.getCreateVerifyYourAccountTest()).click();
        $(locators.getNameSignUp()).shouldBe(Condition.visible);
    }
}
