package US_11_02_07;

import io.qameta.allure.*;
import org.example.manage_elements.ElementsCheck;
import org.example.manage_elements.EducatedMove;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.SeleniumConfiguration;
import settings.TestListener;

@ExtendWith(TestListener.class)
public class LogInTest extends SeleniumConfiguration {
    EducatedMove smokeMain = new EducatedMove(getDriver());
    ElementsCheck locators = new ElementsCheck(getDriver());

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [LogIn]")
    @DisplayName("TC_11-02-07_01 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void logInUnReg(String languages, String countries) throws InterruptedException {

        precondition(languages, countries);

        smokeMain.acceptAllCookies();
        smokeMain.checkWindow();
        smokeMain.clickPage();
        smokeMain.checkWindow();

        locators.logInClick();

        Assertions.assertTrue(locators.getNameLogIn().isDisplayed());
        Assertions.assertTrue(locators.getLinkSignUp().isDisplayed());
        Assertions.assertTrue(locators.getInputEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputPassword().isDisplayed());
        Assertions.assertTrue(locators.getInputPassword().isDisplayed());
        Assertions.assertTrue(locators.getButtonContinue().isDisplayed());
        Assertions.assertTrue(locators.getCheckBox().isDisplayed());

    }

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [LogIn]")
    @DisplayName("TC_11-02-07_01 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void logInUnAuth(String languages, String countries) throws InterruptedException {

        precondition(languages, countries);

        smokeMain.acceptAllCookies();
        smokeMain.checkWindow();

        smokeMain.authorization();
        //Thread.sleep(5000);
        precondition(languages, countries);

        smokeMain.clickPage();

        locators.logInClick();

        Assertions.assertTrue(locators.getNameLogIn().isDisplayed());
        Assertions.assertTrue(locators.getLinkSignUp().isDisplayed());
        Assertions.assertTrue(locators.getInputEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputPassword().isDisplayed());
        Assertions.assertTrue(locators.getInputPassword().isDisplayed());
        Assertions.assertTrue(locators.getButtonContinue().isDisplayed());
        Assertions.assertTrue(locators.getCheckBox().isDisplayed());

    }
}
