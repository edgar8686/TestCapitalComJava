package settings;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public abstract class SelenideConfiguration {
    static String baseUrl = "https://capital.com/";
    @BeforeAll
    public static void start() {
        Configuration.browser = "Chrome";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        //Configuration.headless = true;
        Configuration.timeout = 5000;
        //Configuration.remote = "http://selenoid-host:4444/wd/hub";
        Configuration.browserSize = "1800x800";
    }

    public void openPage(String languages, String countries) {
        String absoluteUrl = baseUrl + (languages.equalsIgnoreCase("en") ? "" : languages) + countries;
        open(absoluteUrl);
    }

}
