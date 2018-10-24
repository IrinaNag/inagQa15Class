package com.telran.trello;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTests extends TestBase {

   @BeforeMethod
    public void preconditions(){
        app.logout();
    }

    @Test
    public void testLogin() throws InterruptedException {
        app.initLogin();
        app.fillLoginForm(new Account().seteMail("nagornovai@mail.ru").setPassword("987654321"));
        app.submitLogin();
        app.waitLoadingPage();
        Assert.assertEquals(app.getUrl(),"https://trello.com/irinanagornova/boards");

    }
}
