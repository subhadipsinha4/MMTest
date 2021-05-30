package com.market.qa.pages;

import com.market.qa.actions.PDPPage_Actions;
import com.market.qa.baseTest.BaseTest;
import com.market.qa.util.TestUtil;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.market.qa.util.TestUtil.takeScreenshotAtEndOfTest;

public class searchPage extends BaseTest{

    public searchPage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@id='search']")
    public WebElement searchBoxMM;
    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButtonMM;
    public String searchQuery="*";
    @FindBy(xpath = "//div[@unbxdparam_sku='WOCC84380']")
    public WebElement searchPageProductClick;
    @FindBy(xpath = "//li[@class='facet_container list']//a[contains(text(),'Clearance')]")
    public WebElement facetProductTagClearance;
    @FindBy(xpath = "//li[@class='facet_container list']//a[contains(text(),'Clearance')]//span")
    public WebElement factCount;
    @FindBy(xpath = "//div[@class='product-count']")
    public WebElement productCountSearch;
    @FindBy(xpath = "//span[@class='searchspring-summary_label']")
    public WebElement productTag;
    @FindBy(xpath = "//span[@class='searchspring-summary_value']")
    public WebElement tagValue;
    @FindBy(xpath = "//li[@class='facet_container list']//a[contains(text(),'In Stock')]")
    public WebElement inStockFacet;
