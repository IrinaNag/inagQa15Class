package com.telran.addressbook;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.groupPreconditions();
    }

    @Test
    public void testGroupDeletion(){
        app.openGroupsPage();
        int before = app.countElements();
        app.selectGroup();
        app.deleteGroupe();
        app.returnToGroupsPage();
        int aftere = app.countElements();
        Assert.assertEquals(aftere,before-1);
    }

}
