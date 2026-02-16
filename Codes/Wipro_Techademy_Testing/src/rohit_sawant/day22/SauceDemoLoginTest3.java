package rohit_sawant.day22;

// importing required selenium classes
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest3 {

    public static void main(String[] args) throws InterruptedException {

        // telling selenium where chrome driver is located
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        // launching chrome browser
        WebDriver myBrowser = new ChromeDriver();

        // opening sauce demo website
        myBrowser.get("https://www.saucedemo.com/");

        // maximizing window
        myBrowser.manage().window().maximize();

        // locating username field
        WebElement userFieldBox = myBrowser.findElement(By.id("user-name"));

        // entering correct username
        userFieldBox.sendKeys("standard_user");

        // locating password field
        WebElement passFieldBox = myBrowser.findElement(By.id("password"));

        // entering WRONG password intentionally
        passFieldBox.sendKeys("wrong_password");

        // locating login button
        WebElement loginBtn = myBrowser.findElement(By.id("login-button"));

        // clicking login button
        loginBtn.click();

        // waiting few seconds for error to appear
        Thread.sleep(2000);

        // locating error message element using its data-test attribute
        WebElement errorMessageBox = myBrowser.findElement(By.xpath("//h3[@data-test='error']"));

        // checking if error message is displayed
        if (errorMessageBox.isDisplayed()) {

            // printing pass message if error is visible
            System.out.println("Negative Login Test Passed - Error message displayed");

        } else {

            // printing fail message if error not visible
            System.out.println("Negative Login Test Failed - No error message");

        }

        // closing browser
        myBrowser.quit();
    }
}
