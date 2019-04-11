package tests;

import configuration.TestConfig;
import org.junit.Test;
import pages.Home;

public class LoginTest extends TestConfig {

    @Test
    public void userShouldSuccessfullySignIn() {
        new Home()
                .openSignInPage()
                .submitSignInFormWithValidEmailAndPasswd()
                .userShouldBeSuccessfullyRegisteredOrSignIn();
    }

    @Test
    public void loginWithInvalidDataShouldFail() {
        new Home()
                .openSignInPage()
                .submitSignInFormWithInvalidEmailAndPasswd()
                .userShouldSeeSignInFormAlert();
    }
}
