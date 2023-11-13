package com.eNetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.eNetBanking.utilities.ReadConfig;

public class BaseClass {
    
	ReadConfig readconfig = new ReadConfig();
	
	public String baseUrl = readconfig.getApplicationUrl();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		
		logger = Logger.getLogger("BaseClass");
		PropertyConfigurator.configure("src/test/java/log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		logger.info("Url Opened Successfully.");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}
	
	public String randomEmail() {
		String generatedstring = RandomStringUtils.randomAlphabetic(6);
		return(generatedstring);
	}
	
	public String randomPhoneNo() {
		String generatednum = RandomStringUtils.randomNumeric(10);
		return(generatednum);
	}
	
	public String randomPassword() {
		String generatedpwd = RandomStringUtils.randomAlphanumeric(8);
		return(generatedpwd);
	}

}
