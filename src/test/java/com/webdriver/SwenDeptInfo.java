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
        //Initialize new chrome webdriver
        System.setProperty("webdriver.chrome.driver","E:\\Java\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Go to RIT home page
        driver.navigate().to("https://www.rit.edu/");
        //Wait 1.8 seconds to laod
        Thread.sleep(1800);
        //From RIT homepage, go to computing contact page
        driver.navigate().to("https://www.rit.edu/computing/contact");
        //Wait for 1 second
        Thread.sleep(1000);
        //Select the Software Engineering department dropdown
        WebElement swenDropDown = driver.findElement(By.id("card-collapse-4291"));
        WebElement cardBody = swenDropDown.findElement(By.className("card-body"));
        //Get the list of all divs in the SWEN dropdown
        List<WebElement> cards = cardBody.findElements(By.className("embedded-entity"));
        ArrayList<ArrayList<String>> profInfoList = new ArrayList<ArrayList<String>>();
        for (WebElement we: cards){
            //Create an arraylist to hold staff information
            ArrayList<String> profInfo = new ArrayList<String>();
            //Grab the information div from the parent div of that staff member
            WebElement staffInfo = we.findElement(By.tagName("article")).findElement(By.tagName("div"));
            //Get a list of all divs in that staff div
            List<WebElement> staffInfoCards = staffInfo.findElements(By.xpath("*"));
            //Get the information divs from that staff div
            WebElement mainText = staffInfoCards.get(1);
            WebElement contact = staffInfoCards.get(2);
            //Add information to that staff member's arraylist, if element not found add empty string to replace with "No contact info"
            //Adding name and position type info
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
            //Adding contact info
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
        //Get address of Golisano Hall
        WebElement address = driver.findElement(By.className("mt-n4"));
        String addressText = address.getText();
        return formatters.formatSWENSite(profInfoList,addressText);
    }
}
