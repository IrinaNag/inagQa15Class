package com.telran.qa15.homework2;

import com.telran.qa15.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WikiSearchTest extends TestBase {

    @Test
    public void testSearchingWikiJavaPage(){
        findSearchAndTypeRequest();
        findLoupeAndClick();
        String currentUrl = wd.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://ru.wikipedia.org/wiki/Java");
    }

}
