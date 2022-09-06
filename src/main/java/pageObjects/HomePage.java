package pageObjects;

import base.Base;
import base.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

	static WebDriver driver;
	static Helper helper = new Helper(null);

	By creteAccountPage = By.xpath("//div/a[text()='Create an account']");
	By email = By.xpath("//div/input[@name='email']");
	By eMailWarning = By.xpath("//div[@data-testid='login-email-input-test']/p");
	By password = By.xpath("//div/input[@name='password']");
	By passwordWarning = By.xpath("//div[@data-testid='login-password-input-test']/p");
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
	public void login(String email, String password){
		helper.inPutter(email(), email);
		helper.inPutter(password(),password);
		signInClick().click();
	}

}




