package com.web.pages;

import org.openqa.selenium.*;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    protected WebElement find(By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            System.err.println("Element not found: " + locator);
            throw e; // Re-throw to prevent further steps from executing on a null element
        }
    }

    protected void set(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait for 10 seconds
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (TimeoutException e) {
            System.err.println("Timeout waiting for element to be clickable: " + locator);
            throw e;
        }
    }
}
