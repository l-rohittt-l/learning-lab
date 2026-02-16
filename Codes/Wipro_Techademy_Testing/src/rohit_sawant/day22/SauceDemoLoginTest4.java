package rohit_sawant.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class SauceDemoLoginTest4 {


    public static void main(String[] args) {

        // setting driver path
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        // launching browser
        WebDriver myBrowser = new ChromeDriver();

        myBrowser.manage().window().maximize();

        // opening sauce demo website
        myBrowser.get("https://www.saucedemo.com/");

        // entering correct username
        myBrowser.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        // entering wrong password
        myBrowser.findElement(By.id("password"))
                .sendKeys("wrong_password");

        // clicking login button
        myBrowser.findElement(By.id("login-button"))
                .click();

        // creating explicit wait object with maximum timeout of 5 seconds
        WebDriverWait smartWait = new WebDriverWait(myBrowser, Duration.ofSeconds(5));

        try {

            // waiting until error message becomes visible
            WebElement errorBox = smartWait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//h3[@data-test='error']")
                    )
            );

            // if wait succeeds, error is visible
            if (errorBox.isDisplayed()) {
                System.out.println("Negative Login Test Passed - Error message displayed");
            }

        } catch (Exception e) {

            // this block runs if error message did not appear within 5 seconds
            System.out.println("Negative Login Test Failed - Error message did not appear in time");

        }

        // closing browser
        myBrowser.quit();
    }
}
