package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        initContactModification();
        fillContactForm("newName", "newLastName", "newAddress", "1111111111", "newEmail@domain.com");
        submitContactModification();
    }

}
