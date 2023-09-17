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
public class TryDemoTest extends SeleniumConfiguration {
    //EducatedMainPageElements smoke = new EducatedMainPageElements(getDriver());
   // MovePage move = new EducatedMainPageElements(getDriver());
    //PageCheckElements locators = new PageCheckElements(getDriver());
    //LogInFormElements logIn = new LogInFormElements(getDriver());

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_04 | Testing button [TryDemo]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [TryDemo]")
    @DisplayName("TC_11-02-07_04 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tryDemoUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        getElementsCheck().tryDemoClick();
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
    @Story("TC_11.02.07_04 | Testing button [TryDemo]")
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
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        getElementsCheck().tryDemoClick();

        Assertions.assertAll("Failed: Trade element is not opened (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"),"Platform title is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getAccountDemo().isDisplayed(),"Demo button is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getLogo().isDisplayed(),"Logo is not displayed")
        );

    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_04 | Testing button [TryDemo]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [TryDemo]")
    @DisplayName("TC_11-02-07_04 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void tryDemoUnAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();

        authorization();
        logoutClick();
        Thread.sleep(5000);
        postAuthorization();

        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        getElementsCheck().tryDemoClick();

        Assertions.assertAll("Failed: Opened a 'SignUp' form instead of a 'Login' form (UnAuth)",
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
