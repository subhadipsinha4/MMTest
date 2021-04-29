package com.market.qa.testcases;
import com.market.qa.actions.homePage_Actions;
import com.market.qa.baseTest.BaseTest;
import com.market.qa.pages.homePage;
import com.market.qa.pages.searchPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class homePage_TC extends BaseTest {
    homePage homepage;
    searchPage searchpage;
    public homePage_TC() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initilize();
        homepage=new homePage_Actions();
    }

    @Test(priority = 1)
    public void varifyedPageTitle()
    {
        homepage.verifyThePageTitle();
    }
    @Test(priority = 2)
    public void testWhishListIsPresentOrNot()
    {
        homepage.verifyTheWishlist();
    }
    @Test(priority = 3)
    public void testCartOptionIsPresentOrNot()
    {
        homepage.verifyTheCart();
    }
    @Test(priority = 4)
    public void testNewArrivalsIsPresentOrNot()
    {
        homepage.verifyNewArrival();
    }
    @Test(priority = 5)
    public void testProductClickIsWorkingOrNot()
    {
        homepage.productClickIsWorkingOrNot();
    }
    @Test(priority = 6)
    public void testAddToCartIsWorkingOrNot() throws InterruptedException {
        homepage.addToCartclickIsWorkingOrNot();
    }
    @Test(priority = 7)
    public void searchFromHomePage() throws IOException {
        searchpage=homepage.homePageSearch();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
