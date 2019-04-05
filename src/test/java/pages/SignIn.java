package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.DataFaker;
import utility.Screenshot;

public class SignIn extends BasePage {

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

    public SignIn() {
        super();
    }

    private void fillInCreateAccountForm(String email) {
        emailInput.sendKeys(email);
    }

    private void fillInSignInFormWithEmail() {
        registeredEmail.sendKeys("admin@admin.com");
    }

    private void fillInSignInFormWithPassword() {
        password.sendKeys("admin1234");
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
        fillInSignInFormWithEmail();
        fillInSignInFormWithPassword();
        Screenshot.captureScreenshot();
        signInButton.click();
        return new Profile();
    }
}
