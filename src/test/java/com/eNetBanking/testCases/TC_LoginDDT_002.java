package com.eNetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.LoginPage;
import com.eNetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username Entered");
		lp.setPassword(pwd);
		logger.info("Password Entered");
		lp.clickSubmit();
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login successful");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert().accept();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/eNetBanking/testData/LoginData.xlsx";

		int rowcount = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rowcount][colcount];

		for (int i = 1; i <= rowcount; i++) {

			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}

		}

		return logindata;
	}

}
