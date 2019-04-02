package pages;

import configuration.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Actions;

public class BasePage {

    @FindBy(id ="columns")
    private WebElement pageContent;

    public BasePage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
        Actions.waitForElementVisibility(pageContent);
    }
}
