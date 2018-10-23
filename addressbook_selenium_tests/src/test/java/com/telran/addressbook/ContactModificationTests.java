package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.contactPreconditions();
    }

    @Test
    public void testContactModification() {
        app.initContactModification();
        app.fillContactForm(new Contact().setName("newName").setLastName("newLastName").setAddress("newAddress")
                .setPhone("1111111111").setEmail("newEmail@domain.com"));
        app.submitContactModification();
    }

}
