package tests;

import java.io.IOException;
import java.util.Locale;

import base.Base;
import base.ConfigReader;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;


@SuppressWarnings("unused")
public class HomePageTest extends Base {
	public WebDriver driver;
	HomePage homePage;
	CreateAccountPage createAccountPage;

	FakeValuesService fakeValuesService = new FakeValuesService(
			new Locale("en-GB"), new RandomService());

	String url = ConfigReader.getProperty("url");
	String assertionUrl = ConfigReader.getPropertyAssertion("assertionUrl");
	String assertionHeader = ConfigReader.getPropertyAssertion("assertionHeader");
	Faker faker = new Faker();
	String name = faker.name().firstName();
	String surname = faker.name().lastName();
	String email = fakeValuesService.bothify("????##@gmail.com");
	String phoneNumber = String.valueOf(faker.phoneNumber());
	String password = "123123";
	String praticeName = faker.name().fullName();
	String practiceAddress = String.valueOf(faker.address());
	String practiceCity = faker.address().city();
	String practiceZipCode = faker.address().zipCode();


	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(url);
		Assert.assertEquals(driver.getCurrentUrl(),url);
	}

	@Test
	public void HomePageVerification() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		hp.creteAccountPage().click();

		cap.nameField().sendKeys(name);
		cap.surnameField().sendKeys(surname);
		cap.email().sendKeys(email);
		cap.phoneNumber().sendKeys(phoneNumber);
		cap.password().sendKeys(password);
		cap.confirmPassword().sendKeys(password);
		cap.nextButton().click();

		cap.praticeName().sendKeys(praticeName);
		cap.practicePhoneNumber().sendKeys(phoneNumber);
		cap.practiceAddress().sendKeys(practiceAddress);
		cap.practiceCity().sendKeys(practiceCity);
		cap.practiceZipCode().sendKeys(practiceZipCode);
		cap.nextButton().click();

		cap.invitationEmail().sendKeys(email);
		cap.invitationEmail().sendKeys(Keys.ENTER);
		cap.createAccountButton().click();
		Thread.sleep(3000);
		String urlAfter = driver.getCurrentUrl();
		Assert.assertEquals(url,urlAfter);
	}

	@AfterTest(enabled = false)
	public void destroyIt() {
		driver.quit();
	}

	}

