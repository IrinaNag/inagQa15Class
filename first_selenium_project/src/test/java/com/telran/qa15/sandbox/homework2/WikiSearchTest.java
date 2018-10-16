package com.telran.qa15.sandbox.homework2;

import com.telran.qa15.sandbox.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiSearchTest extends TestBase {

    @Test
    public void testSearchingWikiJavaPage(){
        openWikipedia();
        findSearchAndTypeRequest();
        findLoupeAndClick();
        String currentUrl = wd.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://ru.wikipedia.org/wiki/Java");
    }

}
