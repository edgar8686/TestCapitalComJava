package settings;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Optional;

public class TestListener implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment("screenshot", "image/png", "png", ((TakesScreenshot) AbstractTest.getDriver()).getScreenshotAs(OutputType.BYTES));
        System.out.println("Test failed");
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test disabled");

    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test successful");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("test Aborted");
    }
}
