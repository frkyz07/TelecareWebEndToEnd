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
    By firstRow = By.xpath("//div[@data-rowindex='0']");
    By searchField = By.xpath("//div/input[contains(@class, 'css-1tz2rhz-MuiInputBase')]");
    public By firstRowName = By.xpath("(//div[@data-field='nameSurname'])[2]");


    public WebElement clinicId(){
        return driver.findElement(clinicID);
    }
    public WebElement clinicName(){
        return driver.findElement(clinicName);
    }
    public WebElement firstRow(){
        return driver.findElement(firstRow);
    }
    public WebElement searchField(){
        return driver.findElement(searchField);
    }
    public WebElement firstRowName(){
        return driver.findElement(firstRowName);
    }

}
