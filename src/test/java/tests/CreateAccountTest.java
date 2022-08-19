package tests;

import java.io.IOException;

import base.Base;
import base.Helper;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;


@SuppressWarnings("unused")
public class CreateAccountTest extends Base {
	public WebDriver driver;
	public Helper hl = new Helper(null);
	HomePage homePage;
	CreateAccountPage createAccountPage;
	Helper helper;
/*
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
	String practiceZipCode = faker.address().zipCode(); */

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(hl.url());
		Assert.assertEquals(driver.getCurrentUrl(), hl.url());
	}

	@Test
	public void HomePageVerification() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		CreateAccountPage cap = new CreateAccountPage(driver);
		hp.creteAccountPage().click();

		hl.inPutter(cap.nameField(),hl.name());
		hl.inPutter(cap.surnameField(),hl.surname());
		hl.inPutter(cap.email(),hl.email());
		hl.inPutter(cap.phoneNumber(),hl.phoneNumber());
		hl.inPutter(cap.password(),hl.password());
		hl.inPutter(cap.confirmPassword(),hl.password());
		cap.nextButton().click();

		hl.inPutter(cap.praticeName(),hl.name());
		hl.inPutter(cap.practicePhoneNumber(),hl.phoneNumber());
		hl.inPutter(cap.practiceAddress(),hl.practiceAddress());
		hl.inPutter(cap.practiceCity(),hl.practiceCity());
		hl.inPutter(cap.practiceZipCode(),hl.practiceZipCode());
		cap.nextButton().click();

		//hl.inPutter(cap.invitationEmail(),hl.email());
		//cap.invitationEmail().sendKeys(Keys.ENTER);
		cap.createAccountButton().click();
		Thread.sleep(3000);
		String urlAfter = driver.getCurrentUrl();
		Assert.assertEquals(hl.url(),urlAfter);
	}

	@AfterTest(enabled = false)
	public void destroyIt() {
		driver.quit();}

	}

