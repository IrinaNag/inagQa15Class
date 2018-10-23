package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.groupPreconditions();
    }

    @Test
    public void testGroupModification() {
        app.openGroupsPage();
        int before = app.countElements();
        app.selectGroupByIndex(before-1);
        app.initGroupModification();
        app.fillGroupForm(new Group("modifyed", "newHeader", "newFooter"));
        app.submitGroupModification();
        app.returnToGroupsPage();
        int aftere = app.countElements();
        Assert.assertEquals(aftere,before);

    }

}
