package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class ElementVisibleUtils {
    public static boolean isElementVisible(WebElement elementDisplayed, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(elementDisplayed));
        boolean isDisplayed = false;
        try {
            isDisplayed = elementDisplayed.isDisplayed();
        } catch (
                NoSuchElementException e) {
        }
        return isDisplayed;
    }
}
