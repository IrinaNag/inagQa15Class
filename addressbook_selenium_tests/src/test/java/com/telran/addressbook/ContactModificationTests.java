package com.telran.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void preconditions(){
        contactPreconditions();
    }

    @Test
    public void testContactModification() {
        initContactModification();
        fillContactForm(new Contact().setName("newName").setLastName("newLastName").setAddress("newAddress")
                .setPhone("1111111111").setEmail("newEmail@domain.com"));
        submitContactModification();
    }

}
