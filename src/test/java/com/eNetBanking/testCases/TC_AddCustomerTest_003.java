package com.eNetBanking.testCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.AddCustomerPage;
import com.eNetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered.");
		lp.setPassword(password);
		logger.info("Password entered.");
		lp.clickSubmit();
		logger.info("Login successful.");
		Thread.sleep(2000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("Clicked on AddNewCustomer option.");

		// Ads pop-up handling
		// Get element in frame by ID
		WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		// Switch to frame with element
		driver.switchTo().frame(frame1);
		// Check button X or Close displays
		List<WebElement> checkButtonX = driver.findElements(By.xpath("//div[@id='dismiss-button']"));
		if (checkButtonX.size() > 0) {
			driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
		} else {
			WebElement frame2 = driver.findElement(By.id("ad_iframe"));
			driver.switchTo().frame(frame2);
			Thread.sleep(1000);
			List<WebElement> checkButtonClose = driver
					.findElements(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']"));
			if (checkButtonClose.size() > 0) {
				driver.findElement(By.xpath("//div[@id='dismiss-button']//span[normalize-space()='Close']")).click();
			} else {
				driver.findElement(By.xpath("//div[@id='dismiss-button']")).click();
			}
		}

		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		logger.info("Providing customer details!");

		addcust.custName("Rahul");
		logger.info("Customer name entered.");
		addcust.custGender("male");
		logger.info("Customer gender clicked.");
		Thread.sleep(1000);
		addcust.custdob("17", "07", "1994");
		logger.info("Customer date of birth entered.");
		Thread.sleep(2000);
		addcust.custAdderss("India");
		logger.info("Customer address entered.");
		addcust.custCity("Pune");
		logger.info("Customer city entered.");
		Thread.sleep(1000);
		addcust.custState("Maharashtra");
		logger.info("Customer state entered.");
		addcust.custPinNo("411038");
		logger.info("Customer pin code entered.");

		Thread.sleep(2000);
		String phoneno = randomPhoneNo();
		addcust.custTelephoneNo(phoneno);
		logger.info("Customer phone no entered.");

		Thread.sleep(2000);
		String email = randomEmail() + "@gmail.com";
		addcust.custEmailId(email);
		logger.info("Customer email entered.");
		Thread.sleep(1000);
		String password = randomPassword();
		addcust.custPassword(password);
		logger.info("Password entered.");
		addcust.custSubmit();
		logger.info("Clicked on Submit.");
		Thread.sleep(3000);

		if (driver.getPageSource().contains("Customer Registered Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("Testcase passed.");
		} else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase failed.");
		}
	}

}
