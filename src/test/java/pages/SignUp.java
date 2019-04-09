package pages;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;
import utility.Screenshot;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends BasePage {

    private DataFaker faker = new DataFaker();
    public static final String EXPECTED_MESSAGE = "firstname is required";

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

    @FindBy(css = ".alert alert-danger li")
    private List<WebElement> alertMessages;


    public SignUp() {
        super();
    }

    private void fillInRegistrationForm(boolean isCorrect) throws InterruptedException {
        Thread.sleep(5000);
        maleTitleRadioBtn.click();
        if (isCorrect) {
            customerFirstNameInput.sendKeys(faker.getFakeFirstName());
        }
        customerLastNameInput.sendKeys(faker.getFakeLastName());
        passwordInput.sendKeys(faker.getFakePassword());
        addressInput.sendKeys(faker.getFakeAddress());
        cityInput.sendKeys(faker.getFakeCity());
        new Select(stateSelect).selectByValue("1");
        zipCodeInput.sendKeys(faker.getFakeZipCode());
        phoneNumberInput.sendKeys(faker.getFakePhoneNumber());
    }

    @Step
    public Profile submitFormWithValidData() throws InterruptedException {
        fillInRegistrationForm(true);
        Screenshot.captureScreenshot();
        submitButton.click();
        return new Profile();
    }

    @Step
    public SignUp submitFormWithInvalidData() throws InterruptedException {
        fillInRegistrationForm(false);
        Screenshot.captureScreenshot();
        submitButton.click();
        return this;
    }

    @Step
    public void userShouldSeeRegistrationFormAlert() {
        Assert.assertThat(getAlertMessageContent(), IsCollectionContaining.hasItem(EXPECTED_MESSAGE));
    }

    private List<String> getAlertMessageContent() {
        List<String> alertMessagesList = new ArrayList<String>();

        for (WebElement message : alertMessages) {
            alertMessagesList.add(message.getText());
        }
        return alertMessagesList;
    }
}
