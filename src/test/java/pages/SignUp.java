package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import utility.Screenshot;

public class SignUp extends BasePage {

    @FindBy(id = "id_gender1")
    private WebElement maleTitleRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "id_state")
    private WebElement stateSelect;

    @FindBy(id = "postcode")
    private WebElement zipCodeInput;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumberInput;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;


    public SignUp() {
        super();
    }

    private void fillInRegistrationForm() throws InterruptedException {
        Thread.sleep(5000);
        maleTitleRadioBtn.click();
        customerFirstNameInput.sendKeys(("Abc"));
        customerLastNameInput.sendKeys("Defgh");
        passwordInput.sendKeys("pass1234");
        addressInput.sendKeys("Testaddress 123");
        cityInput.sendKeys("Testcity");
        new Select(stateSelect).selectByValue("1");
        zipCodeInput.sendKeys("65267");
        phoneNumberInput.sendKeys("654321807");
    }

    @Step
    public Profile submitFormWithValidData() throws InterruptedException {
        fillInRegistrationForm();
        Screenshot.captureScreenshot();
        submitButton.click();
        return new Profile();
    }
}
