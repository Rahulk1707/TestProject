package com.eNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {

	WebDriver ldriver;

	public FundTransferPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Fund Transfer')]")
	@CacheLookup
	WebElement lnkFundTransfer;

	@FindBy(how = How.NAME, using = "payersaccount")
	@CacheLookup
	WebElement txtPayersaccountno;

	@FindBy(how = How.NAME, using = "payeeaccount")
	@CacheLookup
	WebElement txtPayeesaccountno;

	@FindBy(how = How.NAME, using = "ammount")
	@CacheLookup
	WebElement txtAmount;

	@FindBy(how = How.NAME, using = "desc")
	@CacheLookup
	WebElement txtDescription;

	@FindBy(how = How.NAME, using = "AccSubmit")
	@CacheLookup
	WebElement btnSubmit;

	@FindBy(how = How.NAME, using = "res")
	@CacheLookup
	WebElement btnReset;

	public void clickFundTransfer() {
		lnkFundTransfer.click();
	}

	public void clickReset() {
		btnReset.click();
	}

	public void payersAccNo(String accNo1) {
		txtPayersaccountno.sendKeys(accNo1);
	}

	public void payeesAccNo(String accNo2) {
		txtPayeesaccountno.sendKeys(accNo2);
	}

	public void enterAmount(String amount) {
		txtAmount.sendKeys(amount);
	}

	public void description(String desc) {
		txtDescription.sendKeys(desc);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

}
