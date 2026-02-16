package rohit_sawant.day22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/*
Test2:
This test launches Chrome, Edge, and Firefox one by one, maximizes the window,
opens Google, retrieves the page title, and validates whether the title contains "Google".
It also uses try-catch-finally for basic exception handling and proper browser cleanup.
Purpose: To practice browser validation logic and structured test flow handling.
*/

public class Test2 {
    public static void main(String[] args) {

        WebDriver driver = null;

        try {

            System.out.println("========== TEST STARTED ==========");

            // ----------- CHROME -----------
            System.out.println("Opening Chrome Browser");

            System.setProperty("webdriver.chrome.driver",
                    "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");

            String chromeTitle = driver.getTitle();
            System.out.println("Chrome Page Title: " + chromeTitle);

            if (chromeTitle.contains("Google")) {
                System.out.println("Chrome Test Pass");
            } else {
                System.out.println("Chrome Test Fail");
            }

            driver.quit();

            // ----------- EDGE -----------
            System.out.println("Opening Edge Browser");

            System.setProperty("webdriver.edge.driver",
                    "C:\\Testing Drivers\\msedgedriver-win64\\msedgedriver.exe");

            driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com");

            String edgeTitle = driver.getTitle();
            System.out.println("Edge Page Title: " + edgeTitle);

            if (edgeTitle.contains("Google")) {
                System.out.println("Edge Test Pass");
            } else {
                System.out.println("Edge Test Fail");
            }

            driver.quit();

            // ----------- FIREFOX -----------
            System.out.println("Opening Firefox Browser");

            System.setProperty("webdriver.gecko.driver",
                    "C:\\Testing Drivers\\geckodriver-win32\\geckodriver.exe");

            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.google.com");

            String firefoxTitle = driver.getTitle();
            System.out.println("Firefox Page Title: " + firefoxTitle);

            if (firefoxTitle.contains("Google")) {
                System.out.println("Firefox Test Pass");
            } else {
                System.out.println("Firefox Test Fail");
            }

        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("Closing browser if still open");
            if (driver != null) {
                driver.quit();
            }
            System.out.println("========== TEST COMPLETED ==========");
        }
    }
}
