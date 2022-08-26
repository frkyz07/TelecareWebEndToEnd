package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    By profileName = By.xpath("//div[contains(@class, 'css-q5yoyf-MuiTypography-root')]");


    public WebElement profileName(){
        return driver.findElement(profileName);
    }



}
