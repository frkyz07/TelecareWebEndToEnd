package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.ProfilePage;

public class HomePageTest extends BaseTest {


    @BeforeClass
    public void setDriver() throws IOException {
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
        profilePage = new ProfilePage(driver);
    }
    @Test(priority = 1)
    public void webSiteBaseTest(){
        BaseTest.login(helper.emailData(),helper.passwordData());
    }
    @Test(priority = 2)
    public void checkClinicId(){
        Assert.assertEquals(helper.assertionReader("assertionClinicId"),dashboardPage.clinicId().getText());
    }
    @Test(priority = 3)
    public void checkClinicName(){
        Assert.assertEquals(helper.assertionReader("assertionClinicName"),dashboardPage.clinicName().getText());
    }
    @Test(priority = 4)
    public void searchTest() throws InterruptedException {
        Assert.assertEquals(BaseTest.dashboardSearch(helper.searchName()),profilePage.profileName().getText());
        Assert.assertTrue(profilePage.profileName().getText().contains(helper.searchName()));
    }

    @AfterClass(enabled = false)
    public void destroyIt() {
        driver.quit();}
}
