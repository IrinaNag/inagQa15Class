package com.telran.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private GroupHelper groupHelper;
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
        groupHelper=new GroupHelper();
    }

    public void stop() {
        wd.quit();
    }

    public void login(String userName, String password) {
        groupHelper.type(By.name("user"), userName);
        groupHelper.type(By.name("pass"), password);
        groupHelper.click(By.cssSelector("[type='submit']"));
    }

    protected void submitContactCreation() {
        groupHelper.click(By.cssSelector("[name='submit']:last-child"));
    }

    protected void fillContactForm(Contact contact) {
        groupHelper.type(By.name("firstname"), contact.getName());
        groupHelper.type(By.name("lastname"), contact.getLastName());
        groupHelper.type(By.name("address"), contact.getAddress());
        groupHelper.type(By.name("mobile"), contact.getPhone());
        groupHelper.type(By.name("email"), contact.getEmail());
    }

    public void initContactCreation() {
        groupHelper.click(By.cssSelector("[href='edit.php']"));
    }

    public void submitContactModification() {
        groupHelper.click(By.cssSelector("[name='update'][value='Update']:last-child"));
    }

    public void initContactModification() {
        groupHelper.click(By.cssSelector("[title='Edit']"));
    }

    public void deleteContact() {
        groupHelper.click(By.cssSelector("[value='Delete']"));
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public void selectContact() {
        groupHelper.click(By.name("selected[]"));
    }

    public void deleteGroupe() {
        groupHelper.click(By.name("delete"));
    }

    public void contactPreconditions(){
        if(!groupHelper.isElementPresent(By.name("selected[]"))){
            creatContact();
        }
    }

    private void creatContact() {
        initContactCreation();
        fillContactForm(new Contact().setName("name").setLastName("lastName").setAddress("address")
                .setPhone("0000000000").setEmail("email@domen.com"));
        submitContactCreation();
    }

    public int countElements() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
