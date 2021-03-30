package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TigerCenterSearch {
    Formatters formatters = new Formatters();
    public String accessTigerCenter(String classname) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://tigercenter.rit.edu/tigerCenterApp/api/class-search");
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        //Select selector and choose term
        WebElement select = driver.findElement(By.tagName("select"));
        actions.moveToElement(select);
        actions.click();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        //Select and enter SWEN-352
        List<WebElement> allFormChildElements = driver.findElements(By.id("ng2Completer"));
        WebElement childDiv = allFormChildElements.get(0);
        List<WebElement> subChildElements = childDiv.findElements(By.xpath("*"));
        WebElement input = subChildElements.get(0);
        actions.moveToElement(input);
        actions.click();
        actions.sendKeys(classname);
        actions.build().perform();
        //Select and click button
        WebElement buttonSpan = driver.findElement(By.className("classSearchSearchButtonText"));
        actions.moveToElement(buttonSpan);
        actions.click();
        actions.build().perform();
        //Scrape all classes
        Thread.sleep(1700);
        WebElement parent = driver.findElement(By.className("classSearchBasicResultsMargin"));
        List<WebElement> classes = parent.findElements(By.xpath("*"));
        List<WebElement> classesApp = driver.findElements(By.tagName("app-class-search-row"));
        StringBuilder sb = new StringBuilder();
        for (WebElement we:classesApp){
            sb.append(formatters.formatTigerCenter(we.getText())).append("\n\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
