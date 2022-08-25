package tests;

import base.Base;
import base.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pageObjects.CreateAccountPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;

import java.io.IOException;




public class BaseTest extends Base {

    WebDriver driver;
    HomePage homePage;
    CreateAccountPage createAccountPage;
    DashboardPage dashboardPage;
    Helper helper = new Helper(null);


    @BeforeClass
    public WebDriver initialize() throws IOException {

        driver = initializeDriver();
        driver.get(helper.conReader("url"));
        return this.driver;

    }


}
