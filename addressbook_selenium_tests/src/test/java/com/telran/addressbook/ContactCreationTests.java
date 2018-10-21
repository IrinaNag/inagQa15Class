package com.telran.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        initContactCreation();
        fillContactForm(Contact.builder().name("name").lastName("lastName").address("address")
                .phone("0000000000").email("email@domen.com").build());
        submitContactCreation();
    }

}
