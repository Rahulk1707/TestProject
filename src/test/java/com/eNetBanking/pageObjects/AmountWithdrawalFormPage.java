package com.eNetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmountWithdrawalFormPage {

	WebDriver ldriver;

	public AmountWithdrawalFormPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Withdrawal')]")
	@CacheLookup
	WebElement lnkWithdrawal;

	@FindBy(how = How.NAME, using = "accountno")
	@CacheLookup
	WebElement txtAccountNo;

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

	public void clickWithdrawal() {
		lnkWithdrawal.click();
	}

	public void clickReset() {
		btnReset.click();
	}

	public void accountNo(String accNo) {
		txtAccountNo.sendKeys(accNo);
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
