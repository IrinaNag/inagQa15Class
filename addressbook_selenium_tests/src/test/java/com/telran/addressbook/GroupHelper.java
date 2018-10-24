package com.telran.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
    WebDriver wd;

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

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
}
