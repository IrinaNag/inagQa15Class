package com.telran.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.cssSelector("[type='submit']"));
    }

    public void type(By locator, String str) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(str);
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i [href='group.php']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(Group group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void openGroupsPage() {
        click(By.cssSelector("[href='group.php']"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    protected void submitContactCreation() {
        click(By.cssSelector("[name='submit']:last-child"));
    }

    protected void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAddress());
        type(By.name("mobile"), contact.getPhone());
        type(By.name("email"), contact.getEmail());
    }

    public void initContactCreation() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void submitContactModification() {
        click(By.cssSelector("[name='update'][value='Update']:last-child"));
    }

    public void initContactModification() {
        click(By.cssSelector("[title='Edit']"));
    }

    public void deleteContact() {
        click(By.cssSelector("[value='Delete']"));
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteGroupe() {
        click(By.name("delete"));
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

    public int countElements() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
