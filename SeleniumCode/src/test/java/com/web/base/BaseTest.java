package com.web.base;

import com.web.pages.BasePage;
import com.web.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    private String url= "https://www.saucedemo.com";

    @BeforeClass
    public void setUp() {
        try {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            basePage = new BasePage();
            basePage.setDriver(driver);
            loginPage = new LoginPage();
        } catch (Exception e) {
            System.err.println("Error during setup: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error during driver teardown: " + e.getMessage());
            }
        }
    }
}
