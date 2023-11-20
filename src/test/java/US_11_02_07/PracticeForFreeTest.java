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
public class PracticeForFreeTest extends SeleniumConfiguration {
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.01.01_10 | Testing button [Practice for free]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Practice for free]")
    @DisplayName("TC_11-02-07_10 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createAccountUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        scrollAndClickElement(getElementsCheck().getFreeDemoAccount(), getElementsCheck().getFreeDemoAccount());

        getAssertClass().assertSignUpPage();
    }
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: Auth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_10 | Testing button [Practice for free]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [FPractice for free]")
    @DisplayName("TC_11-02-07_10 (Auth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createAccountAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        authorization();

        postAuthorization();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        scrollAndClickElement(getElementsCheck().getFreeDemoAccount(), getElementsCheck().getFreeDemoAccount());

        getAssertClass().assertPlatformPage();
    }
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_09 | Testing button [Free Trial]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Free Trial]")
    @DisplayName("TC_11-02-07_09 (UnAuth)")
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

        scrollAndClickElement(getElementsCheck().getFreeDemoAccount(), getElementsCheck().getFreeDemoAccount());

        getAssertClass().assertLogInPage();
    }
}
