package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.Actions;
import utility.Screenshot;

public class DressesPage extends BasePage {

    @FindBy(className = "icon-th-list")
    private WebElement listOfProducts;

    @FindBy(xpath = "//a[@data-id-product='3']/span[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//i[@class='icon-ok']")
    private WebElement confirmationIcon;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeIcon;

    @FindBy(css = "[title=\"View my shopping cart\"]")
    private WebElement cartButton;


    public DressesPage() {
        super();
    }

    @Step
    public DressesPage addProductToCart() {
        listOfProducts.click();
        addToCartButton.click();
        Screenshot.captureScreenshot();
        return this;
    }

    @Step
    public void userShouldSeeConfirmationOfAddingToCart() {
        Actions.waitForElementVisibility(confirmationIcon);
    }

    @Step
    public DressesPage closeConfirmationWindow() throws InterruptedException {
        Thread.sleep(5000);
        closeIcon.click();
        Screenshot.captureScreenshot();
        return this;
    }

    @Step
    public Cart goToCart() {
        cartButton.click();
        Screenshot.captureScreenshot();
        return new Cart();
    }
}
