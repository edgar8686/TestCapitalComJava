package org.example.utils;


import java.util.stream.Stream;

public class CrossBrowserTest {
    /*  // Массив с поддерживаемыми браузерами
    private static final String[] browsers = {"chrome", "firefox", "edge"};

    // Метод для предоставления параметров с браузерами
    private static Stream<String> browserProvider() {
        return Stream.of(browsers);
    }

    // Резолвер для передачи параметров тестовому методу
    public static class BrowserParameterResolver implements ParameterResolver {
        @Override
        public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
            return parameterContext.getParameter().getType().equals(String.class);
        }

        @Override
        public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) {
            return parameterContext.getParameter().getName();
        }
    }

  /*  WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");
    // Ваш код для ввода логина и пароля и нажатия на кнопку входа

    // Шаг 2: Получение куков после авторизации
    Set<Cookie> cookies = driver.manage().getCookies();

    // Шаг 3: Выход из аккаунта - удаление куков
        driver.manage().

    deleteAllCookies();

    // Шаг 4: Проверка неавторизованного состояния
    // Ваши проверки на отсутствие доступа к определенным элементам или наличие элементов входа.

    // Шаг 5: Восстановление сессии, если это необходимо
    // Если вы хотите восстановить сессию после выхода пользователя, можете добавить куки обратно:
        for(Cookie cookie :cookies) {
        driver.manage().addCookie(cookie);
    }
   */
     /* @ParameterizedTest(name = "Test in browser: {0}")
        @MethodSource("browserProvider")
        public void crossBrowserTest(String browser) throws MalformedURLException {
            // Настройки для WebDriver
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);

            // URL Selenoid сервера
            URL selenoidUrl = new URL("http://localhost:4444/wd/hub");

            // Инициализация WebDriver
            WebDriver driver = new RemoteWebDriver(selenoidUrl, capabilities);
        }
    }

      */
}