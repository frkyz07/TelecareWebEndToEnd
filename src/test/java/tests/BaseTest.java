package tests;

import base.Base;
import base.Helper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pageObjects.CreateAccountPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.ProfilePage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Base {

  //  public static WebDriver driver;
    public static HomePage homePage;
    public static CreateAccountPage createAccountPage;
    public static DashboardPage dashboardPage;
    public static ProfilePage profilePage;
    public static Helper helper = new Helper(driver);


    @BeforeTest
    public WebDriver initialize() throws IOException {
        this.driver = initializeDriver();
       //
        driver.get(helper.conReader("url"));
        return this.driver;

    }

}
