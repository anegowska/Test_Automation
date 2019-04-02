package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends BasePage {

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

    public SignUp submitCreateAccountFormWithValidEmail() {
        fillInCreateAccountForm("tester@test.com");
        createAccountButton.click();
        return new SignUp();
    }
}
