package com.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumTest {
    @Test
    public void startWebDriver() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://tigercenter.rit.edu/tigerCenterApp/api/class-search");
        Thread.sleep(1000);
        List<WebElement> allFormChildElements = driver.findElements(By.id("ng2Completer"));
        WebElement childDiv = allFormChildElements.get(0);
        List<WebElement> subChildElements = childDiv.findElements(By.xpath("*"));
        WebElement input = subChildElements.get(0);
        Actions actions = new Actions(driver);
        actions.moveToElement(input);
        actions.click();
        actions.sendKeys("SWEN-352");
        actions.build().perform();
        WebElement classSearchContainer = driver.findElement(By.id("classSearchContainer"));
        WebElement row = classSearchContainer.findElement(By.className("row"));
        List<WebElement> rowElements = row.findElements(By.xpath("*"));
        for (WebElement we:rowElements){
            System.out.println("TEST");
        }
//        actions.moveToElement(button);
//        actions.click();
//        actions.build().perform();
    }
}
