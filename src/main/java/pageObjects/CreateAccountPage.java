package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage {
    public WebDriver driver;
    CreateAccountPage createAccountPage;

    By nameField = By.xpath("//div/input[@name='name']");
    By surnameField = By.xpath("//div/input[@name='surname']");
    By email = By.xpath("//div/input[@name='email']");
    By phoneNumber = By.xpath("//div/input[@name='phone']");
    By password = By.xpath("//div/input[@name='password']");
    By confirmPassword = By.xpath("//div/input[@name='confirmPassword']");
    By nextButton = By.xpath("//button[text()='Next']");
    By praticeName = By.xpath("//div/input[@name='practiceName']");
    By practicePhoneNumber = By.xpath("//div/input[@name='practicePhoneNumber']");
    By practiceAddress = By.xpath("//div/input[@name='practiceAddress']");
    By practiceCity = By.xpath("//div/input[@name='practiceCity']");
    By practiceZipCode = By.xpath("//div/input[@name='practiceZipCode']");
    By invitationEmail = By.xpath("//div/input[@name='invitationEmail']");
    By createAccountButton = By.xpath("//button[text()='Create account']");



    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement nameField(){
        return driver.findElement(nameField);
    }
    public WebElement surnameField(){
        return driver.findElement(surnameField);
    }
    public WebElement email(){
        return driver.findElement(email);
    }
    public WebElement phoneNumber(){
        return driver.findElement(phoneNumber);
    }
    public WebElement password(){
        return driver.findElement(password);
    }
    public WebElement confirmPassword(){
        return driver.findElement(confirmPassword);
    }
    public WebElement nextButton(){
        return driver.findElement(nextButton);
    }
    public WebElement praticeName(){
        return driver.findElement(praticeName);
    }
    public WebElement practicePhoneNumber(){
        return driver.findElement(practicePhoneNumber);
    }
    public WebElement practiceAddress(){
        return driver.findElement(practiceAddress);
    }
    public WebElement practiceCity(){
        return driver.findElement(practiceCity);
    }
    public WebElement practiceZipCode(){
        return driver.findElement(practiceZipCode);
    }
    public WebElement invitationEmail(){
        return driver.findElement(invitationEmail);
    }
    public WebElement createAccountButton(){
        return driver.findElement(createAccountButton);
    }
}

