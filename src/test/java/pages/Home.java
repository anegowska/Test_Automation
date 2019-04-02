package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage{

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement signInButton;

    public Home() {
        super();
    }

    public SignIn openSignInPage() {
        signInButton.click();

        return new SignIn();
    }


}
