package com.web.tests.products;

import com.web.base.BaseTest;
import com.web.pages.ProductPage;
import static org.testng.Assert.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {
    @Test
    public void testProductHeaderIsDisplayed() {
        try {
        ProductPage productPage=loginPage.logIntoApplication("standard_user","secret_sauc");
            if (loginPage.isLoginFailed()) {
                String error = loginPage.getLoginErrorMessage();
                Assert.fail("Login failed with error: " + error);
            }
        assertTrue(productPage.isProductHeaderDisplayed(),"\n Product header is not displayed \n");

        productPage.storeFirstProductDetails();
        // Add the first product to the cart
        productPage.addFirstProductToCart();

        // Verify the product is added to the cart
        Assert.assertTrue(productPage.verifyProductInCart(), "\nProduct not found in cart\n");

        // Log out
        productPage.logOut();
        }
        catch (Exception e) {
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        }

    }
}
