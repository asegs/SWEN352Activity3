package com.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    @Test
    public void startWebDriver(){
        System.setProperty("webdriver.chrome.driver","E:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://seleniumsimplified.com");
        Assert.assertTrue("Title should start differently",driver.getTitle().startsWith("Selenium Simplified"));
    }
}
