package com.telran.trello;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
    ApplicationManager app=new ApplicationManager();

    @BeforeClass
    public void setUp(){
        app.start();
    }

    @AfterClass
    public void tearDown(){
        app.stop();
    }
}
