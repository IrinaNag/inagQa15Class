package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(new Contact().setName("name").setLastName("lastName").setAddress("address")
                .setPhone("0000000000").setEmail("email@domen.com"));
        submitContactCreation();
    }

}
