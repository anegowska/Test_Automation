package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class Profile extends BasePage {

    @FindBy(css = "#center_column > h1")
    private WebElement profilePageHeader;

    public Profile() {
        super();
    }

    @Step
    public void userShouldBeSuccessfullyRegisteredOrSignIn() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "MY ACCOUNT";

        Assert.assertEquals(expectedHeaderText, profilePageHeaderText);
    }
}
