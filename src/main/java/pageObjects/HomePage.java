package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver;
	HomePage homePage;


	//List<WebElement> origin = originDays();
	//int departureDay = Integer.parseInt(ConfigReader.getProperty("departureDay"));
	By flightSearch = By.id("FlightSearchFormWrapper");
	By welcome_header = By.xpath("//div/h1[@class='flight-landing-h1']");
	By originInput = By.id("OriginInput");
	By destinationInput = By.id("DestinationInput");
	By departureDate = By.id("DepartureDate");
	By originDateCalendar = By.id("DepartureDate");
	By originCitySelect = By.xpath("//div[@class='suggestion_item']");
	By destinationCitySelect = By.xpath("//div[@class='suggestion_item']");
	By originCalenderDays = By.xpath("//div/table/tbody/tr/td[@aria-disabled='false']");
	By oneWayCheckbox = By.id("oneWayCheckbox");
	By destinationDateCalendar = By.xpath("//div[@class='D_FSF__col returnDate__col D_FSF__focused_input'] /div[@class='FSF__input_overlay'])");
	By returnDayField = By.id("ReturnDate");
	By transitFilter = By.xpath("//div/label/input[@id='transitFilter']");
	By findTicket = By.xpath("//div/button[@data-testid='formSubmitButton']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement flightSearch() {
		return driver.findElement(flightSearch);
	}

	public WebElement welcomeHeader() {
		return driver.findElement(welcome_header);
	}

	public WebElement originInput() {
		return driver.findElement(originInput);
	}

	public WebElement destinationInput() {
		return driver.findElement(destinationInput);
	}

	public WebElement departureDate() {
		return driver.findElement(departureDate);
	}

	public WebElement originDateCalendar() {
		return driver.findElement(originDateCalendar);
	}

	public WebElement originCitySelect() {
		return driver.findElement(originCitySelect);
	}

	public WebElement destinationCitySelect() {
		return driver.findElement(destinationCitySelect);
	}

	public WebElement destinationDateCalendar() {
		return driver.findElement(destinationDateCalendar);
	}
	public WebElement returnDayField() {
		return driver.findElement(returnDayField);
	}

	public WebElement oneWayCheckbox() {
		return driver.findElement(oneWayCheckbox);
	}

	public WebElement transitFilter() {
		return driver.findElement(transitFilter);
	}
	public WebElement findTicket() {
		return driver.findElement(findTicket);
	}

	public WebElement daySelecter(int number) {
		return this.driver.findElements(originCalenderDays).get(number);
	}



	public boolean transitFilterCheck(boolean filter) {
		if (filter) {this.driver.findElement(transitFilter).click();
		} else {

		}
		return filter;
	}

}


	/*public void dayPicker(int number1){
		for (int i = 0; i <number1+1; i++) {
			if (i==number1){
				origin.get(i).click();
			}
			else{
				i++;
			}
		}

	}*/

