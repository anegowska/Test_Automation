package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.Screenshot;

public class SignIn extends BasePage {

    @FindBy(id = "email_create")
    private WebElement emailInput;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    public SignIn() {
        super();
    }

    private void fillInCreateAccountForm() {
        emailInput.sendKeys("tester@test.com");
    }

    @Step
    public SignUp submitCreateAccountFormWithValidEmail() {
        fillInCreateAccountForm();
        Screenshot.captureScreenshot();
        createAccountButton.click();
        return new SignUp();
    }
}
