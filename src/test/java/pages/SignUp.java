package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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

    private void fillInRegistrationForm() {
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

    public Profile submitFormWithValidData() {
        fillInRegistrationForm();
        submitButton.click();
        return new Profile();
    }
}
