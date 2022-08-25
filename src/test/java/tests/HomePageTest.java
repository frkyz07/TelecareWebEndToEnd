package tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.DashboardPage;
import pageObjects.HomePage;

public class HomePageTest extends BaseTest {

    @BeforeClass
    public void setDriver() throws IOException {
        homePage = new HomePage(driver);
        dashboardPage = new DashboardPage(driver);
    }
    @Test(priority = 1)
    public void webSiteBaseTest(){
        helper.inPutter(homePage.email(), helper.emailData());
        helper.inPutter(homePage.password(),helper.passwordData());
        homePage.signInClick().click();
    }
    @Test(priority = 2)
    public void checkClinicId(){
        Assert.assertEquals(helper.assertionReader("assertionClinicId"),dashboardPage.clinicId().getText());
    }
    @Test(priority = 3)
    public void checkClinicName(){
        Assert.assertEquals(helper.assertionReader("assertionClinicName"),dashboardPage.clinicName().getText());
    }




    @AfterClass()
    public void destroyIt() {
        driver.quit();}
}
