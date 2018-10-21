package com.telran.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        openGroupsPage();
        initGroupCreation();
        fillGroupForm(new Group().setGroupName("QA15").setGroupHeader("header").setGroupFooter("footer"));
        submitGroupCreation();
        returnToGroupsPage();

    }

}
