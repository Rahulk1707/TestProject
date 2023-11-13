package com.eNetBanking.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.AmountWithdrawalFormPage;
import com.eNetBanking.pageObjects.LoginPage;

public class TC_AmountWithdrawalTest_006 extends BaseClass {

	@Test
	public void amountWithdrawal() throws Exception {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered.");
		lp.setPassword(password);
		logger.info("Password entered.");
		lp.clickSubmit();
		logger.info("Login successful.");
		Thread.sleep(2000);

		AmountWithdrawalFormPage amf = new AmountWithdrawalFormPage(driver);
		amf.clickWithdrawal();
		logger.info("Withdrawal option clicked.");

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

		amf.clickReset();
		logger.info("Reset option clicked.");
		Thread.sleep(2000);

		amf.accountNo("126271");
		logger.info("Account No entered.");
		Thread.sleep(2000);

		amf.enterAmount("1000");
		logger.info("Amount entered.");
		Thread.sleep(2000);

		amf.description("Not req.");
		logger.info("Description provided.");
		Thread.sleep(2000);

		amf.clickSubmit();
		logger.info("Clicked on Submit.");
		Thread.sleep(2000);

		if (driver.getPageSource().contains("Transaction details of Withdrawal for Account 126271")) {
			Assert.assertTrue(true);
			logger.info("Testcase passed.");
		} else {
			captureScreen(driver, "editCustomer");
			Assert.assertTrue(false);
			logger.info("Testcase failed.");
		}
	}

}
