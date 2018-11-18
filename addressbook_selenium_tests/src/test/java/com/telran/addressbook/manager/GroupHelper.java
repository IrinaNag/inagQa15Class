package com.telran.addressbook.manager;

import com.telran.addressbook.model.Group;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupsPage() {
        click(By.cssSelector("i [href='group.php']"));
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

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void creatGroup() {
        initGroupCreation();
        fillGroupForm(new Group().setGroupName("QA15").setGroupHeader("header").setGroupFooter("footer"));
        submitGroupCreation();
        returnToGroupsPage();
    }

    public void groupPreconditions() {
        openGroupsPage();
        if (!isGroupPresent()) {
            creatGroup();
        }
    }

    public void selectGroupByIndex(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteGroupe() {
        click(By.name("delete"));
    }

}
