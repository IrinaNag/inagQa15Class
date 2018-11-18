package com.telran.addressbook.tests;

import com.telran.addressbook.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.EDGE));

    @BeforeSuite
    public void setUp() {
        app.start();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() {
        app.stop();
    }


}
