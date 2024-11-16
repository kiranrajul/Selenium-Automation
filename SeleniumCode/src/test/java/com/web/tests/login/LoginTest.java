package com.web.tests.login;

import com.sun.source.tree.AssertTree;
import com.web.base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void testLoginErrorMessage() {
        try {
            // Set username and password
            loginPage.setUsername("standard_user");
            loginPage.setPassword("secret_sauce");
            // Attempt to click the login button
            loginPage.clickLoginButton();

            // Get the error message after the login attempt
            String actualMessage = loginPage.getErrorMessage();

            // Assert that the error message contains the expected text
            Assert.assertFalse(actualMessage.contains("Epic sadface"), "Invalid User name or password");

        } catch (NoSuchElementException e) {
            // This exception occurs when the element is not found on the page
            System.out.println("Error: Element not found during login test - " + e.getMessage());
            Assert.fail("Element not found during the login process: " + e.getMessage());
        } catch (TimeoutException e) {
            // This exception occurs when an element does not appear within the timeout period
            System.err.println("Error: Timeout occurred while waiting for elements during login test - " + e.getMessage());
            Assert.fail("Timeout while waiting for elements: " + e.getMessage());
        } catch (WebDriverException e) {
            // This is a generic WebDriver exception for other issues like browser failures
            System.err.println("WebDriver error during login test - " + e.getMessage());
            Assert.fail("WebDriver encountered an error: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("Unexpected error during login test - " + e.getMessage());
            Assert.fail("Unexpected error: " + e.getMessage());
        }
    }
}
