package US_11_02_07;

import io.qameta.allure.*;
import org.example.manage_elements.EducatedMainPageElements;
import org.example.manage_elements.LogInFormElements;
import org.example.manage_elements.PageCheckElements;
import org.example.move_page.MovePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.SeleniumConfiguration;
import settings.TestListener;

@ExtendWith(TestListener.class)
public class TradeOnWidgetTest extends SeleniumConfiguration {
    EducatedMainPageElements smoke = new EducatedMainPageElements(getDriver());
    MovePage move = new EducatedMainPageElements(getDriver());
    PageCheckElements locators = new PageCheckElements(getDriver());
    LogInFormElements logIn = new LogInFormElements(getDriver());

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
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        move.clickPage(smoke.getEducated(), smoke.getEtfTrading());
        checkWindow();

        randomElement();
        scrollAndClickElement(getRandomElement(), locators.getWidget());
        Assertions.assertAll("Failed: Opened a 'Login' form instead of a 'SignUp' form (UnReg)",
                () ->
                        Assertions.assertTrue(locators.getNameSignUp().isDisplayed(), "Name SignUp field is not displayed"),
                () ->
                        Assertions.assertTrue(locators.getLinkLogin().isDisplayed(), "Login link is not displayed"),
                () ->
                        Assertions.assertTrue(locators.getInputSignUpEmail().isDisplayed(), "SignUp Email input is not displayed"),
                () ->
                        Assertions.assertTrue(locators.getInputSignUpPassword().isDisplayed(),"SignUp Password input is not displayed"),
                () ->
                        Assertions.assertTrue(locators.getButtonSignUpContinue().isDisplayed(), "SignUp Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(locators.getLinkPrivate().isDisplayed(), "Private link is not displayed")
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
        move.clickPage(smoke.getEducated(), smoke.getEtfTrading());

        randomElement();
        scrollAndClickElement(getRandomElement(), locators.getWidget());

        Assertions.assertAll("Failed: Trade element is not active on the platform (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"), "Platform is not displayed"),
                () ->
                        Assertions.assertTrue(locators.getLogo2().isDisplayed(), "Logo is not displayed"),
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

        move.clickPage(smoke.getEducated(), smoke.getEtfTrading());

        randomElement();
        scrollAndClickElement(getRandomElement(), locators.getWidget());

        Assertions.assertAll("Failed: Opened a 'SignUp' form instead of a 'LogIn' form (UnAuth)",
                () ->
                        Assertions.assertTrue(logIn.getNameLogIn().isDisplayed(), "Login is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getLinkSignUp().isDisplayed(), "Link SignUp is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getInputEmail().isDisplayed(), "Email input is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getInputPassword().isDisplayed(), "Password input is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getLinkForgotPassword().isDisplayed(), "Password forgot link is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getButtonContinue().isDisplayed(), "Continue button is not displayed"),
                () ->
                        Assertions.assertTrue(logIn.getCheckBox().isDisplayed(), "CheckBox is not displayed")
        );
    }
}
