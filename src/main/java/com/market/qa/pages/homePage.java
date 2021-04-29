package com.market.qa.pages;

import com.market.qa.baseTest.BaseTest;
import org.glassfish.grizzly.compression.lzma.impl.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class homePage extends BaseTest {

    @FindBy (xpath="//h1[@class='logo']//a[@title]")
    public WebElement homePageLogo;
    @FindBy(xpath = "//a[text()='Wishlist']")
    public WebElement homeWishListTitle;
    @FindBy(xpath = "//a[text()='Cart']")
    public WebElement homePageCart;
    @FindBy(xpath = "//h2[@class='block-title']")
    public WebElement homePageNewArrival;
    public String homePageNewAr="New Arrivals";
    @FindBy(xpath = "//div[@unbxdparam_sku='WOCC84380']")
    public WebElement homePageProductClick;
    @FindBy(xpath = "//li[@class='product current']//span")
    public WebElement productTitlePDP;
    @FindBy(xpath = "//div[@unbxdparam_sku='WOCC84380']//a[@title='Add to Cart']")
    public WebElement addToCartHomePage;
    @FindBy (xpath = "//p[@class='product-name']//a")
    public WebElement addToCartProductTite;

    @FindBy (xpath = "//input[@id='search']")
    public WebElement searchBoxMM;
    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButtonMM;
    public String searchQuery="*";

    public homePage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }


    public searchPage homePageSearch() throws IOException {
        searchBoxMM.sendKeys(searchQuery);
        searchButtonMM.click();
        return new searchPage();
    }

    public void verifyThePageTitle()
    {
        Assert.assertEquals(homePageLogo.getAttribute("title"),"Miniature Market","Page title is not correct");
    }

    public void verifyTheWishlist()
    {
        Assert.assertEquals(homeWishListTitle.getText(),"Wishlist","Whish list is not getting displayed");
    }

    public void verifyTheCart()
    {
        Assert.assertEquals(homePageCart.getText(),"Cart","Cart is not getting displayed");
    }

    public void verifyNewArrival()
    {
        Assert.assertEquals(homePageNewArrival.getText(),homePageNewAr,"New Arrivals is not getting displayed");
    }

    public void productClickIsWorkingOrNot()
    {
        String productTitle=homePageProductClick.getAttribute("unbxdparam_title");
        homePageProductClick.click();
        Assert.assertEquals(productTitlePDP.getText(),productTitle,"Product click in home page is not working.");
    }

    public void addToCartclickIsWorkingOrNot() throws InterruptedException {
        String productTitle=homePageProductClick.getAttribute("unbxdparam_title");
        System.out.println(">"+productTitle);
        addToCartHomePage.click();
        Thread.sleep(2000);
        homePageCart.click();
        String cartProduct=addToCartProductTite.getText();
        System.out.println(">"+cartProduct);
        Assert.assertEquals(productTitle,cartProduct,"Add to cart button is not working.");

    }

}
