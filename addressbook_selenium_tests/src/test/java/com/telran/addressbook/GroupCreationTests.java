package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getGroupHelper().openGroupsPage();
        int before = app.groupHelper.countElements();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new Group().setGroupName("QA15").setGroupHeader("header").setGroupFooter("footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.groupHelper.countElements();
        Assert.assertEquals(after, before + 1);
    }

}
