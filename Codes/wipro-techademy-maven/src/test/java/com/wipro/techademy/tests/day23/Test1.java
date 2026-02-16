package com.wipro.techademy.tests.day23;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

    @Test
    public void openGoogle() {
        
        // Setup driver automatically
        WebDriverManager.chromedriver().setup();
        
        // Launch browser
        WebDriver driver = new ChromeDriver();
        
        // Open website
        driver.get("https://www.google.com");
        
        // Maximize window
        driver.manage().window().maximize();
        
        // Close browser
        driver.quit();
    }
}
