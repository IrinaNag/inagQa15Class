package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        groupPreconditions();
    }

    @Test
    public void testGroupModification() {
        openGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupForm(new Group("modifyed", "newHeader", "newFooter"));
        submitGroupModification();
        returnToGroupsPage();

    }

}
