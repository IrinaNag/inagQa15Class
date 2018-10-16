package com.telran.qa15.sandbox.lesson2;

import com.telran.qa15.sandbox.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiHomePageTests extends TestBase {

    @Test
    public void TestOpeningEnglishWiki() {
        openWikipedia();
        findAndClickOnTheEnglishLink();
        String currentUrl = wd.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://en.wikipedia.org/wiki/Main_Page");
    }


}
