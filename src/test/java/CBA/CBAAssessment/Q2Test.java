package CBA.CBAAssessment;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Q2Test extends Locators {

	Locators locator = new Locators();
	@BeforeTest
	public void beforetest()
	{
		//Browser path is set up here
		System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\CBAAssessment\\driver\\chromedriver_win32\\chromedriver.exe");

	}
	@Test(dataProvider ="test-data")
	public void mainFlow(String enteramount , String enteryears , String expectedtotalloanrepayments, String expectedtotalinterestcharged) {

		WebDriver driver = new ChromeDriver(); 

		driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS); // driver to wait for 6 seconds before throwing any error for element not found cases
		driver.get("https://www.commbank.com.au");	
		driver.manage().window().maximize();
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(dismiss));//to highlight the element
		driver.findElement(dismiss).click();
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(repaymentcalculator));//to highlight the element
		driver.findElement(repaymentcalculator).click();
		driver.findElement(amount).clear();
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(amount));//to highlight the element
		driver.findElement(amount).sendKeys(enteramount);
		driver.findElement(term).clear();
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(term));//to highlight the element
		driver.findElement(term).sendKeys(enteryears);
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(submit));//to highlight the element
		driver.findElement(submit).click();
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(loanrepayments));//to highlight the element
		String actualtotalloanrepayments = driver.findElement(loanrepayments).getText();
		System.out.println(actualtotalloanrepayments);
		Assert.assertEquals(actualtotalloanrepayments, expectedtotalloanrepayments);
		Q2ElementHighlighter.highLighterMethod(driver, driver.findElement(interestcharged));//to highlight the element
		String actualtotalinterestcharged = driver.findElement(interestcharged).getText();
		System.out.println(actualtotalinterestcharged);
		Assert.assertEquals(actualtotalinterestcharged, expectedtotalinterestcharged);	
		driver.close();
		driver.quit();
	}

	/*Below Method is used to pass multiple sets of data*/
	@DataProvider(name = "test-data")
	public String[][] getData() {		
		return new String[][] {{"300000","30","$437,476","$137,476"},{"400000","20","$517,640","$117,640"}};
	}
}
