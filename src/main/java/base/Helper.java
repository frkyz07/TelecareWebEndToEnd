package base;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class Helper{

    WebDriver driver;
    WebDriverWait wait;
    ConfigReader configReader;
    Faker faker = new Faker();



    public Helper(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
    }

    public static void scroller(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,200)");
    }
    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public String conReader(String properties){
        return configReader.getProperty(properties);
    }
    public String assertionReader(String properties){
        return  configReader.getPropertyAssertion(properties);
    }
    public String url(){
        return conReader("url");
    }
    public String emailData(){
        return conReader("email");
    }
    public String passwordData(){
        return conReader("password");
    }

    public String checkUrl(){return conReader("assertionUrl");}
    public String checkHeader() {
        return conReader("assertionHeader");
    }
    public String searchName(){
        return assertionReader("searchName");
    }

    public String name(){return faker.name().firstName();}
    public String surname(){return faker.name().lastName();}
    public String email() {return fakeValuesService.bothify("????##@gmail.com");}
    public String phoneNumber(){return String.valueOf(faker.phoneNumber());}
    public String password(){return "123123";}
    public String practiceAddress(){return String.valueOf(faker.address());}
    public String practiceCity(){return faker.address().city();}
    public String practiceZipCode(){return faker.address().zipCode();}

    public void inPutter(WebElement element, String keys){
        element.sendKeys(keys);
    }
    public WebElement waitElement(By elementName)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        return driver.findElement(elementName);
    }



}
