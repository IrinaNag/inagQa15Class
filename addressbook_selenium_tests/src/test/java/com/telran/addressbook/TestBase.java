package com.telran.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    @AfterClass
    public void yearDown() {
        wd.quit();
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        wd.findElement(By.cssSelector("[type='submit']")).click();
    }

    public void type(By locator, String str) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(str);
    }

    public void returnToGroupsPage() {
        wd.findElement(By.cssSelector("i")).click();
    }

    public void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void fillGroupForm(String groupName, String groupHeader, String groupFooter) {
        type(By.name("group_name"), groupName);
        type(By.name("group_header"), groupHeader);
        type(By.name("group_footer"), groupFooter);
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void openGroupsPage() {
        wd.findElement(By.cssSelector("[href='group.php']")).click();
    }


    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification() {
        wd.findElement(By.name("edit")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    protected void submitContactCreation() {
        wd.findElement(By.cssSelector("[name='submit']:last-child")).click();
    }

    protected void fillContactForm(String name, String lastName, String address, String phone, String email) {
        type(By.name("firstname"), name);
        type(By.name("lastname"), lastName);
        type(By.name("address"), address);
        type(By.name("mobile"), phone);
        type(By.name("email"), email);
    }

    public void initContactCreation() {
        wd.findElement(By.cssSelector("[href='edit.php']")).click();
    }

    public void submitContactModification() {
        wd.findElement(By.cssSelector("[name='update'][value='Update']:last-child")).click();
    }

    public void initContactModification() {
        wd.findElement(By.cssSelector("[title='Edit']")).click();
    }

    public void deleteContact() {
        wd.findElement(By.cssSelector("[value='Delete']")).click();
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }
}
