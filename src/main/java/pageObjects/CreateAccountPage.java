package pageObjects;

import base.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage{

    public static WebDriver driver;
    static Helper helper = new Helper(null);

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
    By nameWarning = By.xpath("(//p[contains(@class, 'css-qrbewk-MuiFormHelperText-root')])[1]");
    By surnameWarning = By.xpath("(//p[contains(@class, 'css-qrbewk-MuiFormHelperText-root')])[2]");
    By emailWarning = By.xpath("(//p[contains(@class, 'css-qrbewk-MuiFormHelperText-root')])[3]");
    By phoneNumberWarning = By.xpath("//div[contains(@class, 'css-z7rpld-MuiTypography-root')]");
    By passwordWarning = By.xpath("(//p[contains(@class, 'css-qrbewk-MuiFormHelperText-root')])[4]");
    By conformPasswordWarning = By.xpath("(//p[contains(@class, 'css-qrbewk-MuiFormHelperText-root')])[5]");

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
    public WebElement nameWarning(){
        return driver.findElement(nameWarning);
    }
    public WebElement surnameWarning(){
        return driver.findElement(surnameWarning);
    }
    public WebElement emailWarning(){
        return driver.findElement(emailWarning);
    }
    public WebElement phoneNumberWarning(){
        return driver.findElement(phoneNumberWarning);
    }
    public WebElement passwordWarning(){
        return driver.findElement(passwordWarning);
    }
    public WebElement conformPasswordWarning(){
        return driver.findElement(conformPasswordWarning);
    }


    public void setCreateAccountPageFirstPage(){
        helper.inPutter(nameField(),helper.name());
        helper.inPutter(surnameField(),helper.surname());
        helper.inPutter(email(),helper.email());
        helper.inPutter(phoneNumber(),helper.phoneNumber());
        helper.inPutter(password(),helper.password());
        helper.inPutter(confirmPassword(),helper.password());
        nextButton().click();
    }
    public void setCreateAccountPageSecondPage(){
        helper.inPutter(praticeName(),helper.name());
        helper.inPutter(practicePhoneNumber(),helper.phoneNumber());
        helper.inPutter(practiceAddress(),helper.practiceAddress());
        helper.inPutter(practiceCity(),helper.practiceCity());
        helper.inPutter(practiceZipCode(),helper.practiceZipCode());
        nextButton().click();
    }
    public void emptyClicks(){
        nameField().click();
        surnameField().click();
        email().click();
        phoneNumber().click();
        password().click();
        confirmPassword().click();
        nameField().click();
    }
    public void memberInvite(){
        helper.inPutter(invitationEmail(),helper.email());
        invitationEmail().sendKeys(Keys.ENTER);
    }
}

