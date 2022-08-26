package tests;

import base.Base;
import base.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import pageObjects.CreateAccountPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;
import pageObjects.ProfilePage;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest extends Base {

    static WebDriver driver;
    static HomePage homePage;
    static WebDriverWait wait;
    CreateAccountPage createAccountPage;
    static DashboardPage dashboardPage;
    ProfilePage profilePage;
    static Helper helper;



    @BeforeClass
    public WebDriver initialize() throws IOException {
        driver = initializeDriver();
        helper = new Helper(driver);
        driver.get(helper.conReader("url"));
        return this.driver;

    }
    public static void login(String email, String password){
        helper.inPutter(homePage.email(), email);
        helper.inPutter(homePage.password(),password);
        homePage.signInClick().click();
    }
    public static String dashboardSearch(String search) throws InterruptedException {
        dashboardPage.searchField().sendKeys(search);
        String firstRowRealName = dashboardPage.firstRowName().getText();
        helper.waitElement(dashboardPage.firstRowName);
        dashboardPage.firstRowName().click();
        return firstRowRealName;

    }



}
