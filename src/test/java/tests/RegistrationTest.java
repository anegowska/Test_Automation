package tests;

import configuration.TestConfig;
import org.junit.Test;
import pages.Home;

public class RegistrationTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyRegister() throws InterruptedException {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithValidData()
                .userShouldBeSuccessfullyRegisteredOrSignIn();
    }

    @Test
    public void registrationWithInvalidDataShouldFail() throws InterruptedException {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithInvalidData()
                .userShouldSeeRegistrationFormAlert();
    }
}
