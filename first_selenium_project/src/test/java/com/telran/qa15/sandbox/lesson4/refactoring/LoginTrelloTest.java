package com.telran.qa15.sandbox.lesson4.refactoring;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.telran.qa15.sandbox.TestBase;


public class LoginTrelloTest extends TestBase{

    @Test
    public void testLoginToTheTrello(){
        wd.get("https://trello.com/");
        //clickOnTheLoginButton
        wd.findElement(By.cssSelector("[href='/login?returnUrl=%2F']")).click();
    }
}
