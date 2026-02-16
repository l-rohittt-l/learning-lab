package rohit_sawant.day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Test1:
This test verifies Selenium setup for multiple browsers (Chrome, Edge, Firefox).
It opens Google in each browser, prints the page title, and closes the browser.
Purpose: To confirm that all browser drivers are correctly configured and working.
*/

public class Test1 {
    public static void main(String[] args) {

        // ---------- CHROME ----------
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Chrome opened successfully!");
        System.out.println("Chrome Title: " + driver.getTitle());
        driver.quit();   // <-- IMPORTANT

        // ---------- EDGE ----------
        System.setProperty("webdriver.edge.driver",
                "C:\\Testing Drivers\\msedgedriver-win64\\msedgedriver.exe");

        WebDriver driver2 = new EdgeDriver();
        driver2.get("https://www.google.com");
        System.out.println("Edge opened successfully!");
        System.out.println("Edge Title: " + driver2.getTitle());
        driver2.quit();  // <-- IMPORTANT

        // ---------- FIREFOX ----------
        System.setProperty("webdriver.gecko.driver",
        		"C:\\Testing Drivers\\geckodriver-win32\\geckodriver.exe");

        		FirefoxOptions options = new FirefoxOptions();
        		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        		WebDriver driver3 = new FirefoxDriver(options);
        		driver3.get("https://www.google.com");
        		System.out.println("Firefox opened successfully!");
        		System.out.println("Firefox Title: " + driver3.getTitle());
        		driver3.quit();
    }
}