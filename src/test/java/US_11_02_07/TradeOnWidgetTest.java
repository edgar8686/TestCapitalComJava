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
public class TradeOnWidgetTest extends SeleniumConfiguration {
    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_05 | Testing button [Trade] on Widget 'Most Traded'")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Trade] on Widget 'Most Traded'")
    @DisplayName("TC_11-02-07_05 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tradeUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
       //String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //System.out.println("Текущий метод: " + currentMethodName);
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        randomElement();
        scrollAndClickElement(getRandomElement(), getElementsCheck().getWidget());
        Thread.sleep(1000);
        Assertions.assertAll("Failed: Opened a 'Login' form instead of a 'SignUp' form (UnReg)",
                () ->
                        Assertions.assertTrue(getElementsCheck().getNameSignUp().isDisplayed(), "Name SignUp field is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getLinkLogin().isDisplayed(), "Login link is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getInputSignUpEmail().isDisplayed(), "SignUp Email input is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getInputSignUpPassword().isDisplayed(),"SignUp Password input is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getButtonSignUpContinue().isDisplayed(), "SignUp Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getLinkPrivate().isDisplayed(), "Private link is not displayed")
        );

    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: Auth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_05 | Testing button [Trade] on Widget 'Most Traded'")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Trade] on Widget 'Most Traded'")
    @DisplayName("TC_11-02-07_05 (Auth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tradeAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        authorization();

        postAuthorization();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        randomElement();
        scrollAndClickElement(getRandomElement(), getElementsCheck().getWidget());

        Assertions.assertAll("Failed: Trade element is not active on the platform (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"), "Platform is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getLogo2().isDisplayed(), "Logo is not displayed"),
                () ->
                        Assertions.assertTrue(getElementPlatform().isDisplayed(), "Trade element is not displayed"),
                () ->
                        Assertions.assertTrue(getElementPlatform2().isDisplayed(), "Trade active element is not displayed")
        );

    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_05 | Testing button [Trade] on Widget 'Most Traded'")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Trade] on Widget 'Most Traded'")
    @DisplayName("TC_11-02-07_05 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tradeUnAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();

        authorization();
        logoutClick();
        Thread.sleep(5000);
        postAuthorization();

        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        randomElement();
        scrollAndClickElement(getRandomElement(), getElementsCheck().getWidget());

        Assertions.assertAll("Failed: Opened a 'SignUp' form instead of a 'LogIn' form (UnAuth)",
                () ->
                        Assertions.assertTrue(getLogIn().getNameLogIn().isDisplayed(), "Login is not displayed"),
                () ->
                        Assertions.assertTrue(getLogIn().getLinkSignUp().isDisplayed(), "Link SignUp is not displayed"),
                () ->
                        Assertions.assertTrue(getLogIn().getInputEmail().isDisplayed(), "Email input is not displayed"),
                () ->
                        Assertions.assertTrue(getLogIn().getInputPassword().isDisplayed(), "Password input is not displayed"),
                () ->
                        Assertions.assertTrue(getLogIn().getLinkForgotPassword().isDisplayed(), "Password forgot link is not displayed"),
                () ->
                        Assertions.assertTrue(getLogIn().getButtonContinue().isDisplayed(), "Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(getLogIn().getCheckBox().isDisplayed(), "CheckBox is not displayed")
        );
    }
}
