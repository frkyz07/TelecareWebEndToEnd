package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;

import java.time.Duration;

public class Helper {

    static WebDriver driver;
    static WebDriverWait wait;


    public static void scroller(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
    }


}
