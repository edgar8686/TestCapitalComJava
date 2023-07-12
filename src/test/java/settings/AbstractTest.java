package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setPlatformName("Windows 10");
        options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    // @BeforeEach
    // void goTo() {
    //  driver.get("https://capital.com/");
    //}

    @AfterAll
    static void close() {
        if (driver != null)
            driver.manage().deleteAllCookies();
        driver.close();
        System.out.println("The browser is closed");
        driver.quit();
        System.out.println("The driver is quit");
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Step
    public void getUrl(String languages, String countries) {

        if (languages.equalsIgnoreCase("en")) {
            getDriver().get("https://capital.com/" + countries);
        } else {
            getDriver().get("https://capital.com/" + languages + countries);
        }
    }
}
