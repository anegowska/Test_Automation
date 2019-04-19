package tests;

import configuration.TestConfig;
import org.junit.Test;
import pages.Home;

public class AddToBasketTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyAddProductToCart() throws InterruptedException {
        new Home()
                .goToDressesPage()
                .addProductToCart()
                .userShouldSeeAdditionConfirmationToCart();
    }

}
