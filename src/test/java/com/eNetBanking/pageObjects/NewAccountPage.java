package com.eNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {

	WebDriver ldriver;

	public NewAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Account')]")
	@CacheLookup
	WebElement lnkNewAccount;
	
	@FindBy(how = How.NAME, using = "reset")
	@CacheLookup
	WebElement btnreset;

	@FindBy(how = How.NAME, using = "cusid")
	@CacheLookup
	WebElement txtCustomerid;

	@FindBy(how = How.ID_OR_NAME, using = "selaccount")
	@CacheLookup
	WebElement ddAcccounttype;

	@FindBy(how = How.NAME, using = "inideposit")
	@CacheLookup
	WebElement txtInitialdeposit;

	@FindBy(how = How.NAME, using = "button2")
	@CacheLookup
	WebElement btnsubmit;
	
	public void clickNewAccount() {
		lnkNewAccount.click();
	}
	
	public void clickReset() {
		btnreset.click();
	}
	
	public void custId(String cusId) {
		txtCustomerid.sendKeys(cusId);
	}
	
	public void selectAccountType(String accountType) {
		ddAcccounttype.click();
	}
	
	public void initialDeposit(String initialDep) {
		txtInitialdeposit.sendKeys(initialDep);
	}
	
	public void clickSubmit() {
		btnsubmit.click();
	}

}
