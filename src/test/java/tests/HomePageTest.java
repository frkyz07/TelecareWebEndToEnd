package tests;

import java.io.IOException;

import base.Base;
import base.Helper;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
public class HomePageTest extends Base{

    public WebDriver driver;
    public Helper hl = new Helper(null);
    HomePage homePage;
    CreateAccountPage createAccountPage;
    Helper helper;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(hl.url());
        Assert.assertEquals(driver.getCurrentUrl(), hl.url());
    }
    @Test
    public void webSiteBaseTest(){
        HomePage hp = new HomePage(driver);
        hl.inPutter(hp.email(), hl.emailData());
        hl.inPutter(hp.password(),hl.passwordData());
        hp.signInClick().click();
    }
    @AfterTest()
    public void destroyIt() {
        driver.quit();}
}
