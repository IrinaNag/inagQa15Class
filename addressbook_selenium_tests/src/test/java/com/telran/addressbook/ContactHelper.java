package com.telran.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    protected void submitContactCreation() {
        click(By.cssSelector("[name='submit']:last-child"));
    }

    protected void fillContactForm(Contact contact) {
        type(By.name("firstname"), contact.getName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAddress());
        type(By.name("mobile"), contact.getPhone());
        type(By.name("email"), contact.getEmail());
    }

    public void initContactCreation() {
        click(By.cssSelector("[href='edit.php']"));
    }

    public void submitContactModification() {
        click(By.cssSelector("[name='update'][value='Update']:last-child"));
    }

    public void initContactModification() {
        click(By.cssSelector("[title='Edit']"));
    }

    public void deleteContact() {
        click(By.cssSelector("[value='Delete']"));
        Alert alert = wd.switchTo().alert();
        alert.accept();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void contactPreconditions() {
        if (!isElementPresent(By.name("selected[]"))) {
            creatContact();
        }
    }

    private void creatContact() {
        initContactCreation();
        fillContactForm(new Contact().setName("name").setLastName("lastName").setAddress("address")
                .setPhone("0000000000").setEmail("email@domen.com"));
        submitContactCreation();
    }

}
