package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm("name", "lastName", "address", "0000000000", "email@domen.com");
        submitContactCreation();

    }

}
