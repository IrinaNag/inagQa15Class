package com.telran.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.*;

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

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
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

    protected void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAddress());
        type(By.name("mobile"), contact.getPhone());
        type(By.name("email"), contact.getEmail());
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

    public void deleteGroupe() {
        wd.findElement(By.name("delete")).click();
    }

    public boolean isElementPresent(By locator){
        try {
            wd.findElement(locator);
            return true;
        }catch(NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }

    public void creatGroup() {
        initGroupCreation();
        fillGroupForm(new Group().setGroupName("QA15").setGroupHeader("header").setGroupFooter("footer"));
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void groupPreconditions(){
        openGroupsPage();
        if(!isGroupPresent()){
            creatGroup();
        }
    }

    public void contactPreconditions(){
        if(!isElementPresent(By.name("selected[]"))){
            creatContact();
        }
    }

    private void creatContact() {
        initContactCreation();
        fillContactForm(new Contact().setName("name").setLastName("lastName").setAddress("address")
                .setPhone("0000000000").setEmail("email@domen.com"));
        submitContactCreation();
    }

}
