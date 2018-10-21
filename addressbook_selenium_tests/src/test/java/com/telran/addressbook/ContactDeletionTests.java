package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        contactPreconditions();
    }

    @Test
    public void testContactDeletion() {
        selectContact();
        deleteContact();
    }

}
