package rohit_sawant.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

/*
Test4:
This test simulates a real user flow. It opens Google, searches for
"selenium official website", clicks the first search result,
then scrolls down and up using keyboard actions.
Purpose: To practice element locating (By.name, By.xpath),
user interaction (sendKeys, click), and page scrolling using Actions.
*/

public class Test4 {

    public static void main(String[] args) throws InterruptedException {

        // Telling Selenium where my ChromeDriver is located
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        // Launching Chrome browser
        WebDriver browser = new ChromeDriver();

        try {

            System.out.println("Opening Google homepage");
            browser.get("https://www.google.com");

            browser.manage().window().maximize();

            // Finding Google search box using name attribute
            WebElement searchBox = browser.findElement(By.name("q"));

            System.out.println("Typing search text: selenium official website");

            // Typing search query
            searchBox.sendKeys("selenium official website");

            // Pressing ENTER key to search
            searchBox.sendKeys(Keys.ENTER);

            Thread.sleep(3000);  // Wait for search results to load

            System.out.println("Clicking first search result");

            // Clicking first result link
            WebElement firstResult = browser.findElement(By.xpath("(//h3)[1]"));
            firstResult.click();

            Thread.sleep(3000);  // Wait for Selenium site to open

            System.out.println("Scrolling down page");

            Actions actionController = new Actions(browser);

            // Scroll down multiple times
            for (int down = 0; down < 5; down++) {
                actionController.sendKeys(Keys.PAGE_DOWN).perform();
                Thread.sleep(1000);
            }

            System.out.println("Scrolling up page");

            // Scroll up multiple times
            for (int up = 0; up < 5; up++) {
                actionController.sendKeys(Keys.PAGE_UP).perform();
                Thread.sleep(1000);
            }

            System.out.println("Use case completed successfully");

        } catch (Exception e) {

            System.out.println("Exception occurred: " + e.getMessage());

        } finally {

            browser.quit();
            System.out.println("Browser closed");
        }
    }
}
