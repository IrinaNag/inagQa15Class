package com.telran.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion(){
        openGroupsPage();
        selectGroup();
        deleteGroupe();
        returnToGroupsPage();
    }

    public void deleteGroupe() {
        wd.findElement(By.name("delete")).click();
    }
}
