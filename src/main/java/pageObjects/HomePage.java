package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

	public WebDriver driver;
	HomePage homePage;

	By creteAccountPage = By.xpath("//div/a[text()='Create an account']");
	By email = By.xpath("//div/input[@name='email']");
	By eMailWarning = By.xpath("(//*[contains(@class,'error')])[3]");
	By password = By.xpath("//div/input[@name='password']");
	By passwordWarning = By.xpath("(//*[contains(@class,'error')])[6]");
	By signInClick = By.xpath("//button[@data-testid='login-login-btn-test']");


	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement creteAccountPage(){
		return driver.findElement(creteAccountPage);}

	public WebElement eMailWarning(){
		return driver.findElement(eMailWarning);
	}
	public WebElement passwordWarning(){
		return driver.findElement(passwordWarning);
	}
	public WebElement email(){
		return driver.findElement(email);
	}
	public WebElement password(){
		return driver.findElement(password);
	}
	public WebElement signInClick(){
		return driver.findElement(signInClick);
	}




}




