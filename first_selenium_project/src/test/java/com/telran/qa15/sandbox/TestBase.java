package com.telran.qa15.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }

    public void openWikipedia() {
        wd.get("https://www.wikipedia.org/");
    }

    public void findAndClickOnTheEnglishLink() {
        wd.findElement(By.id("js-link-box-en")).click();
    }

    public void findLoupeAndClick() {
        wd.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();
    }

    public void findSearchAndTypeRequest() {
        wd.findElement(By.id("searchInput")).sendKeys("java");
    }
}
