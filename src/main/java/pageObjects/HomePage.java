package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver;
	HomePage homePage;

	By creteAccountPage = By.xpath("//div/a[text()='Create an account']");


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement creteAccountPage(){
		return driver.findElement(creteAccountPage);
	}


}




