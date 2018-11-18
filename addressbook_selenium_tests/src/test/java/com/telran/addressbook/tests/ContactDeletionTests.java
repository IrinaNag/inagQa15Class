package com.telran.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.contactHelper.contactPreconditions();
    }

    @Test
    public void testContactDeletion() {
        app.contactHelper.selectContact();
        app.contactHelper.deleteContact();
    }

}
