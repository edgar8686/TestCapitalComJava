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

@ExtendWith({TestListener.class, MyExecutionCondition.class})
public class CreateAccountTest extends SeleniumConfiguration {
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.01.01_07 | Testing button [Create account]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create account]")
    @DisplayName("TC_11-02-07_07 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createAccountUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        scrollAndClickElement(getElementsCheck().getCreateAccount(), getElementsCheck().getCreateAccount());

        getAssertClass().assertSignUpPage();
    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: Auth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_07 | Testing button [Create account]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create account]")
    @DisplayName("TC_11-02-07_07 (Auth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createAccountAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        authorization();

        postAuthorization();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        scrollAndClickElement(getElementsCheck().getCreateAccount(), getElementsCheck().getCreateAccount());

        getAssertClass().assertPlatformPage();
    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_07 | Testing button [Create account]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create account]")
    @DisplayName("TC_11-02-07_07 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createAccountUnAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();

        authorization();
        logoutClick();
        Thread.sleep(5000);
        postAuthorization();

        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        scrollAndClickElement(getElementsCheck().getCreateAccount(), getElementsCheck().getCreateAccount());

        getAssertClass().assertLogInPage();
    }
}
