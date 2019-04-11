package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;
import utility.Screenshot;

public class SignIn extends BasePage {

    private static final String ADMIN_EMAIL = "admin@admin.com";
    private static final String ADMIN_PASSWORD = "admin1234";
    public static final String AUTHENTICATION_FAILED = "Authentication failed.";
    private DataFaker faker = new DataFaker();

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "email")
    private WebElement registeredEmail;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(css = "#center_column > .alert li")
    private WebElement alertMessage;

    public SignIn() {
        super();
    }

    private void fillInCreateAccountForm(String email) {
        emailInput.sendKeys(email);
    }

    private void fillInSignInFormWithEmail(boolean isCorrectEmail) {
        if (isCorrectEmail) {
            registeredEmail.sendKeys(ADMIN_EMAIL);
        }
        registeredEmail.sendKeys(faker.getFakeEmail());

    }

    private void fillInSignInFormWithPassword(boolean isCorrectPasswd) {
        if (isCorrectPasswd) {
            password.sendKeys(ADMIN_PASSWORD);
        }
        password.sendKeys(faker.getFakePassword());
    }

    @Step
    public SignUp submitCreateAccountFormWithValidEmail() {
        fillInCreateAccountForm(faker.getFakeEmail());
        Screenshot.captureScreenshot();
        createAccountButton.click();
        return new SignUp();
    }

    @Step
    public Profile submitSignInFormWithValidEmailAndPasswd() {
        fillInSignInFormWithEmail(true);
        fillInSignInFormWithPassword(true);
        Screenshot.captureScreenshot();
        signInButton.click();
        return new Profile();
    }

    @Step
    public SignIn submitSignInFormWithInvalidEmailAndPasswd() {
        fillInSignInFormWithEmail(false);
        fillInSignInFormWithPassword(false);
        Screenshot.captureScreenshot();
        signInButton.click();
        return this;
    }

    @Step
    public void userShouldSeeSignInFormAlert() {
        Assert.assertEquals(AUTHENTICATION_FAILED, alertMessage.getText());
    }
}
