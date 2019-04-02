package utility;

import configuration.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

    static final int WAIT_TIMEOUT = 10;
    private static WebDriverWait wait = new WebDriverWait(WebDriverSingleton.getInstance(), WAIT_TIMEOUT);

    public static void waitForElementVisibility (WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
