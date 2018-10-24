package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.getGroupHelper().groupPreconditions();
    }

    @Test
    public void testGroupDeletion(){
        app.getGroupHelper().openGroupsPage();
        int before = app.countElements();
        app.getGroupHelper().selectGroup();
        app.deleteGroupe();
        app.getGroupHelper().returnToGroupsPage();
        int aftere = app.countElements();
        Assert.assertEquals(aftere,before-1);
    }

}
