package com.market.qa.pages;

import com.market.qa.actions.PDPPage_Actions;
import com.market.qa.baseTest.BaseTest;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class PDPPage extends BaseTest {

    @FindBy(xpath = "//h1[@class='product-name']")
    public WebElement productTitlePDP;
    @FindBy(xpath = "//img[@id='image']")
    public WebElement productImagePDP;
    @FindBy(xpath = "//div[@class='price-box']//span[@class='price']")
    public WebElement productPricePDP;
    @FindBy(xpath = "//div[@id='unbxd-rec']")
    public WebElement recomandationPDP;

    public PDPPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }



    public void testProductTitleIsDisplayOrNot() throws IOException {
        Assert.assertTrue(productTitlePDP.isDisplayed(),"Product title is not getting displayed.");
    }

    public void testProductImageIsDisplayOrNot()
    {
        Assert.assertTrue(productImagePDP.isDisplayed(),"Product image is not getting displayed.");
    }

    public void testProductPriceIsDisplayOrNot()
    {
        Assert.assertTrue(productPricePDP.isDisplayed(),"Product price is not getting displayed.");
    }
    public void testRecsIsDisplayOrNot()
    {
        Assert.assertTrue(recomandationPDP.isDisplayed(),"Recs is not getting displayed in PDP.");
    }


}
