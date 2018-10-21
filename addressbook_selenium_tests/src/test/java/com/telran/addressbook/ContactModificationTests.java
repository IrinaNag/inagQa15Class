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
        fillContactForm(new Contact("newName", "newLastName", "newAddress", "1111111111", "newEmail@domain.com"));
        submitContactModification();
    }

}
