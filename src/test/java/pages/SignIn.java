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

    public SignIn() {
        super();
    }

    private void fillInCreateAccountForm(String email) {
        emailInput.sendKeys(email);
    }

    @Step
    public SignUp submitCreateAccountFormWithValidEmail() {
        fillInCreateAccountForm(faker.getFakeEmail());
        Screenshot.captureScreenshot();
        createAccountButton.click();
        return new SignUp();
    }
}
