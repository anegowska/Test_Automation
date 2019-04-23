package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.Screenshot;

public class Cart extends BasePage{

    private static final String REMOVAL_MESSAGE = "Your shopping cart is empty.";

    @FindBy(css = "[title=\"Delete\"]")
    private WebElement removalButton;

    @FindBy(xpath = "//p[@class ='alert alert-warning']")
    private WebElement removalConfirmation;

    public Cart() {
        super();
    }

    @Step
    public Cart removeProductFromCart() {
        removalButton.click();
        Screenshot.captureScreenshot();
        return this;
    }

    @Step
    public void userShouldSeeConfirmationOfRemovalFromCart() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals(REMOVAL_MESSAGE, removalConfirmation.getText());
    }

}
