package src.test.Academy;

import java.io.IOException;

import base.Base;
import base.ConfigReader;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FlightsPage;
import pageObjects.HomePage;
import pageObjects.PaymentPage;

import static base.Helper.*;


@SuppressWarnings("unused")
public class HomePageTest extends Base {
	public WebDriver driver;
	HomePage homePage;
	FlightsPage flightsPage;
	PaymentPage paymentPage;
	String url = ConfigReader.getProperty("url");
	String origin = ConfigReader.getProperty("origin");
	String destination = ConfigReader.getProperty("destination");
	int departureDay = Integer.parseInt(ConfigReader.getProperty("departureDay"));
	int returnDay = Integer.parseInt(ConfigReader.getProperty("returnDay"));
	boolean isDirect = Boolean.parseBoolean(ConfigReader.getProperty("isDirect"));

	String assertionUrl = ConfigReader.getPropertyAssertion("assertionUrl");
	String assertionHeader = ConfigReader.getPropertyAssertion("assertionHeader");



	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url);
	}

	@Test
	public void HomePageVerification() throws InterruptedException {
		try {
			//  Block of code to try
		}
		catch(Exception e) {
			//  Block of code to handle errors
		}
		HomePage hp = new HomePage(driver);
		FlightsPage fp = new FlightsPage(driver);
		PaymentPage pp = new PaymentPage(driver);

		try {
			Assert.assertEquals(hp.welcomeHeader().getText(),assertionHeader);
			Assert.assertEquals(hp.driver.getCurrentUrl(),assertionUrl);
		}
		catch(AssertionError e) {
			System.out.println("Website Could not opened properly "+e);
		}
		try {
			Assert.assertTrue(hp.originInput().isDisplayed());
			Assert.assertTrue(hp.originInput().isEnabled());
			hp.originInput().click();
			hp.originInput().sendKeys(origin);
		}
		catch(ElementClickInterceptedException | AssertionError e) {
			System.out.println("Click is intercepted "+e);
		}
		try {
			Assert.assertTrue(hp.originCitySelect().isDisplayed());
			Assert.assertTrue(hp.originCitySelect().isEnabled());
			hp.originCitySelect().click();
			hp.destinationInput().sendKeys(destination);
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		try {
			Assert.assertTrue(hp.destinationCitySelect().isDisplayed());
			Assert.assertTrue(hp.destinationCitySelect().isEnabled());
			hp.destinationCitySelect().click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		try {
			Assert.assertTrue(hp.originDateCalendar().isDisplayed());
			Assert.assertTrue(hp.originDateCalendar().isEnabled());
			hp.originDateCalendar().click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		try {
			//List<WebElement> origin = hp.originDays()
			scroller(driver);
			Assert.assertTrue(hp.daySelecter(departureDay).isDisplayed());
			Assert.assertTrue(hp.daySelecter(departureDay).isEnabled());
			hp.daySelecter(departureDay).click();
			//System.out.println(hp.daySelecter(departureDay).getAttribute("aria-label"));
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		try {
			Assert.assertTrue(hp.oneWayCheckbox().isDisplayed());
			Assert.assertTrue(hp.oneWayCheckbox().isEnabled());
			hp.oneWayCheckbox().click();

		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		String startDate = hp.departureDate().getAttribute("value");
		System.out.println(startDate);
		//hp.destinationDateCalendar().click();

		try {
			Assert.assertTrue(hp.daySelecter(returnDay).isDisplayed());
			Assert.assertTrue(hp.daySelecter(returnDay).isEnabled());
			hp.daySelecter(returnDay).click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}

		String returnDate = hp.returnDayField().getAttribute("value");
		System.out.println(returnDate);

		try {
			Assert.assertTrue(isDirect);
			hp.transitFilterCheck(isDirect);
		}
		catch(NullPointerException e) {
			System.out.println("Could not get the values from data.properties file "+e);
		}
		try {
			Assert.assertTrue(hp.findTicket().isDisplayed());
			Assert.assertTrue(hp.findTicket().isEnabled());
			hp.findTicket().click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		try {
			Assert.assertTrue(fp.originFlightPicker().isDisplayed());
			Assert.assertTrue(fp.originFlightPicker().isEnabled());
			fp.originFlightPicker().click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		String startFlightProviderName = fp.startFlightProvider().getText();

		//fp.details().click();
		//String startAirportName = fp.startAirPort().getText();
		//fp.detailsClose().click();

		try {
			Assert.assertTrue(fp.returnFlightPicker().isDisplayed());
			Assert.assertTrue(fp.returnFlightPicker().isEnabled());
			fp.returnFlightPicker().click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		String returnFlightProviderName = fp.returnFlightProvider().getAttribute("alt");

		//fp.returnDetails().click();
		//String returnFlightAirportName = fp.returnAirPort().getText();
		//fp.returnDetailsClose().click();

		try {
			Assert.assertTrue(fp.packagePicker().isDisplayed());
			Assert.assertTrue(fp.packagePicker().isEnabled());
			fp.packagePicker().click();
		}
		catch(ElementClickInterceptedException | NoSuchElementException e) {
			System.out.println("Click is intercepted or element couldn't found "+e);
		}
		try {
			Assert.assertEquals(origin+" "+destination,pp.reservationTitle().getText());
			Assert.assertEquals(startDate.split(",")[0],pp.startDate().getText().split(",")[0]); // check dates
			Assert.assertEquals(returnDate.split(",")[0],pp.returnDate().getText().split(",")[0]); // check dates
			Assert.assertEquals(startFlightProviderName,pp.flightProviderName().getText()); // check airline
			Assert.assertEquals(returnFlightProviderName,
					pp.returnFlightProviderName().getText()); // check airline
		}
		catch(AssertionError e) {
			System.out.println("Your values dont match "+e);
		}

		//Assert.assertEquals(startAirportName.split("-")[1].split(",")[1],
		//		pp.originAirport().getText().split(":")[2].split(",")[2].split("-")[0]); // check airport
		//Assert.assertEquals(returnFlightAirportName,pp.returnAirport().getText()); // check airport

	}

	@AfterTest(enabled = false)
	public void destroyIt() {
		driver.quit();
	}

	}

