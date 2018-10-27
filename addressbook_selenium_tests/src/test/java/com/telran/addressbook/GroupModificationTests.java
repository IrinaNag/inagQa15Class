package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getGroupHelper().groupPreconditions();
    }

    @Test
    public void testGroupModification() {
        app.getGroupHelper().openGroupsPage();
        int before = app.groupHelper.countElements();
        app.getGroupHelper().selectGroupByIndex(before - 1);
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new Group("modifyed", "newHeader", "newFooter"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.groupHelper.countElements();
        Assert.assertEquals(after, before);

    }

}
