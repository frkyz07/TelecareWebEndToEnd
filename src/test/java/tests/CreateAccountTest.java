package tests;

import java.io.IOException;

import base.Helper;
import org.openqa.selenium.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;


@SuppressWarnings("unused")
public class CreateAccountTest extends BaseTest {
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

	@BeforeClass
	public void setDriver() throws IOException {

		homePage = new HomePage(driver);
		createAccountPage = new CreateAccountPage(driver);
	}

	@Test
	public void HomePageVerification() throws InterruptedException {


		homePage.creteAccountPage().click();

		helper.inPutter(createAccountPage.nameField(),helper.name());
		helper.inPutter(createAccountPage.surnameField(),helper.surname());
		helper.inPutter(createAccountPage.email(),helper.email());
		helper.inPutter(createAccountPage.phoneNumber(),helper.phoneNumber());
		helper.inPutter(createAccountPage.password(),helper.password());
		helper.inPutter(createAccountPage.confirmPassword(),helper.password());
		createAccountPage.nextButton().click();

		helper.inPutter(createAccountPage.praticeName(),helper.name());
		helper.inPutter(createAccountPage.practicePhoneNumber(),helper.phoneNumber());
		helper.inPutter(createAccountPage.practiceAddress(),helper.practiceAddress());
		helper.inPutter(createAccountPage.practiceCity(),helper.practiceCity());
		helper.inPutter(createAccountPage.practiceZipCode(),helper.practiceZipCode());
		createAccountPage.nextButton().click();

		//hl.inPutter(cap.invitationEmail(),hl.email());
		//cap.invitationEmail().sendKeys(Keys.ENTER);
		createAccountPage.createAccountButton().click();
		Thread.sleep(3000);
		String urlAfter = driver.getCurrentUrl();
		Assert.assertEquals(helper.url(),urlAfter);
	}

	@AfterTest(enabled = false)
	public void destroyIt() {
		driver.quit();}

	}

