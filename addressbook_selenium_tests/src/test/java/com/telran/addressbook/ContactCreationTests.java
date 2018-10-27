package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.contactHelper.initContactCreation();
        app.contactHelper.fillContactForm(new Contact().setName("name").setLastName("lastName").setAddress("address")
                .setPhone("0000000000").setEmail("email@domen.com"));
        app.contactHelper.submitContactCreation();
    }

}
