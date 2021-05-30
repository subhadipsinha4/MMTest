package com.market.qa.testcases;

import com.market.qa.actions.PDPPage_Actions;
import com.market.qa.actions.homePage_Actions;
import com.market.qa.actions.searchPage_Actions;
import com.market.qa.baseTest.BaseTest;
import com.market.qa.pages.PDPPage;
import com.market.qa.pages.homePage;
import com.market.qa.pages.searchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class search_TC extends BaseTest {

    searchPage searchpage;
    homePage homepage;
    PDPPage pdppage;
    public search_TC() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initilize();
        homepage=new homePage_Actions();
        searchpage=homepage.homePageSearch();
    }

    @Test(priority = 1)
    public void testSearchBoxIsPresentOrNot()
    {
        searchpage.searchBoxIsDisplayOrNot();
    }
    @Test(priority = 2)
    public void testSearchUsingEnterKeyIsWorkingOrNot(){
        searchpage.searchEnterKeyIsWorkingOrNot();
    }

    @Test(priority = 3)
    public void testSearchIconClickIsWorkingOrNot() throws InterruptedException {
        searchpage.searchIconClickIsWorkingOrNot();
    }
    @Test(priority = 4)
    public void testFacetClickIsWorkingOrNot() throws InterruptedException {
        searchpage.facteClick();
    }
    @Test(priority = 5)
    public void testFactTagIsDisplayOrNot()
    {
        searchpage.facetTagIsDisplayOrNot();
    }
    @Test(priority = 6)
    public void testMultipleFacetClick()
    {
        searchpage.multippleFacetTagIsDisplayOrNot();
    }

    @Test(priority = 7)
    public void testSelectedTagIsGettingRemovedOrNot() throws InterruptedException {
        searchpage.closeFacetTag();
    }
    @Test(priority = 8)
    public void testPriceSliderIsWorkingOrNot() throws InterruptedException {
        searchpage.testPriceSlider();
    }

    @Test(priority = 9)
    public void testListVieWorkingOrNot() throws InterruptedException, Exception {
        searchpage.testListVieWorkingOrNot();
    }
    @Test(priority = 10)
    public void testGridVieWorkingOrNot() throws InterruptedException, IOException {
        searchpage.testGridVieWorkingOrNot();
    }

    @Test(priority = 11)
    public void testSortLowToHigh() throws InterruptedException, IOException {
        searchpage.testSortLowToHighIsWorking();
    }

    @Test(priority = 12)
    public void testProductClickOnSRP() throws IOException {
        pdppage=searchpage.productClickOnSearchPage();

    }




    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
