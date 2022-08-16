package pageObjects;

import base.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class FlightsPage {

    String provider = ConfigReader.getProperty("provider");

    public WebDriver driver;
    FlightsPage flightsPage;

    By originFlightPicker = By.xpath("//div[@data-booking-provider='"+provider+"']");
    By returnFlightPicker = By.xpath("(//div[@data-booking-provider='"+provider+"'])[2]//div[@class='flight-summary-radio']");
    By packagePicker = By.id("tooltipTarget_0");

    //div[@class='roundTrip return active']//div[@data-booking-provider='"+provider+"']

    By startFlightProvider = By.xpath("//div[@class='flight-item round-trip tr  active'] //div[@class='summary-marketing-airlines']");
    By details = By.xpath("(//div[@class='flight-item round-trip tr  active'] /div/div/div/span)[1]");
    By startAirPort = By.xpath("(//div[@class='combineAirportName noneWidth'])[1]");
    By detailsClose = By.className("skylight-close-button");
    By returnDetails= By.xpath("(//div[@class='flight-item round-trip tr  active'] /div/div/div/span)[2]");
    By returnAirPort = By.xpath("(//div[@class='combineAirportName noneWidth'])[1]");
    By returnDetailsClose = By.className("skylight-close-button");
    By price = By.xpath("//div/span[@class='price']");
    By returnFlightProvider = By.xpath("(//div/img[@class='airline-icon'])[2]");

    public FlightsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement originFlightPicker() {
        return driver.findElement(originFlightPicker);
    }

    public WebElement returnFlightPicker() {
        return driver.findElement(returnFlightPicker);
    }

    public WebElement packagePicker() {
        return driver.findElement(packagePicker);
    }
    public WebElement startFlightProvider() {
        return driver.findElement(startFlightProvider);
    }
    public WebElement returnFlightProvider() {
        return driver.findElement(returnFlightProvider);
    }
    public WebElement details() {
        return driver.findElement(details);
    }
    public WebElement detailsClose() {
        return driver.findElement(detailsClose);
    }
    public WebElement returnDetails() {
        return driver.findElement(returnDetails);
    }
    public WebElement returnAirPort() {
        return driver.findElement(returnAirPort);
    }
    public WebElement returnDetailsClose() {
        return driver.findElement(returnDetailsClose);
    }
    public WebElement price() {
        return driver.findElement(price);
    }



}
