package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import utility.Screenshot;

public class Home extends BasePage{

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement signInButton;

    public Home() {
        super();
    }

    @Step
    public SignIn openSignInPage() {
        signInButton.click();
        Screenshot.captureScreenshot();
        return new SignIn();
    }


}
