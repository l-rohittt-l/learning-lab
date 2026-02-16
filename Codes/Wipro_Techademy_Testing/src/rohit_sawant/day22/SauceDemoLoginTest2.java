package rohit_sawant.day22;

// importing required selenium classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest2 {

    public static void main(String[] args) throws InterruptedException {

        // telling selenium where my chrome driver is located
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        // launching chrome browser
        WebDriver myBrowser = new ChromeDriver();

        // opening sauce demo website
        myBrowser.get("https://www.saucedemo.com/");

        // maximizing window for better visibility
        myBrowser.manage().window().maximize();

        // locating username field using id
        WebElement userFieldBox = myBrowser.findElement(By.id("user-name"));

        // entering username
        userFieldBox.sendKeys("standard_user");

        // locating password field using id
        WebElement passFieldBox = myBrowser.findElement(By.id("password"));

        // entering password
        passFieldBox.sendKeys("secret_sauce");

        // locating login button
        WebElement loginBtn = myBrowser.findElement(By.id("login-button"));

        // clicking login button
        loginBtn.click();

        // waiting few seconds so page can load
        Thread.sleep(3000);

        // getting the current url after login
        String actualUrlAfterLogin = myBrowser.getCurrentUrl();

        // storing expected url which should appear after successful login
        String expectedUrlAfterLogin = "https://www.saucedemo.com/inventory.html";

        // comparing actual and expected url
        if (actualUrlAfterLogin.equals(expectedUrlAfterLogin)) {

            // printing success message if login worked
            System.out.println("Login Test Passed");

        } else {

            // printing failure message if login did not work
            System.out.println("Login Test Failed");

        }

        // closing the browser
        myBrowser.quit();
    }
}
