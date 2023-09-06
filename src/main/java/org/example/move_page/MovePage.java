package org.example.move_page;

import org.openqa.selenium.WebElement;

public interface MovePage<T> {
    T clickPage(WebElement main, WebElement page);

}
