package com.telran.qa15.lesson1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Ebay {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void openTest() throws InterruptedException {
        webDriver.navigate().to("http://www.ebay.com");
        webDriver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() {
//        webDriver.quit();
    }

}
