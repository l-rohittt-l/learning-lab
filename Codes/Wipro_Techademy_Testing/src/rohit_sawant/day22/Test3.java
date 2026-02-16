package rohit_sawant.day22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

/*
Test3:
This test opens the Selenium official website in Chrome and performs scrolling.
It uses the Actions class to simulate PAGE_DOWN and PAGE_UP key presses
to scroll down and then back up like a real user.
Purpose: To practice keyboard-based scrolling without using JavaScript.
*/

public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        // This tells Selenium where my ChromeDriver.exe is located in my system
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        // This line actually launches a new Chrome browser window
        WebDriver pageController = new ChromeDriver();

        try {

            // This will open the selenium official website
            pageController.get("https://www.selenium.dev/");

            // This makes the browser window expand to maximum size
            pageController.manage().window().maximize();

            // Actions class helps me simulate real keyboard and mouse actions
            Actions keyboardController = new Actions(pageController);

            System.out.println("Now I am scrolling down using PAGE_DOWN key");

            // This loop will press PAGE_DOWN key 5 times
            // Each time it scrolls a little bit downward like a real user
            for (int scrollCounter = 0; scrollCounter < 5; scrollCounter++) {

                // This line performs the PAGE_DOWN key action
                keyboardController.sendKeys(Keys.PAGE_DOWN).perform();

                // Small pause so that I can clearly see the scrolling happening
                Thread.sleep(1000);
            }

            System.out.println("Now I am scrolling up using PAGE_UP key");

            // This loop presses PAGE_UP key 5 times
            // It scrolls upward step by step
            for (int reverseScroll = 0; reverseScroll < 5; reverseScroll++) {

                // This performs PAGE_UP action
                keyboardController.sendKeys(Keys.PAGE_UP).perform();

                // Pause again to visually observe the scroll
                Thread.sleep(1000);
            }

            System.out.println("Scrolling completed successfully");

        } catch (Exception e) {

            // If any error happens while running, this will print the error message
            System.out.println("Exception occurred: " + e.getMessage());

        } finally {

            // This will close the browser no matter what happens above
            pageController.quit();

            System.out.println("Browser closed");
        }
    }
}
