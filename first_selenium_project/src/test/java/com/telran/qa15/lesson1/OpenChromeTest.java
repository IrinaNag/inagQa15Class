package com.telran.qa15.lesson1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenChromeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testOpenBrowser() throws InterruptedException {
        driver.navigate().to("https://ru.wikibooks.org/wiki/Java");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
