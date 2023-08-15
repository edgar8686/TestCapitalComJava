package US_11_02_07;

import io.qameta.allure.*;
import org.example.manage_elements.EducatedMove;
import org.example.manage_elements.ElementsCheck;
import org.example.move_page.MovePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.opentest4j.MultipleFailuresError;
import settings.SeleniumConfiguration;

public class TryDemoTest extends SeleniumConfiguration {
    EducatedMove smoke = new EducatedMove(getDriver());
    MovePage move = new EducatedMove(getDriver());
    ElementsCheck locators = new ElementsCheck(getDriver());

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [TryDemo]")
    @DisplayName("TC_11-02-07_04 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tryDemoUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        move.clickPage(smoke.getEducated(), smoke.getEtfTrading());
        checkWindow();

        locators.tryDemoClick();
        Assertions.assertAll("TC_11-02-07_04 (UnReg) check",
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

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [TryDemo]")
    @DisplayName("TC_11-02-07_04 (Auth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tryDemoAuth(String languages, String countries) throws InterruptedException {

        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        authorization();

        postAuthorization();
        move.clickPage(smoke.getEducated(), smoke.getEtfTrading());

        locators.startTradingClick();
        Assertions.assertAll("TC_11-02-07_04 (Auth) check",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com")),
                () ->
                        Assertions.assertTrue(locators.getLogo().isDisplayed()),
                () ->
                        Assertions.assertTrue(getDriver().getCurrentUrl().equals("https://capital.com/trading/platform/"))
        );

    }
}
