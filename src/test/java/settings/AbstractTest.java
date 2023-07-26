package settings;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Dimension;


import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {
    private static WebDriver driver;

    @BeforeAll
    static void init() {
        Dimension windowSize = new Dimension(1700, 1000);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.setPlatformName("Windows 10");
        //options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        options.addArguments("--headless");
        options.setHeadless(true);
        //options.addArguments("start-maximized");
        //options.addArguments("--remote-allow-origins=*");
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        //driver.manage().window().fullscreen();
        driver.manage().window().setSize(windowSize);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

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
