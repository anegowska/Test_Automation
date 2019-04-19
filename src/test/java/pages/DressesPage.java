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


    public DressesPage() {
        super();
    }

    @Step
    public DressesPage addProductToBasket() {
        listOfProducts.click();
        addToCartButton.click();
        Screenshot.captureScreenshot();
        return this;
    }

    @Step
    public void userShouldSeeAdditionConfirmationToCart() {
        Actions.waitForElementVisibility(confirmationIcon);
    }
}
