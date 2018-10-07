package com.telran.qa15.lesson2;

import com.telran.qa15.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiHomePageTests extends TestBase {

    @Test
    public void TestOpeningEnglishWiki() {
        findAndClickOnTheEnglishLink();
        String currentUrl = wd.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://en.wikipedia.org/wiki/Main_Page");
    }


}
