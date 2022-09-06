package tests;

import java.io.IOException;

import base.Base;
import base.Helper;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.CreateAccountPage;
import pageObjects.DashboardPage;
import pageObjects.HomePage;


public class CreateAccountTest extends BaseTest {


	public void setDriver() throws IOException {
		initialize();
		homePage = new HomePage(driver);
		createAccountPage = new CreateAccountPage(driver);
		dashboardPage = new DashboardPage(driver);
		//helper = new Helper(driver);
	}

	@Test
	public void CreateDoctorAccount() throws InterruptedException, IOException {
		setDriver();
		homePage.creteAccountPage().click();
		createAccountPage.setCreateAccountPageFirstPage();
		createAccountPage.setCreateAccountPageSecondPage();
	//	createAccountPage.memberInvite();
		createAccountPage.createAccountButton().click();
		Thread.sleep(3000);
		String urlAfter = driver.getCurrentUrl();
		Assert.assertEquals(helper.url(),urlAfter);
	}
	@Test
	public void CheckTheFields() throws IOException {
		setDriver();
		homePage.creteAccountPage().click();
		createAccountPage.emptyClicks();
		Assert.assertEquals(helper.assertionReader("nameWarning"),createAccountPage.nameWarning().getText());
		Assert.assertEquals(helper.assertionReader("surnameWarning"),createAccountPage.surnameWarning().getText());
		Assert.assertEquals(helper.assertionReader("emailWarning"),createAccountPage.emailWarning().getText());
		Assert.assertEquals(helper.assertionReader("phoneNumberWarning"),createAccountPage.phoneNumberWarning().getText());
		Assert.assertEquals(helper.assertionReader("passwordWarning"),createAccountPage.passwordWarning().getText());
		Assert.assertEquals(helper.assertionReader("conformPasswordWarning"),createAccountPage.conformPasswordWarning().getText());
	}

	@AfterClass(enabled = false)
	public void destroyIt() {
		driver.quit();}

	}

