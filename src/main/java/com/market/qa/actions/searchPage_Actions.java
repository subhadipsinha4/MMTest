package com.market.qa.actions;

import com.market.qa.pages.PDPPage;
import com.market.qa.pages.searchPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class searchPage_Actions extends searchPage {
    SoftAssert softAssert=new SoftAssert();

    public searchPage_Actions() throws IOException {
    }

//    public void searchBoxIsDisplayOrNot()
//    {
//        softAssert.assertEquals(searchBoxMM.isDisplayed(),true,"Search Box is not getting displayed.");
//    }
//    public void searchEnterKeyIsWorkingOrNot()
//    {
//        searchBoxMM.sendKeys(searchQuery+ Keys.ENTER);
//        String newURL=driver.getCurrentUrl();
//        softAssert.assertEquals(newURL.contains("searchresults"),true,"Search using enter key is not working");
//    }
//
//    public void searchIconClickIsWorkingOrNot()
//    {
//        searchBoxMM.sendKeys(searchQuery);
//        searchButtonMM.click();
//        String newURL=driver.getCurrentUrl();
//        softAssert.assertEquals(newURL.contains("searchresults"),true,"Search using enter key is not working");
//    }
//
//    public void productClickOnSearchPage() throws IOException {
//        searchBoxMM.sendKeys(searchQuery);
//        searchButtonMM.click();
//        searchPageProductClick.click();
//
//    }
//    public void productClickOnSearchPage() throws IOException {
//        searchBoxMM.sendKeys(searchQuery);
//        searchButtonMM.click();
//        searchPageProductClick.click();
//    }

}
