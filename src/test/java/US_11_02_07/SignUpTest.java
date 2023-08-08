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
public class SignUpTest extends SeleniumConfiguration {
    EducatedMove smoke = new EducatedMove(getDriver());
    ElementsCheck locators = new ElementsCheck(getDriver());

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [SignUp]")
    @DisplayName("TC_11-02-07_02 (UnReg)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void signUpUnReg(String languages, String countries) throws InterruptedException {

        precondition(languages, countries);

        smoke.acceptAllCookies();
        smoke.checkWindow();
        smoke.clickPage();
        smoke.checkWindow();

        locators.signUpClick();

        Assertions.assertTrue(locators.getNameSignUp().isDisplayed());
        Assertions.assertTrue(locators.getLinkLogin().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpPassword().isDisplayed());
        Assertions.assertTrue(locators.getButtonSignUpContinue().isDisplayed());
        Assertions.assertTrue(locators.getLinkPrivate().isDisplayed());

    }

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Epic("tests.US_11_Education.11-02-07_ETF_trading")
    @Feature("US_11-02-07_ETF_trading")
    @Story("TestETFTrading")
    @Description("Check: Education > Menu Item [ETF trading] > Test button [SignUp]")
    @DisplayName("TC_11-02-07_02 (UnAuth)")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void signUpUnAuth(String languages, String countries) throws InterruptedException {

        precondition(languages, countries);

        smoke.acceptAllCookies();
        smoke.checkWindow();

        smoke.authorization();
        //Thread.sleep(5000);
        precondition(languages, countries);

        smoke.clickPage();

        locators.signUpClick();

        Assertions.assertTrue(locators.getNameSignUp().isDisplayed());
        Assertions.assertTrue(locators.getLinkLogin().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputSignUpPassword().isDisplayed());
        Assertions.assertTrue(locators.getButtonSignUpContinue().isDisplayed());
        Assertions.assertTrue(locators.getLinkPrivate().isDisplayed());

    }

}
