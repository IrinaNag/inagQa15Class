package com.telran.trello;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    WebDriverWait wait;

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String str) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(str);
    }


    public void start() {
        wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        wd.get("https://trello.com/");
        login(new Account().seteMail("nagornovai@mail.ru").setPassword("987654321"));
    }

    private void login(Account account) {
        initLogin();
        fillLoginForm(account);
        submitLogin();
        waitLoadingPage();
    }

    public void stop() {
        wd.quit();
    }

    public void logout() {
        click(By.className("member"));
        click(By.className("js-logout"));
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(Account account) {
        type(By.name("user"),account.geteMail());
        type(By.name("password"),account.getPassword());
    }

    public void submitLogin() {
        click(By.id("login"));
    }

    public String getUrl() {
        return wd.getCurrentUrl();
    }

    public void waitLoadingPage() {
        wait=new WebDriverWait(wd, 5);
        wait.until(ExpectedConditions.urlContains("boards"));
    }
}
