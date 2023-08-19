package US_11_02_07;

import io.qameta.allure.*;
import org.example.manage_elements.EducatedMove;
import org.example.manage_elements.ElementsCheck;
import org.example.move_page.MovePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.SeleniumConfiguration;

public class TradeOnWidgetTest extends SeleniumConfiguration {
    EducatedMove smoke = new EducatedMove(getDriver());
    MovePage move = new EducatedMove(getDriver());
    ElementsCheck locators = new ElementsCheck(getDriver());

    @ParameterizedTest
    @Disabled
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Trade] on Widget 'Most Traded'")
    @DisplayName("TC_11-02-07_05 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tradeUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        move.clickPage(smoke.getEducated(), smoke.getEtfTrading());
        checkWindow();

        randomElement();
        scrollAndClickElement(getRandomElement());
        Assertions.assertAll("TC_11-02-07_05 (UnReg) check",
                () ->
                        Assertions.assertTrue(locators.getNameSignUp().isDisplayed()),
                () ->
                        Assertions.assertTrue(locators.getLinkLogin().isDisplayed()),
                () ->
                        Assertions.assertTrue(locators.getInputSignUpEmail().isDisplayed()),
                () ->
                        Assertions.assertTrue(locators.getInputSignUpPassword().isDisplayed()),
                () ->
                        Assertions.assertTrue(locators.getButtonSignUpContinue().isDisplayed()),
                () ->
                        Assertions.assertTrue(locators.getLinkPrivate().isDisplayed())
        );

    }
}