//    @FindBy(xpath = "//li[@class='badge']//span[@class='searchspring-summary_value']")
//    public WebElement allTagValue;
    public String allTagValue="//li[@class='badge']//span[@class='searchspring-summary_value']";
    //public String facetTag="//li[@class='badge']";
    @FindBy(xpath = "//li[@class='badge']")
    public WebElement facetTag;

    @FindBy(xpath = "//div[@class='noUi-base']")
    public WebElement priceSlider;
    @FindBy(xpath = "//div[@class='noUi-handle noUi-handle-lower']")
    public WebElement lowerHandle;
    @FindBy(xpath = "//div[@class='noUi-handle noUi-handle-upper']")
    public WebElement upperHandle;
    @FindBy(xpath = "//div[@class='slider noUi-target noUi-ltr noUi-horizontal noUi-txt-dir-ltr']//div[@style='transform: translate(-923.288%, 0px); z-index: 5;']")
    public WebElement pricesliderMin;
    public String priceMinSlider="//div[@class='noUi-handle noUi-handle-lower']";
    public String priceMaxSlider="//div[@class='noUi-handle noUi-handle-upper']";
    public String sliderValue="aria-valuetext";
    @FindBy(xpath = "//a[@title='Grid']")
    public WebElement gridView;
    @FindBy(xpath = "//div[@class='view-mode control-set']//a[@title='List']")
    public WebElement listView;
    @FindBy(xpath = "//div[@class='sort-mode control-set']//ul[@class]")
    public WebElement sortBoxDropDown;
    @FindBy(xpath = "//div[@class='sort-mode control-set']//i[@class]")
    public WebElement sortDropDown;
    public String allSortOptions="sort-options";
    @FindBy(id="sort-options")
    public WebElement sortOPtions;
    public String allSortOptions2=".//*[@id='sort-options']";
    @FindBy(xpath = "//li[@class='selected']//a")
    public WebElement validateSelectedSort;


    public void searchBoxIsDisplayOrNot()
    {
        Assert.assertEquals(searchBoxMM.isDisplayed(),true,"Search Box is not getting displayed.");
    }
    public void searchEnterKeyIsWorkingOrNot()
    {
        searchBoxMM.sendKeys(searchQuery+ Keys.ENTER);
        String newURL=driver.getCurrentUrl();
        Assert.assertEquals(newURL.contains("searchresults"),true,"Search using enter key is not working");
    }

    public void searchIconClickIsWorkingOrNot()
    {
        searchBoxMM.sendKeys(searchQuery);
        searchButtonMM.click();
        String newURL=driver.getCurrentUrl();
        Assert.assertEquals(newURL.contains("searchresults"),true,"Search using enter key is not working");
    }

    public void facteClick() throws InterruptedException {
        facetProductTagClearance.click();
       String facetCount=factCount.getText().replace("(","").replace(")","");
        Thread.sleep(3000);
        String  productCountSRP=productCountSearch.getText().replace("( ","").replace(" )","");
       Assert.assertEquals(productCountSRP,facetCount,"facet click is not working.");
    }
    public void facetTagIsDisplayOrNot()
    {
        facetProductTagClearance.click();
        String facetName[]=facetProductTagClearance.getText().split(" ");
        Assert.assertEquals(facetName[0],tagValue.getText().replace("\"",""),"Correct facet tag is not getting displayed.");
    }
    public void multippleFacetTagIsDisplayOrNot()
    {
        String facetnames;
        List<String> facetName=new ArrayList<String>();
        List<String> tagName=new ArrayList<String>();
        facetProductTagClearance.click();
        facetnames=facetProductTagClearance.getText().replaceAll("[0-9]","").replace("(","").replace(")","");
        facetName.add(facetnames.trim());
        inStockFacet.click();
        facetnames=inStockFacet.getText().replaceAll("[0-9]","").replace("(","").replace(")","");
        facetName.add(facetnames.trim());
        List<WebElement> allTagValues= driver.findElements(By.xpath(allTagValue));
        for(int i=0;i<allTagValues.size();i++)
            tagName.add(allTagValues.get(i).getText().replace("\"",""));
        Assert.assertEquals(facetName,tagName,"Multiple facet click is not working.");
    }

    public void closeFacetTag() throws InterruptedException {
        String oldUrl=driver.getCurrentUrl();
        facetProductTagClearance.click();
        String newUrl=driver.getCurrentUrl();
        facetTag.click();
        Assert.assertEquals(oldUrl,driver.getCurrentUrl(),"Selected facet is getting removed. ");
        

    }

    public void testPriceSlider() throws InterruptedException {
        String minSlider=lowerSliderCheck();
        Thread.sleep( 2000 );
        String maxValue=upperSliderCheck();
        String[] priceSliderTagValues=tagValue.getText().replace( "\"[","" ).replace( "]\"","" ).trim().split( "TO" );
        Assert.assertEquals( priceSliderTagValues[0].replaceAll( " ","" ),minSlider,"Slider min value is not working." );
        Assert.assertEquals( priceSliderTagValues[1].replaceAll( " ","" ),maxValue,"Slider max value is not working." );
    }
    public String  lowerSliderCheck()
    {
        Actions move = new Actions(driver);
        move.dragAndDropBy(lowerHandle, 30, 0).build().perform();
        String minValue=driver.findElement( By.xpath( priceMinSlider )).getAttribute(sliderValue);
        return minValue;
    }

    public String upperSliderCheck()
    {
        Actions move = new Actions(driver);
        move.dragAndDropBy(upperHandle, -30, 0).build().perform();
        String maxValue=driver.findElement( By.xpath( priceMaxSlider )).getAttribute(sliderValue);
        return maxValue;

    }
    public void testListVieWorkingOrNot() throws Exception {
        listView.click();
        takeScreenshotAtEndOfTest();
    }
    public void testGridVieWorkingOrNot() throws IOException {
        gridView.click();
        takeScreenshotAtEndOfTest();
    }

    public void testSortLowToHighIsWorking() throws InterruptedException {
        sortDropDown.click();
        List<WebElement> allOPtion=driver.findElements( By.xpath( "//div[@class='sort-mode control-set']//li[@class]" ) );
        for(int i=0;i<allOPtion.size();i++) {
            if (allOPtion.get( i ).getText().equals( "Price ($ - $$$)" )) {
                System.out.println(">>"+allOPtion.get( i ).getText());
                allOPtion.get( i ).click();
            }
        }
        //CODE FOR VALIDATING PART



    }
    public PDPPage productClickOnSearchPage() throws IOException {
        searchBoxMM.sendKeys(searchQuery);
        searchButtonMM.click();
        searchPageProductClick.click();
        return new PDPPage();

    }



}
