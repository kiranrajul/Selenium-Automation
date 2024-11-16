package com.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class LoginPage extends BasePage {
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage= By.cssSelector("#login_button_container h3");

    public void setUsername(String username) {
        try {
            set(usernameField, username);
        } catch (NoSuchElementException e) {
            System.out.println("Username field not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Error interacting with the username field: " + e.getMessage());
        }
    }
    public void setPassword(String password) {
        try {
            set(passwordField, password);
        } catch (NoSuchElementException e) {
            System.out.println("Password field not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Error interacting with the password field: " + e.getMessage());
        }
    }
    public ProductPage clickLoginButton() {
        try {
            click(loginButton);
            return new ProductPage();
        } catch (NoSuchElementException e) {
            System.out.println("Login button not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Error clicking the login button: " + e.getMessage());
        }
        return null;
    }

    public ProductPage logIntoApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
    public boolean isLoginFailed() {
        try {
            return find(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false; // No error message displayed
        }
    }
    public String getLoginErrorMessage() {
        try {
            return find(errorMessage).getText();
        } catch (Exception e) {
            return "Unknown error occurred during login.";
        }
    }
    public String getErrorMessage() {
        try {
            WebElement errorElement = find(errorMessage);
            return errorElement.getText();
        } catch (NoSuchElementException e) {
            System.out.println("Error message element not found: " + e.getMessage());
        } catch (WebDriverException e) {
            System.out.println("Error interacting with the error message element: " + e.getMessage());
        }
        return "Error message not available.";
    }

}
