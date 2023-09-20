package US_11_02_07;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.MyExecutionCondition;
import settings.SeleniumConfiguration;
import settings.TestListener;

@ExtendWith({TestListener.class, MyExecutionCondition.class})
public class LogInTest extends SeleniumConfiguration {
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_01 | Testing button [LogIn]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [LogIn]")
    @DisplayName("TC_11-02-07_01 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void logInUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        getElementsCheck().logInClick();

        getAssertClass().assertLogInForm();
    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_01 | Testing button [LogIn]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [LogIn]")
    @DisplayName("TC_11-02-07_01 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void logInUnAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();

        authorization();
        logoutClick();
        Thread.sleep(5000);

        postAuthorization();

        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        getElementsCheck().logInClick();

        getAssertClass().assertLogInForm();
    }
}
