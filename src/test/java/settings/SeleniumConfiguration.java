package settings;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.example.manage_elements.ChoiceCountryElements;
import org.example.manage_elements.EducatedMainPageElements;
import org.example.manage_elements.PageCheckElements;
import org.example.manage_elements.PlatformTradingViewElements;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.opentest4j.AssertionFailedError;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public abstract class SeleniumConfiguration {
    private static WebDriver driver;
    static String baseUrl = "https://capital.com/";
    static String absoluteUrl;
    ArrayList<WebElement> elements = new ArrayList<>();
    static final Dimension windowSize = new Dimension(1800, 800);
    private EducatedMainPageElements educatedMove = new EducatedMainPageElements(getDriver());
    private PageCheckElements elementsCheck = new PageCheckElements(getDriver());
    private PlatformTradingViewElements platformElements = new PlatformTradingViewElements(getDriver());
    private ChoiceCountryElements country = new ChoiceCountryElements(getDriver());
    private WebElement randomElement;
    private WebElement elementPlatform;
    private WebElement elementPlatform2;


    @BeforeAll
    @Epics({@Epic("US_11_Education 11-02-07_ETF_trading")})
    @Features({@Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]"), @Feature("Role: Auth / TS_11.02.07 | Education > Menu Item [ETF trading]"), @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")})
    @Stories({@Story("TC_11.02.07_06 | Testing button [Create & verify your account]"), @Story("TC_11.02.07_01 | Testing button [LogIn]"), @Story("TC_11.02.07_02 | Testing button [SignUp]"), @Story("TC_11.02.07_03 | Testing button [StartTrading]"), @Story("TC_11.02.07_05 | Testing button [Trade] on Widget 'Most Traded'"), @Story("TC_11.02.07_04 | Testing button [TryDemo]")})
    @Tags({@Tag("us_11_02_07")})
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
        //optionsEdge.addArguments("--headless");
        //optionsEdge.setHeadless(true);
        //options.addArguments("start-maximized");
        //options.addArguments("--remote-allow-origins=*");
        optionsEdge.addArguments("--lang=en");
        String browser = System.getProperty("browser", "chrome");
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(optionsChrome);
                System.out.println("Start on chrome");
                Allure.addAttachment("Browser", "Chrome");
                break;
            case "firefox":
                driver = new FirefoxDriver(optionsFirefox);
                System.out.println("Start on firefox");
                Allure.addAttachment("Browser", "Firefox");
                break;
            case "edge":
                driver = new EdgeDriver(optionsEdge);
                System.out.println("Start on edge");
                Allure.addAttachment("Browser", "Edge");
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
            Allure.step("Driver is quit");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @Step("Step precondition: choice language and country")
    public void precondition(String languages, String countries) {
        Actions actions = new Actions(getDriver());
        switch (languages.toLowerCase()) {
            case "en":
                absoluteUrl = baseUrl;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryGb());
                educatedMove.fluentWaitLocators(country.getCountryGb());
                country.getCountryGb().click();
                break;
            case "hu":
                absoluteUrl = baseUrl + languages;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryHu());
                educatedMove.fluentWaitLocators(country.getCountryHu());
                country.getCountryHu().click();
                break;
            case "de":
                absoluteUrl = baseUrl + languages;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryDe());
                educatedMove.fluentWaitLocators(country.getCountryDe());
                country.getCountryDe().click();
                break;
            case "es":
                absoluteUrl = baseUrl + languages;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();
                //actions.moveToElement(educatedMove.getCountryList())
                //   .scrollToElement(educatedMove.getCountryEs())
                // .click(educatedMove.getCountryEs())
                // .perform();
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryEs());
                educatedMove.fluentWaitLocators(country.getCountryEs());
                country.getCountryEs().click();
                break;
            case "fr":
                absoluteUrl = baseUrl + languages;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryFr());
                educatedMove.fluentWaitLocators(country.getCountryFr());
                country.getCountryFr().click();
                break;
            case "pl":
                absoluteUrl = baseUrl + languages;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryPl());
                educatedMove.fluentWaitLocators(country.getCountryPl());
                country.getCountryPl().click();
                break;
            case "cn":
                absoluteUrl = baseUrl + languages;
                getDriver().navigate().to(absoluteUrl);
                Allure.step("Language: " + languages + " Countries: " + countries);
                actions.moveToElement(country.getHdrIcon())
                        .pause(Duration.ofSeconds(1))
                        .click(country.getDropDownCountry())
                        .pause(Duration.ofSeconds(1))
                        .perform();

                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", country.getCountryHk());
                educatedMove.fluentWaitLocators(country.getCountryHk());
                country.getCountryHk().click();
                break;
            default:
                Allure.step("Language: " + languages + " Countries: " + countries);
                throw new NoSuchElementException("No such language or country was found");
        }
    }

    @Step("Step: Accept all cookies")
    public void acceptAllCookies() throws InterruptedException {
        try {
            Thread.sleep(5000);
            educatedMove.fluentWaitLocators(educatedMove.getCookie());
            if (educatedMove.getCookie().isDisplayed()) {
                educatedMove.getCookie().click();
                System.out.println("All cookies accepted");
                Allure.step("Cookies accepted");
            }
        } catch (TimeoutException a) {
            System.out.println("All cookies have been accepted");
            Allure.step("Cookies have been accepted");
        } catch (NoSuchElementException e) {
            System.out.println("All cookies have been accepted");
            Allure.step("Cookies have been accepted");
        }
    }

    @Step("Step: Checking the pop-up window")
    public void checkWindow() {
        try {
            if (educatedMove.getCloseWindow().isDisplayed()) {
                educatedMove.getCloseWindow().click();
                System.out.println("The SignUp form is closed");
                Allure.step("The SignUp form is closed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("SignUp form is not surfaced");
            Allure.step("SignUp form is not surfaced");
        }
    }

    @Step("Step: Checking the pop-up window platform")
    public void checkButtonIconClose() {
        try {
            educatedMove.fluentWaitLocators(platformElements.getIconClose());
            if (platformElements.getIconClose().isDisplayed()) {
                platformElements.getIconClose().click();
                System.out.println("The button [iconClose] is closed");
                Allure.step("The button [iconClose] is closed");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The button [iconClose] is not surfaced");
            Allure.step("The button [iconClose] is not surfaced");
        }
    }

    @Step("Step: authorization")
    public void authorization() throws InterruptedException {
        // ElementsCheck check = new ElementsCheck(getDriver());
        Allure.parameter("Email", "aqa.tomelo.an@gmail.com");
        Allure.parameter("Password", "iT9Vgqi6d$fiZ*Z");
        Allure.step("Email: aqa.tomelo.an@gmail.com");
        Allure.step("Password: iT9Vgqi6d$fiZ*Z");

        educatedMove.fluentWaitLocators(elementsCheck.getTrade());
        elementsCheck.getTrade().click();
        Thread.sleep(1000);
        elementsCheck.getInputSignUpEmail().sendKeys("aqa.tomelo.an@gmail.com");
        Thread.sleep(1000);
        elementsCheck.getInputSignUpPassword().sendKeys("iT9Vgqi6d$fiZ*Z");
        educatedMove.fluentWaitLocators(elementsCheck.getButtonSignUpContinueIncluded());
        elementsCheck.getButtonSignUpContinueIncluded().click();
        // Thread.sleep(5000);
        checkButtonIconClose();
    }

    @Step("Step: post authorization")
    public void postAuthorization() {
        Allure.step("Go to " + absoluteUrl);
        getDriver().navigate().to(absoluteUrl);
    }

    @Step("Step: click logout")
    public void logoutClick() throws InterruptedException {
        Thread.sleep(2000);
        Allure.step("Logout");
        educatedMove.fluentWaitLocators(platformElements.getButtonLive());
        platformElements.getButtonLive().click();
        platformElements.getLogout().click();
    }

    @Step("Step: delete cookies")
    public void deleteCookies() {
        Allure.step("The cookies is deleted");
        getDriver().manage().deleteAllCookies();
    }

    //Динамически изменяет элемент
    // public SelenideElement getDynamicElement(String dynamicValue) {
    //  String dynamicLocator = String.format("#%s", dynamicValue);
    //  return $(dynamicLocator);

    // MyPage myPage = new MyPage();
    //SelenideElement element = myPage.getDynamicElement("my-dynamic-element");
    //element.click();
    //}
    @Step("Step: random selection of an element on the Widget")
    public void randomElement() {
        Random random = new Random();

        elements.add(elementsCheck.getTesla());
        elements.add(elementsCheck.getNvidia());
        elements.add(elementsCheck.getAmd());
        elements.add(elementsCheck.getAmc());
        elements.add(elementsCheck.getApple());

        int randomIndex = random.nextInt(elements.size());
        randomElement = elements.get(randomIndex);
        System.out.println(randomElement);
        Allure.step("Element: " + randomElement);

        if (randomElement == elementsCheck.getTesla()) {
            elementPlatform = platformElements.getElementPlatformTesla();
            elementPlatform2 = platformElements.getElementActiveTesla();
        } else if (randomElement == elementsCheck.getNvidia()) {
            elementPlatform = platformElements.getElementPlatformNvidia();
            elementPlatform2 = platformElements.getElementActiveNvidia();
        } else if (randomElement == elementsCheck.getAmc()) {
            elementPlatform = platformElements.getElementPlatformAmc();
            elementPlatform2 = platformElements.getElementActiveAmc();
        } else if (randomElement == elementsCheck.getAmd()) {
            elementPlatform = platformElements.getElementPlatformAmd();
            elementPlatform2 = platformElements.getElementActiveAmd();
        } else if (randomElement == elementsCheck.getApple()) {
            elementPlatform = platformElements.getElementPlatformApple();
            elementPlatform2 = platformElements.getElementActiveApple();
        }
    }

    @Step("Step: scroll and click element")
    public void scrollAndClickElement(WebElement clickElement, WebElement scrollToElement) throws InterruptedException {
        try {
            Allure.step("Scroll to: " + scrollToElement);
            Allure.step("Element click: " + clickElement);
            //((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
            Actions actions = new Actions(getDriver());
            actions.scrollToElement(scrollToElement)
                    .perform();

            Thread.sleep(1000);

            actions.moveToElement(clickElement)
                    .click(clickElement)
                    .perform();

            checkButtonIconClose();
            Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            Allure.step("Trade button is missing on the Widget");
            throw new AssertionFailedError("Trade button is missing on the Widget");
        }
    }

    public WebElement getRandomElement() {
        return randomElement;
    }

    public WebElement getElementPlatform() {
        return elementPlatform;
    }

    public WebElement getElementPlatform2() {
        return elementPlatform2;
    }
}
