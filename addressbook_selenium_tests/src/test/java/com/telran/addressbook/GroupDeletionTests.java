package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        groupPreconditions();
    }

    @Test
    public void testGroupDeletion(){
        openGroupsPage();
        selectGroup();
        deleteGroupe();
        returnToGroupsPage();
    }

}
