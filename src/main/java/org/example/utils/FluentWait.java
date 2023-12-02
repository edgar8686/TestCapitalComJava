package org.example.utils;

import org.example.abstractClass.AbstractPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWait extends AbstractPage {
    public FluentWait(WebDriver driver) {
        super(driver);
    }
    public void fluentWaitLocators(ExpectedCondition<WebElement> conditions) {
        Wait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(20))
                .ignoring(NoSuchElementException.class);
        wait.until(conditions);
    }
}
