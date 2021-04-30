package com.market.qa.pages;

import com.market.qa.baseTest.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class LoginPage  extends BaseTest {

    public LoginPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//a[@title='Account']")
    public WebElement checkAccountTab;

    @FindBy(xpath = "//li[@class='tab active']//div[@class='block-title']//p")
    public WebElement loginPageTitle;

    @FindBy(xpath = "//div[@class='row']//input[@name='login[username]']")
    public WebElement userEmail;

    @FindBy(xpath = "//div[@class='row']//input[@name='login[password]']")
    public WebElement userPassward;
    @FindBy(xpath = "//div[@class='row']//button[text()='Login']")
    public WebElement loginClick;



    public void loginPageTitle() throws InterruptedException {
        checkAccountTab.click();
        Thread.sleep(3000);
        System.out.println(loginPageTitle.getText());
        Assert.assertEquals(loginPageTitle.getText(),"Login or Create an Account","Page is not validated");
    }

    public searchPage loginUser() throws InterruptedException, IOException {
        checkAccountTab.click();
        Thread.sleep(3000);
        userEmail.sendKeys("subhadipsinha4@yahoo.com");
        userPassward.sendKeys("A@123456");
        loginClick.click();
        return new searchPage();
    }


}
