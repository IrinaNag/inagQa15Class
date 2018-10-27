package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.getGroupHelper().groupPreconditions();
    }

    @Test
    public void testGroupDeletion() {
        app.getGroupHelper().openGroupsPage();
        int before = app.groupHelper.countElements();
        app.getGroupHelper().selectGroup();
        app.groupHelper.deleteGroupe();
        app.getGroupHelper().returnToGroupsPage();
        int after = app.groupHelper.countElements();
        Assert.assertEquals(after, before - 1);
    }

}
