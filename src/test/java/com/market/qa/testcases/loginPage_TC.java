package com.market.qa.testcases;

import com.market.qa.baseTest.BaseTest;
import com.market.qa.pages.LoginPage;
import com.market.qa.pages.searchPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class loginPage_TC extends BaseTest {
    LoginPage loginPage;
    searchPage searchpage;
    public loginPage_TC() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initilize();
        loginPage=new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() throws InterruptedException {
        loginPage.loginPageTitle();
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException, IOException {
        searchpage=loginPage.loginUser();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
