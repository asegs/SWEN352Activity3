package com.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class SwenDeptInfo {
    Formatters formatters = new Formatters();

    public String accessSWENContact() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","E:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.rit.edu/");
        Thread.sleep(1800);
        driver.navigate().to("https://www.rit.edu/computing/contact");
        Thread.sleep(1000);
        WebElement swenDropDown = driver.findElement(By.id("card-collapse-4291"));
        WebElement cardBody = swenDropDown.findElement(By.className("card-body"));
        List<WebElement> cards = cardBody.findElements(By.className("embedded-entity"));
        ArrayList<ArrayList<String>> profInfoList = new ArrayList<ArrayList<String>>();
        for (WebElement we: cards){
            ArrayList<String> profInfo = new ArrayList<String>();
            WebElement staffInfo = we.findElement(By.tagName("article")).findElement(By.tagName("div"));
            List<WebElement> staffInfoCards = staffInfo.findElements(By.xpath("*"));
            WebElement mainText = staffInfoCards.get(1);
            WebElement contact = staffInfoCards.get(2);
            List<WebElement> mainTextDivs = mainText.findElements(By.tagName("div"));
            try{
                WebElement nameHref = mainTextDivs.get(0).findElement(By.tagName("a"));
                profInfo.add(nameHref.getAttribute("innerHTML"));
                mainTextDivs.remove(0);
            }catch (Exception e){
                profInfo.add("");
            }
            for (int i=0;i<3;i++){
                try {
                    profInfo.add(mainTextDivs.get(i).getAttribute("innerHTML"));
                }catch (IndexOutOfBoundsException iobe){
                    profInfo.add("");
                }
            }
            List<WebElement> contactTextDivs = contact.findElements(By.tagName("div"));
            try{
                WebElement emailHref = contactTextDivs.get(0).findElement(By.tagName("a"));
                profInfo.add(emailHref.getAttribute("innerHTML"));
            }catch (Exception e){
                profInfo.add("");
            }
            try{
                profInfo.add(contactTextDivs.get(1).getAttribute("innerHTML"));
                profInfoList.add(profInfo);
            }catch (Exception e){
                profInfo.add("");
            }
        }
        WebElement address = driver.findElement(By.className("mt-n4"));
        String addressText = address.getText();
        return formatters.formatSWENSite(profInfoList,addressText);
    }
}
