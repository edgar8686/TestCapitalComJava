package settings;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Dimension;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public abstract class SeleniumConfiguration {
    private static WebDriver driver;
    static String baseUrl = "https://capital.com/";
    Set<Cookie> cookies;
    static final Dimension windowSize = new Dimension(1800, 800);

    @BeforeAll
    static void init() throws MalformedURLException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions optionsChrome = new ChromeOptions();
        //options.setPlatformName("Windows 10");
        //options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        optionsChrome.addArguments("--headless");
        optionsChrome.setHeadless(true);
        //options.addArguments("start-maximized");
        //options.addArguments("--remote-allow-origins=*");
        optionsChrome.addArguments("--lang=en");


        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        //options.setPlatformName("Windows 10");
        //options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        optionsFirefox.addArguments("--headless");
        optionsFirefox.setHeadless(true);
        //options.addArguments("start-maximized");
        //options.addArguments("--remote-allow-origins=*");
        optionsFirefox.addArguments("--lang=en");

        WebDriverManager.edgedriver().setup();
        EdgeOptions optionsEdge = new EdgeOptions();
        //options.setPlatformName("Windows 10");
        //options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        optionsEdge.addArguments("--headless");
        optionsEdge.setHeadless(true);
        //options.addArguments("start-maximized");
        //options.addArguments("--remote-allow-origins=*");
        optionsEdge.addArguments("--lang=en");
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(optionsChrome);
                System.out.println("Start on chrome");
                Allure.addAttachment("Browser", "Start on chrome");
                break;
            case "firefox":
                driver = new FirefoxDriver(optionsFirefox);
                System.out.println("Start on firefox");
                Allure.addAttachment("Browser", "Start on firefox");
                break;
            case "edge":
                driver = new EdgeDriver(optionsEdge);
                System.out.println("Start on edge");
                Allure.addAttachment("Browser", "Start on edge");
                break;
            default:
                Allure.addAttachment("IllegalArgumentException", "Invalid browser name: " + browser);
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }

        driver.manage().window().setSize(windowSize);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void close() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            System.out.println("Cookies deleted");
            driver.close();
            System.out.println("The browser is closed");
            driver.quit();
            System.out.println("The driver is quit");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public void precondition(String languages, String countries) {
        String absoluteUrl = baseUrl + (languages.equalsIgnoreCase("en") ? "" : languages) + countries;
        getDriver().navigate().to(absoluteUrl);
        // if (languages.equalsIgnoreCase("en")) {
        //  String absolutUrl = baseUrl + countries;
        //getDriver().navigate().to(absolutUrl);
        //  } else {
        // String absolutUrl = baseUrl + languages + countries;
        // getDriver().navigate().to(absolutUrl);
        // }
    }

    public void unAuthorizationStart(String languages, String countries) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
}
