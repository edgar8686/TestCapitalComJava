package settings;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.opentest4j.AssertionFailedError;
import org.opentest4j.MultipleFailuresError;


import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public abstract class SeleniumConfiguration {
    private static WebDriver driver;
    static String baseUrl = "https://capital.com/";
    static String absoluteUrl;
    Set<Cookie> cookies;
    ArrayList<WebElement> elements = new ArrayList<>();
    static final Dimension windowSize = new Dimension(1800, 800);
    EducatedMove educatedMove = new EducatedMove(getDriver());
    ElementsCheck elementsCheck = new ElementsCheck(getDriver());
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
        if (languages.equalsIgnoreCase("en") && countries.equalsIgnoreCase("gb")) {
            absoluteUrl = baseUrl;
            getDriver().navigate().to(absoluteUrl);
            Allure.step("Language: " + languages + " Countries: " + countries);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(educatedMove.getHdrIcon())
                    .pause(Duration.ofSeconds(1))
                    .click(educatedMove.getDropDownCountry())
                    .pause(Duration.ofSeconds(1))
                    //.sendKeys(educatedMove.getSearchCountry(), countries)
                    .perform();
            actions.moveToElement(educatedMove.getCountryList())
                    .scrollToElement(educatedMove.getCountryGb())
                    .click(educatedMove.getCountryGb())
                    .perform();

        } else if (countries.equalsIgnoreCase("hu") && languages.equalsIgnoreCase("hu")) {
            absoluteUrl = baseUrl + languages;
            getDriver().navigate().to(absoluteUrl);
            Allure.step("Language: " + languages + " Countries: " + countries);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(educatedMove.getHdrIcon())
                    .pause(Duration.ofSeconds(1))
                    .click(educatedMove.getDropDownCountry())
                    .pause(Duration.ofSeconds(1))
                    .perform();
            actions.moveToElement(educatedMove.getCountryList())
                    .scrollToElement(educatedMove.getCountryHu())
                    .click(educatedMove.getCountryHu())
                    .perform();

        } else if (countries.equalsIgnoreCase("de") && languages.equalsIgnoreCase("de")) {
            absoluteUrl = baseUrl + languages;
            getDriver().navigate().to(absoluteUrl);
            Allure.step("Language: " + languages + " Countries: " + countries);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(educatedMove.getHdrIcon())
                    .pause(Duration.ofSeconds(1))
                    .click(educatedMove.getDropDownCountry())
                    .pause(Duration.ofSeconds(1))
                    .perform();
            actions.moveToElement(educatedMove.getCountryList())
                    .scrollToElement(educatedMove.getCountryDe())
                    .click(educatedMove.getCountryDe())
                    .perform();
        } else if (countries.equalsIgnoreCase("es") && languages.equalsIgnoreCase("es")) {
            absoluteUrl = baseUrl + languages;
            getDriver().navigate().to(absoluteUrl);
            Allure.step("Language: " + languages + " Countries: " + countries);
            Actions actions = new Actions(getDriver());
            actions.moveToElement(educatedMove.getHdrIcon())
                    .pause(Duration.ofSeconds(1))
                    .click(educatedMove.getDropDownCountry())
                    .pause(Duration.ofSeconds(1))
                    .perform();
            //actions.moveToElement(educatedMove.getCountryList())
                 //   .scrollToElement(educatedMove.getCountryEs())
                   // .click(educatedMove.getCountryEs())
                   // .perform();
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", educatedMove.getCountryEs());
            educatedMove.fluentWaitLocators(educatedMove.getCountryEs());
            educatedMove.getCountryEs().click();
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
            educatedMove.fluentWaitLocators(educatedMove.getIconClose());
            if (educatedMove.getIconClose().isDisplayed()) {
                educatedMove.getIconClose().click();
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
        // Thread.sleep(20000);
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
        educatedMove.fluentWaitLocators(educatedMove.getButtonLive());
        educatedMove.getButtonLive().click();
        educatedMove.getLogout().click();
    }

    @Step("Step: delete cookies")
    public void deleteCookies() {
        Allure.step("The cookies is deleted");
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
            elementPlatform = elementsCheck.getElementPlatformTesla();
            elementPlatform2 = elementsCheck.getElementActiveTesla();
        } else if (randomElement == elementsCheck.getNvidia()) {
            elementPlatform = elementsCheck.getElementPlatformNvidia();
            elementPlatform2 = elementsCheck.getElementActiveNvidia();
        } else if (randomElement == elementsCheck.getAmc()) {
            elementPlatform = elementsCheck.getElementPlatformAmc();
            elementPlatform2 = elementsCheck.getElementActiveAmc();
        } else if (randomElement == elementsCheck.getAmd()) {
            elementPlatform = elementsCheck.getElementPlatformAmd();
            elementPlatform2 = elementsCheck.getElementActiveAmd();
        } else if (randomElement == elementsCheck.getApple()) {
            elementPlatform = elementsCheck.getElementPlatformApple();
            elementPlatform2 = elementsCheck.getElementActiveApple();
        }
    }

    @Step("Step: scroll and click element")
    public void scrollAndClickElement(WebElement clickElement, WebElement scrollToElement) {
        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        try {
            Allure.step("Scroll to: " + scrollToElement);
            Allure.step("Element click: " + clickElement);
            new Actions(getDriver())
                    .scrollToElement(scrollToElement)
                    .pause(Duration.ofSeconds(1))
                    .moveToElement(clickElement)
                    .pause(Duration.ofSeconds(1))
                    .click(clickElement)
                    .perform();
        } catch (NoSuchElementException e) {
            Allure.step("Trade button is missing");
            throw new AssertionFailedError("Trade button is missing");
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
