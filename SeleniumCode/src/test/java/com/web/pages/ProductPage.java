package com.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.lang.Throwable;
import java.io.FileWriter;
import java.io.IOException;

public class ProductPage extends BasePage{
    private By productsHeader = By.xpath("//span[text()='Products']");
    private By productNames = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By addToCartButton = By.className("btn_inventory");
    private By cartIcon = By.className("shopping_cart_link");
    private By cartProductNames = By.className("inventory_item_name");
    private By logoutButton = By.id("react-burger-menu-btn");

    public boolean isProductHeaderDisplayed() {
        return find(productsHeader).isDisplayed();
    }

    public void storeFirstProductDetails() {
        try {
            String productName = find(productNames).getText();
            String productPrice = find(productPrices).getText();

            try (FileWriter writer = new FileWriter("product_details.txt")) {
                writer.write("Product Name : " + productName + "\n");
                writer.write("Product Price : " + productPrice + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing product details to file: " + e.getMessage());
            throw new RuntimeException("Failed to store product details", e);
        } catch (Exception e) {
            System.err.println("Unexpected error while storing product details: " + e.getMessage());
            throw e;
        }
    }
    // Add the first product to the cart
    public void addFirstProductToCart() {
        WebElement addButton = find(addToCartButton);
        if (addButton.isEnabled()) {
            addButton.click();
        }
    }

    // Navigate to the cart and verify the product is in the cart
    public boolean verifyProductInCart() {
        click(cartIcon);
        WebElement cartProduct = find(cartProductNames);
        return cartProduct.getText().equals(find(productNames).getText());
    }
    public void logOut() {
        try {
            click(logoutButton); // Click the logout button in the cart page
            click(By.id("logout_sidebar_link")); // Click the actual logout link in the menu
        } catch (Exception e) {
            System.err.println("Error during logout: " + e.getMessage());
            throw e; // Re-throw to ensure logout issues are reported
        }
    }
    // Log out
}


