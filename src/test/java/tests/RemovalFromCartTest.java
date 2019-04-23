package tests;

import configuration.TestConfig;
import org.junit.Test;
import pages.Home;

public class RemovalFromCartTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyRemoveProductFromCart() throws InterruptedException {
        new Home()
                .goToDressesPage()
                .addProductToCart()
                .closeConfirmationWindow()
                .goToCart()
                .removeProductFromCart()
                .userShouldSeeConfirmationOfRemovalFromCart();
    }
}
