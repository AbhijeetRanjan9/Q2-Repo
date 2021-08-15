package CBA.CBAAssessment;

import org.openqa.selenium.By;

public  class Locators {

	By dismiss = By.xpath("//a[text()='Dismiss']");
	By repaymentcalculator = By.linkText("Repayments calculator");
	By amount = By.id("amount");
	By term = By.id("term");
	By submit = By.id("submit");
	By loanrepayments = By.xpath("(//span[text()='Total loan repayments']/following-sibling::span)[1]/following-sibling::span");
	By interestcharged = By.xpath("(//span[text()='Total interest charged']/following-sibling::span)[1]/following-sibling::span");
}
