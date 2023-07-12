package US_11_02_07;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.example.elements.Locators;
import org.example.elements.SmokeMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import settings.AbstractTest;
import settings.TestListener;

@ExtendWith(TestListener.class)
public class LogInTest extends AbstractTest {

    @ParameterizedTest
    @Owner("Edgar Nurmagomedov")
    @Feature("US_11_02_07")
    @DisplayName("LogIn test")
    @CsvFileSource(files = "src/test/resources/Precondition.csv", numLinesToSkip = 1)
    void LogIn(String languages, String countries) {
        SmokeMain smokeMain = new SmokeMain(getDriver());

        getUrl(languages, countries);

        smokeMain.acceptAllCookies();
        smokeMain.checkWindow();
        smokeMain.clickETFTrading();
        smokeMain.checkWindow();

        Locators locators = new Locators(getDriver())
                .logInClick();

        Assertions.assertTrue(locators.getNameLogIn().isDisplayed());
        Assertions.assertTrue(locators.getLinkSignUp().isDisplayed());
        Assertions.assertTrue(locators.getInputEmail().isDisplayed());
        Assertions.assertTrue(locators.getInputPassword().isDisplayed());
        Assertions.assertTrue(locators.getLinkForgotPassword().isDisplayed());
        Assertions.assertTrue(locators.getCheckBox().isDisplayed());

        //smokeMain.closeLogInForm();
       // smokeMain.goBackMainPage();
    }

}
