package com.market.qa.testcases;

import com.market.qa.actions.PDPPage_Actions;
import com.market.qa.actions.searchPage_Actions;
import com.market.qa.baseTest.BaseTest;
import com.market.qa.pages.PDPPage;
import com.market.qa.pages.homePage;
import com.market.qa.pages.searchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class pdpPage_TC extends BaseTest {
    public pdpPage_TC() throws IOException {
        super();
    }
    homePage homepage;
    searchPage searchpage;
    PDPPage pdppage;

    @BeforeMethod
    public void setUp() throws IOException {
        initilize();
        homepage=new homePage();
        searchpage=homepage.homePageSearch();
        pdppage=searchpage.productClickOnSearchPage();
    }

    @Test(priority = 1)
    public void productTitleOnPDP() throws IOException {
        pdppage.testProductTitleIsDisplayOrNot();
    }
    @Test(priority = 2)
    public void productImageOnPDP() throws IOException {
        pdppage.testProductImageIsDisplayOrNot();
    }
    @Test(priority = 3)
    public void productPriceOnPDP() throws IOException {
        pdppage.testProductPriceIsDisplayOrNot();
    }
    @Test(priority = 4)
    public void recsOnPDP() throws IOException {
        pdppage.testRecsIsDisplayOrNot();
    }


    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
