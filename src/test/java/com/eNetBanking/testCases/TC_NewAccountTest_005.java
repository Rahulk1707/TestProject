package com.eNetBanking.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.LoginPage;
import com.eNetBanking.pageObjects.NewAccountPage;

public class TC_NewAccountTest_005 extends BaseClass {

	@Test
	public void newAccount() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered.");
		lp.setPassword(password);
		logger.info("Password entered.");
		lp.clickSubmit();
		logger.info("Login successful.");
		Thread.sleep(2000);

		NewAccountPage newAcc = new NewAccountPage(driver);
		newAcc.clickNewAccount();
		logger.info("Clicked on New Account option.");

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
		Thread.sleep(2000);

		newAcc.clickReset();
		logger.info("Clicked on reset.");
		Thread.sleep(2000);

		newAcc.custId("18415");
		logger.info("Entered Customer ID.");
		Thread.sleep(2000);

		newAcc.selectAccountType("Savings");
		logger.info("Account type selected.");
		Thread.sleep(2000);

		newAcc.initialDeposit("5000");
		logger.info("Initial deposit entered.");
		Thread.sleep(2000);

		newAcc.clickSubmit();
		logger.info("Clicked on Submit.");
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Account Generated Successfully!!!")) {
			Assert.assertTrue(true);
			logger.info("Testcase passed.");
		} else {
			captureScreen(driver, "editCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase failed.");
		}

	}

}
