package US_11_02_07;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.MyExecutionCondition;
import settings.SeleniumConfiguration;
import settings.TestListener;
import settings.Name;

@ExtendWith({TestListener.class, MyExecutionCondition.class})
public class StartTradingTest extends SeleniumConfiguration {
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.01.01_03 | Testing button [StartTrading]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [StartTrading]")
    @Name(displayName = "TC_11-02-07_03 (UnReg)")
    @DisplayName("TC_11-02-07_03 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void startTradingUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        getElementsCheck().startTradingClick();

        getAssertClass().assertSignUpForm();
    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: Auth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_03 | Testing button [StartTrading]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [StartTrading]")
    @Name(displayName = "TC_11-02-07_03 (Auth)")
    @DisplayName("TC_11-02-07_03 (Auth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void startTradingAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        authorization();

        postAuthorization();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        getElementsCheck().startTradingClick();

        getAssertClass().assertPlatformPage();
    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_03 | Testing button [StartTrading]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [StartTrading]")
    @Name(displayName = "TC_11-02-07_03 (UnAuth)")
    @DisplayName("TC_11-02-07_03 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void StartTradingUnAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();

        authorization();
        logoutClick();
        Thread.sleep(5000);
        postAuthorization();

        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        getElementsCheck().startTradingClick();

        getAssertClass().assertLogInForm();
    }
}
