package settings;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.example.manage_elements.EducatedMove;
import org.example.manage_elements.ElementsCheck;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Set;

public abstract class SeleniumConfiguration {
    private static WebDriver driver;
    static String baseUrl = "https://capital.com/";
    static String absoluteUrl;
    Set<Cookie> cookies;
    static final Dimension windowSize = new Dimension(1800, 800);
    EducatedMove educatedMove = new EducatedMove(getDriver());

    @BeforeAll
    static void init() throws MalformedURLException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions optionsChrome = new ChromeOptions();
        //options.setPlatformName("Windows 10");
        //options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        //optionsChrome.addArguments("--headless");
        //optionsChrome.setHeadless(true);
        //options.addArguments("start-maximized");
        //options.addArguments("--remote-allow-origins=*");
        optionsChrome.addArguments("--lang=en");


        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        //options.setPlatformName("Windows 10");
        //options.setBrowserVersion("114");
        //options.addArguments("--incognito");
        //optionsFirefox.addArguments("--headless");
        //optionsFirefox.setHeadless(true);
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
            System.out.println("Cookies are deleted");
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
        if (languages.equalsIgnoreCase("en")) {
            absoluteUrl = baseUrl;
            getDriver().navigate().to(absoluteUrl);
            new Actions(getDriver())
                    .moveToElement(educatedMove.getHdrIcon())
                    .pause(Duration.ofSeconds(1))
                    .click(educatedMove.getDropDownCountry())
                    .pause(Duration.ofSeconds(1))
                    .sendKeys(educatedMove.getSearchCountry(), countries)
                    .pause(Duration.ofSeconds(4))
                    .perform();
            educatedMove.getSelectCountry().click();


        } else {
            absoluteUrl = baseUrl + languages;
            getDriver().navigate().to(absoluteUrl);
            new Actions(getDriver())
                    .moveToElement(educatedMove.getHdrIcon())
                    .pause(Duration.ofSeconds(1))
                    .click(educatedMove.getDropDownCountry())
                    .pause(Duration.ofSeconds(1))
                    .sendKeys(educatedMove.getSearchCountry(), countries)
                    .pause(Duration.ofSeconds(3))
                    .perform();
            educatedMove.getSelectCountry().click();
        }


    }

    public void acceptAllCookies() throws InterruptedException {
        try {
            Thread.sleep(5000);
            educatedMove.fluentWaitLocators(educatedMove.getCookie());
            if (educatedMove.getCookie().isDisplayed()) {
                educatedMove.getCookie().click();
                System.out.println("All cookies accepted");
            }
        } catch (TimeoutException a) {
            System.out.println("All cookies have been accepted");
        } catch (NoSuchElementException e) {
            System.out.println("All cookies have been accepted");
        }
    }

    public void checkWindow() {
        try {
            if (educatedMove.getCloseWindow().isDisplayed()) {
                educatedMove.getCloseWindow().click();
                System.out.println("The SignUp form is closed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("SignUp form is not surfaced");
        }
    }

    public void checkButtonIconClose() {
        try {
            educatedMove.fluentWaitLocators(educatedMove.getIconClose());
            if (educatedMove.getIconClose().isDisplayed()) {
                educatedMove.getIconClose().click();
                System.out.println("The button [iconClose] is closed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The button [iconClose] dis not surfaced");
        }
    }


    public void authorization() throws InterruptedException {
        ElementsCheck check = new ElementsCheck(getDriver());
        Allure.addAttachment("Email", "aqa.tomelo.an@gmail.com");
        Allure.addAttachment("Password", "iT9Vgqi6d$fiZ*Z");
        educatedMove.fluentWaitLocators(check.getTrade());
        check.getTrade().click();
        Thread.sleep(1000);
        check.getInputSignUpEmail().sendKeys("aqa.tomelo.an@gmail.com");
        Thread.sleep(1000);
        check.getInputSignUpPassword().sendKeys("iT9Vgqi6d$fiZ*Z");
        educatedMove.fluentWaitLocators(check.getButtonSignUpContinueIncluded());
        check.getButtonSignUpContinueIncluded().click();
        // Thread.sleep(20000);
        checkButtonIconClose();
    }

    public void postAuthorization() {
        getDriver().navigate().to(absoluteUrl);


    }

    public void logoutClick() {
        educatedMove.fluentWaitLocators(educatedMove.getButtonLive());
        educatedMove.getButtonLive().click();
        educatedMove.getLogout().click();
    }

    public void deleteCookies() {
        getDriver().manage().deleteAllCookies();
    }


    public void unAuthorizationStart(String languages, String countries) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
        driver.navigate().refresh();
    }
    //Динамически изменяет элемент
    // public SelenideElement getDynamicElement(String dynamicValue) {
    //  String dynamicLocator = String.format("#%s", dynamicValue);
    //  return $(dynamicLocator);

    // MyPage myPage = new MyPage();
    //SelenideElement element = myPage.getDynamicElement("my-dynamic-element");
//element.click();
    //}
}
