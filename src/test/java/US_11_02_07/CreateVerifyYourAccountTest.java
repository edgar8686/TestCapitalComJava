package US_11_02_07;

import io.qameta.allure.*;
import org.example.manage_elements.EducatedMainPageElements;
import org.example.manage_elements.PageCheckElements;
import org.example.move_page.MovePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.MyExecutionCondition;
import settings.SeleniumConfiguration;
import settings.TestListener;

@ExtendWith({TestListener.class, MyExecutionCondition.class})
public class CreateVerifyYourAccountTest extends SeleniumConfiguration {
    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Tag("us_11_02_07")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_06 | Testing button [Create & verify your account]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create & verify your account]")
    @DisplayName("TC_11-02-07_06 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createVerifyYourAccountUnReg(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());
        checkWindow();

        scrollAndClickElement(getElementsCheck().getCreateVerifyYourAccount(), getElementsCheck().getCreateVerifyYourAccount());
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
    @Story("TC_11.02.07_06 | Testing button [Create & verify your account]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create & verify your account]")
    @DisplayName("TC_11-02-07_06 (Auth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createVerifyYourAccountAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();
        authorization();

        postAuthorization();
        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        scrollAndClickElement(getElementsCheck().getCreateVerifyYourAccount(), getElementsCheck().getCreateVerifyYourAccount());
        Assertions.assertAll("Failed: Platform is not opened (Auth)",
                () ->
                        Assertions.assertTrue(getDriver().getTitle().endsWith("| Capital.com"), "Platform title is not displayed"),
                () ->
                        Assertions.assertTrue(getElementsCheck().getLogo().isDisplayed(), "Logo is not displayed")
        );
    }

    @ParameterizedTest
    @Tag("us_11_02_07")
    @Owner("Edgar Nurmagomedov")
    @Epic("US_11_Education 11-02-07_ETF_trading")
    @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")
    @Story("TC_11.02.07_06 | Testing button [Create & verify your account]")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [Create & verify your account]")
    @DisplayName("TC_11-02-07_06 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void createVerifyYourAccountUnAuth(String languages, String countries) throws InterruptedException {
        deleteCookies();
        precondition(languages, countries);

        acceptAllCookies();
        checkWindow();

        authorization();
        logoutClick();
        Thread.sleep(5000);
        postAuthorization();

        getMove().clickPage(getEducatedMove().getEducated(), getEducatedMove().getEtfTrading());

        scrollAndClickElement(getElementsCheck().getCreateVerifyYourAccount(), getElementsCheck().getCreateVerifyYourAccount());
        Assertions.assertAll("Failed: Opened a 'Login' form instead of a 'SignUp' form (UnAuth)",
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
}
