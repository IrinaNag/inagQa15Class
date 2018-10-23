package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.openGroupsPage();
        int before= app.countElements();
        app.initGroupCreation();
        app.fillGroupForm(new Group().setGroupName("QA15").setGroupHeader("header").setGroupFooter("footer"));
        app.submitGroupCreation();
        app.returnToGroupsPage();
        int after= app.countElements();
        Assert.assertEquals(after,before+1);
    }

}
