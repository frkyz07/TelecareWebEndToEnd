package tests;

import java.io.IOException;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;


public class CreateAccountTest extends BaseTest {

	@BeforeClass
	public void setDriver() throws IOException {
		homePage = new HomePage(driver);
		createAccountPage = new CreateAccountPage(driver);
		dashboardPage = new DashboardPage(driver);
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

		helper.inPutter(createAccountPage.invitationEmail(),helper.email());
		createAccountPage.invitationEmail().sendKeys(Keys.ENTER);

		createAccountPage.createAccountButton().click();
		Thread.sleep(3000);
		String urlAfter = driver.getCurrentUrl();
		Assert.assertEquals(helper.url(),urlAfter);
	}

	@AfterClass()
	public void destroyIt() {
		driver.quit();}

	}

