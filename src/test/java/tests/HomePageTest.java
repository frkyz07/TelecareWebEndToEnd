package tests;

import java.io.IOException;

import base.Base;
import base.Helper;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
public class HomePageTest extends BaseTest {


    @BeforeClass
    public void setDriver() throws IOException {

        homePage = new HomePage(driver);
    }
    @Test
    public void webSiteBaseTest(){
        helper.inPutter(homePage.email(), helper.emailData());
        helper.inPutter(homePage.password(),helper.passwordData());
        homePage.signInClick().click();
    }


    @AfterTest()
    public void destroyIt() {
        driver.quit();}
}
