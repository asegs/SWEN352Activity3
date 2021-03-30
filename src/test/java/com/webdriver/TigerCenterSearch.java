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
        //Initialize a new chrome webdriver from an .exe location
        System.setProperty("webdriver.chrome.driver","E:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Go to Tiger Center class search
        driver.navigate().to("https://tigercenter.rit.edu/tigerCenterApp/api/class-search");
        //Wait 1 second to load page
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        //Select selector and arrow down to spring term and select it
        WebElement select = driver.findElement(By.tagName("select"));
        actions.moveToElement(select);
        actions.click();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();
        //Select and enter classname in search bar
        List<WebElement> allFormChildElements = driver.findElements(By.id("ng2Completer"));
        WebElement childDiv = allFormChildElements.get(0);
        List<WebElement> subChildElements = childDiv.findElements(By.xpath("*"));
        WebElement input = subChildElements.get(0);
        actions.moveToElement(input);
        actions.click();
        actions.sendKeys(classname);
        actions.build().perform();
        //Select and click search button
        WebElement buttonSpan = driver.findElement(By.className("classSearchSearchButtonText"));
        actions.moveToElement(buttonSpan);
        actions.click();
        actions.build().perform();
        //Scrape all classes, wait 1.7 seconds to load results
        Thread.sleep(1700);
        WebElement parent = driver.findElement(By.className("classSearchBasicResultsMargin"));
        List<WebElement> classes = parent.findElements(By.xpath("*"));
        List<WebElement> classesApp = driver.findElements(By.tagName("app-class-search-row"));
        StringBuilder sb = new StringBuilder();
        //For classes in search results, format results and save to string
        for (WebElement we:classesApp){
            sb.append(formatters.formatTigerCenter(we.getText())).append("\n\n");
        }
        //Display and return results
        System.out.println(sb.toString());
        return sb.toString();
    }
}
