package com.eNetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eNetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

    @Test
	public void LoginTest() throws IOException {
        driver.get(baseUrl);
        logger.info("Url Opened Successfully.");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Username Entered");
        lp.setPassword(password);
        logger.info("Password Entered");
        lp.clickSubmit();
        logger.info("Logged into Application");
        
        if(driver.getPageSource().contains("Welcome To Manager's Page of Guru99 Bank")) {
        	Assert.assertTrue(true);
        	logger.info("Testcase Passed");
        } else {
        	captureScreen(driver, "LoginTest");
        	Assert.assertTrue(false);
        	logger.info("Testcase Failed");
        }
        
	}

}
