package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm("QA15", "header", "footer");
        submitGroupCreation();
        returnToGroupsPage();

    }

}
