package settings;


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.example.assert_class.AssertClass;
import org.example.manage_elements.*;
import org.example.move_page.MovePage;
import org.example.utils.FluentWait;
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


import java.net.MalformedURLException;
import java.time.Duration;

public abstract class SeleniumConfiguration {
    private static WebDriver driver;
    private final static String baseUrl = "https://capital.com/";
    private static String absoluteUrl;
    static final Dimension windowSize = new Dimension(1800, 800);
    private final FluentWait fluentWait = new FluentWait(getDriver());
    private final EducatedMainPageElements educatedMove = new EducatedMainPageElements(getDriver());
    private final PageCheckElements elementsCheck = new PageCheckElements(getDriver());
    private final PlatformTradingViewElements platformElements = new PlatformTradingViewElements(getDriver());
    private final ChoiceCountryElements country = new ChoiceCountryElements(getDriver());
    private final MovePage move = new EducatedMainPageElements(getDriver());
    private final AssertClass assertClass = new AssertClass(getDriver());
    private final SignUpFormElements signUp = new SignUpFormElements(getDriver());

    @BeforeAll
    @Epics({@Epic("US_11_Education 11-02-07_ETF_trading")})
    @Features({@Feature("Role: UnReg / TS_11.02.07 | Education > Menu Item [ETF trading]"), @Feature("Role: Auth / TS_11.02.07 | Education > Menu Item [ETF trading]"), @Feature("Role: UnAuth / TS_11.02.07 | Education > Menu Item [ETF trading]")})
    @Stories({@Story("TC_11.02.07_06 | Testing button [Create & verify your account]"), @Story("TC_11.02.07_01 | Testing button [LogIn]"), @Story("TC_11.02.07_02 | Testing button [SignUp]"), @Story("TC_11.02.07_03 | Testing button [StartTrading]"), @Story("TC_11.02.07_05 | Testing button [Trade] on Widget 'Most Traded'"), @Story("TC_11.02.07_04 | Testing button [TryDemo]"), @Story("TC_11.02.07_07 | Testing button [Create account]"), @Story("TC_11.02.07_08 | Testing button [Free demo account]"), @Story("TC_11.02.07_09 | Testing button [Free Trial]"), @Story("TC_11.02.07_10 | Testing button [Practice for free]")})
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
        if (languages.equalsIgnoreCase("en")) {
            absoluteUrl = baseUrl;
        } else {
            absoluteUrl = baseUrl + languages;
        }
        getDriver().navigate().to(absoluteUrl);
        Allure.step("Language: " + languages + " Countries: " + countries);

        actions.moveToElement(country.getHdrIcon())
                .pause(Duration.ofSeconds(1))
                .click(country.getDropDownCountry())
                .pause(Duration.ofSeconds(1))
                .perform();

        WebElement targetCountryElement = getTargetCountryElement(languages, countries);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", targetCountryElement);
        fluentWait.fluentWaitLocators(ExpectedConditions.visibilityOf(targetCountryElement));
        targetCountryElement.click();
    }

    private WebElement getTargetCountryElement(String languages, String countries) {
        switch (languages.toLowerCase()) {
            case "gb":
                return country.getCountryGb();
            case "hu":
                return country.getCountryHu();
            case "de":
                return country.getCountryDe();
            case "es":
                return country.getCountryEs();
            case "fr":
                return country.getCountryFr();
            case "pl":
                return country.getCountryPl();
            case "cn":
                return country.getCountryHk();
            case "zh":
                return country.getCountryZh();
            case "ar":
                return country.getCountryAe();
            case "it":
                if (countries.equalsIgnoreCase("gb")) {
                    return country.getCountryGb();
                } else if (countries.equalsIgnoreCase("ae")) {
                    return country.getCountryAe();
                } else if (countries.equalsIgnoreCase("de")) {
                    return country.getCountryDe();
                } else if (countries.equalsIgnoreCase("au")) {
                    return country.getCountryDe();
                }
                break;
        }
        throw new NoSuchElementException("No such country was found: " + country);
    }

    @Step("Step: Accept all cookies")
    public void acceptAllCookies() throws InterruptedException {
        try {
            //Thread.sleep(5000);
            fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(educatedMove.getCookie()));
            if (educatedMove.getCookie().isDisplayed()) {
                educatedMove.getCookie().click();
                System.out.println("All cookies accepted");
                Allure.step("Cookies accepted");
            }
        } catch (TimeoutException | NoSuchElementException e) {
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
    private void checkButtonIconClose() {
        try {
            fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(platformElements.getIconClose()));
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
        Allure.parameter("Email", "aqa.tomelo.an@gmail.com");
        Allure.parameter("Password", "iT9Vgqi6d$fiZ*Z");
        Allure.step("Email: aqa.tomelo.an@gmail.com");
        Allure.step("Password: iT9Vgqi6d$fiZ*Z");

        fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(elementsCheck.getTrade()));
        elementsCheck.getTrade().click();
        Thread.sleep(1000);
        signUp.getInputSignUpEmail().sendKeys("aqa.tomelo.an@gmail.com");
        Thread.sleep(1000);
        signUp.getInputSignUpPassword().sendKeys("iT9Vgqi6d$fiZ*Z");
        fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(signUp.getButtonSignUpContinueIncluded()));
        signUp.getButtonSignUpContinueIncluded().click();
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
        //Thread.sleep(2000);
        Allure.step("Logout");
        fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(platformElements.getButtonLive()));
        platformElements.getButtonLive().click();
        fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(platformElements.getLogout()));
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
    @Step("Step: scroll and click element")
    public void scrollAndClickElement(WebElement clickElement, WebElement scrollToElement) throws InterruptedException {
        try {
            Allure.step("Scroll to: " + scrollToElement);
            Allure.step("Element click: " + clickElement);
            //((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
            //fluentWait.fluentWaitLocators(ExpectedConditions.presenceOfElementLocated(By.xpath(scrollToElement)));
            Thread.sleep(2000);
            Actions actions = new Actions(getDriver());
            actions.scrollToElement(scrollToElement)
                    .perform();

            //Thread.sleep(1000);
            fluentWait.fluentWaitLocators(ExpectedConditions.elementToBeClickable(clickElement));
            actions.moveToElement(clickElement)
                    .click(clickElement)
                    .perform();

            checkButtonIconClose();
            //Thread.sleep(3000);
        } catch (NoSuchElementException e) {
            Allure.step("Trade button is missing on the Widget");
            throw new AssertionFailedError("Trade button is missing on the Widget");
        }
    }

    public EducatedMainPageElements getEducatedMove() {
        return educatedMove;
    }

    public PageCheckElements getElementsCheck() {
        return elementsCheck;
    }

    public MovePage getMove() {
        return move;
    }

    public AssertClass getAssertClass() {
        return assertClass;
    }
}
