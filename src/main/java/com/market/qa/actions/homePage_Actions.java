package com.market.qa.actions;

import com.market.qa.pages.homePage;
import org.testng.Assert;

import java.io.IOException;

public class homePage_Actions extends homePage {

    public homePage_Actions() throws IOException {
    }

//    public void verifyThePageTitle()
//    {
//        Assert.assertEquals(homePageLogo.getAttribute("title"),"Miniature Market","Page title is not correct");
//    }
//
//    public void verifyTheWishlist()
//    {
//        Assert.assertEquals(homeWishListTitle.getText(),"Wishlist","Whish list is not getting displayed");
//    }
//
//    public void verifyTheCart()
//    {
//        Assert.assertEquals(homePageCart.getText(),"Cart","Cart is not getting displayed");
//    }
//
//    public void verifyNewArrival()
//    {
//        Assert.assertEquals(homePageNewArrival.getText(),homePageNewAr,"New Arrivals is not getting displayed");
//    }
//
//    public void productClickIsWorkingOrNot()
//    {
//        String productTitle=homePageProductClick.getAttribute("unbxdparam_title");
//        homePageProductClick.click();
//        Assert.assertEquals(productTitlePDP.getText(),productTitle,"Product click in home page is not working.");
//    }
//
//    public void addToCartclickIsWorkingOrNot() throws InterruptedException {
//        String productTitle=homePageProductClick.getAttribute("unbxdparam_title");
//        System.out.println(">"+productTitle);
//        addToCartHomePage.click();
//        Thread.sleep(2000);
//        homePageCart.click();
//        String cartProduct=addToCartProductTite.getText();
//        System.out.println(">"+cartProduct);
//        Assert.assertEquals(productTitle,cartProduct,"Add to cart button is not working.");
//
//    }


}
