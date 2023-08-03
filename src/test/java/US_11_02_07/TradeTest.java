package US_11_02_07;

import io.qameta.allure.*;
import org.example.elements.LocatorsCheck;
import org.example.elements.EducatedMove;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.Settings;
import settings.TestListener;

@ExtendWith(TestListener.class)
public class TradeTest extends Settings {
    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Trade]")
    @DisplayName("TC_11-02-07_02 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tradeUnReg(String languages, String countries) {

        EducatedMove smoke = new EducatedMove(getDriver());
        precondition(languages, countries);

        smoke.acceptAllCookies();
        smoke.checkWindow();
        smoke.clickETFTrading();
        smoke.checkWindow();

        LocatorsCheck locators = new LocatorsCheck(getDriver())
                .tradeClick();

        Assertions.assertTrue(locators.getNameSignUp().isDisplayed());
        Assertions.assertTrue(locators.getLinkLogin().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpPassword().isDisplayed());
        Assertions.assertTrue(locators.getButtonSignUpContinue().isDisplayed());
        Assertions.assertTrue(locators.getLinkPrivate().isDisplayed());

    }
    @ParameterizedTest
    @Disabled
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Trade]")
    @DisplayName("TC_11-02-07_02 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tradeUnAuth(String languages, String countries) {

        EducatedMove smoke = new EducatedMove(getDriver());
        precondition(languages, countries);

        smoke.acceptAllCookies();
        smoke.checkWindow();
        authorization();
        driverClose();
        unAuthorizationStart(languages, countries);
        smoke.clickETFTrading();
        smoke.checkWindow();

        LocatorsCheck locators = new LocatorsCheck(getDriver())
                .tradeClick();

        Assertions.assertTrue(locators.getNameSignUp().isDisplayed());
        Assertions.assertTrue(locators.getLinkLogin().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpPassword().isDisplayed());
        Assertions.assertTrue(locators.getButtonSignUpContinue().isDisplayed());
        Assertions.assertTrue(locators.getLinkPrivate().isDisplayed());

    }

}
