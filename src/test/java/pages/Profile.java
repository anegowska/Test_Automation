package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends BasePage {

    @FindBy(css = "center_column > h1")
    private WebElement profilePageHeader;

    public Profile() {
        super();
    }

    public void userShouldBeSuccessfullyRegistered() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "MY ACCOUNT";

        Assert.assertEquals(expectedHeaderText, profilePageHeaderText);
    }
}
