package utils;

import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class ElementVisibleUtils {
    public static boolean isElementVisible(WebElement elementDisplayed) {
        boolean isDisplayed = false;
        try {
            isDisplayed = elementDisplayed.isDisplayed();
        } catch (
                NoSuchElementException e) {
        }
        return isDisplayed;
    }
}
