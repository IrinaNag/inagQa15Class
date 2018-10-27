package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions() {
        app.contactHelper.contactPreconditions();
    }

    @Test
    public void testContactModification() {
        app.contactHelper.initContactModification();
        app.contactHelper.fillContactForm(new Contact().setName("newName").setLastName("newLastName").setAddress("newAddress")
                .setPhone("1111111111").setEmail("newEmail@domain.com"));
        app.contactHelper.submitContactModification();
    }

}
