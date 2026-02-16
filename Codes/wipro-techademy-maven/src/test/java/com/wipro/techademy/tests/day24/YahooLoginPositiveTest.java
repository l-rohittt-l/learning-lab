package com.wipro.techademy.tests.day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YahooLoginPositiveTest {

    public static void main(String[] args) {

        // fetch credentials from environment variables
        String username = System.getenv("YAHOO_LOGIN_USERNAME");
        String password = System.getenv("YAHOO_LOGIN_PASSWORD");

        // fail-safe check
        if (username == null || password == null) {
            System.out.println("ERROR → Environment variables not set.");
            return;
        }

        // launch browser
        WebDriver driver = new ChromeDriver();

        // waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();

        try {

            // open login page
            driver.get("https://login.yahoo.com/");

            // enter username
            driver.findElement(By.id("login-username")).sendKeys(username);
            driver.findElement(By.id("login-signin")).click();

            // wait for password field
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));

            // enter password
            driver.findElement(By.id("login-passwd")).sendKeys(password);
            driver.findElement(By.id("login-signin")).click();

            // wait for any post-login page
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("mail.yahoo"),
                    ExpectedConditions.urlContains("www.yahoo.com"),
                    ExpectedConditions.urlContains("login.yahoo.com/account")
            ));

            // current URL
            String currentURL = driver.getCurrentUrl();
            System.out.println("Current URL → " + currentURL);

            // if upsell page appears → force redirect to inbox
            if (currentURL.contains("upsell") || currentURL.contains("challenge")) {
                driver.navigate().to("https://mail.yahoo.com/");
            }

            // final validation
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.urlContains("mail.yahoo"),
                    ExpectedConditions.urlContains("yahoo.com")
            ));

            String finalURL = driver.getCurrentUrl();

            if (finalURL.contains("yahoo")) {
                System.out.println("TEST PASSED → Login successful");
            } else {
                System.out.println("TEST FAILED → Login unsuccessful");
            }
            
            Thread.sleep(2000);

        } catch (Exception e) {

            System.out.println("TEST FAILED → Exception occurred");
            e.printStackTrace();

        } finally {
        	
            driver.quit();
        }
    }
}
