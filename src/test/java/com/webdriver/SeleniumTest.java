package com.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.security.Key;
import java.util.List;
public class SeleniumTest {
    TigerCenterSearch tigerCenterSearch = new TigerCenterSearch();
    SwenDeptInfo swenDeptInfo = new SwenDeptInfo();
    //Get all SWEN-352 classes
    @Test
    public void TestSWEN352() throws InterruptedException {
        tigerCenterSearch.accessTigerCenter("SWEN-352");
    }
    //Get all SWEN-262 classes
    @Test
    public void TestSWEN262() throws InterruptedException{
        tigerCenterSearch.accessTigerCenter("SWEN-262");
    }
    //Get all SWEN-250 classes
    @Test
    public void TestSWEN250() throws InterruptedException{
        tigerCenterSearch.accessTigerCenter("SWEN-250");
    }
    //Get the chair of the software engineering department
    @Test
    public void TestScrapeSWENDept() throws InterruptedException{
        swenDeptInfo.accessSWENContact();
    }

}
