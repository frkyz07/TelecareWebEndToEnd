package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage  {
    public WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    By clinicID = By.xpath("//div[contains(@class, 'css-l5unw5-MuiTypography-root')]");
    By clinicName = By.xpath("//div[contains(@class, 'css-177qm3e-MuiTypography-root')]");




    public WebElement clinicId(){
        return driver.findElement(clinicID);
    }
    public WebElement clinicName(){
        return driver.findElement(clinicName);
    }



}
