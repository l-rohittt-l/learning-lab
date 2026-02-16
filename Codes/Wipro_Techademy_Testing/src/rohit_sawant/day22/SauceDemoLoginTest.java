package rohit_sawant.day22;

// importing selenium classes which we need
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoLoginTest {

    public static void main(String[] args) throws InterruptedException {

        // first telling selenium where my chrome driver is present in system
        System.setProperty("webdriver.chrome.driver",
                "C:\\Testing Drivers\\chromedriver-win64\\chromedriver.exe");

        // creating chrome browser instance so that browser will open
        WebDriver myBrowser = new ChromeDriver();

        // opening the website using link
        myBrowser.get("https://www.saucedemo.com/");

        // just maximizing so everything is clearly visible
        myBrowser.manage().window().maximize();

        // finding username textbox using id because id is unique
        WebElement userFieldBox = myBrowser.findElement(By.id("user-name"));

        // entering the username into username field
        userFieldBox.sendKeys("standard_user");

        // finding password textbox using id
        WebElement passFieldBox = myBrowser.findElement(By.id("password"));

        // entering password into password field
        passFieldBox.sendKeys("secret_sauce");

        // finding login button using id
        WebElement loginBtn = myBrowser.findElement(By.id("login-button"));

        // clicking on login button
        loginBtn.click();

        // waiting few seconds so we can see login happened
        Thread.sleep(3000);

        // closing the browser after execution
        myBrowser.quit();
    }
}
