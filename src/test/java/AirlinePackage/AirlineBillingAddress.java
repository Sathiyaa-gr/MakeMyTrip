package AirlinePackage;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AirlineBillingAddress {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//select[@name='billingCountry']")	WebElement country;
	@FindBy(xpath="//input[@name='billingState']")	WebElement state;
	@FindBy(xpath="//input[@name='billingAddress']")	WebElement addr;
	@FindBy(xpath="//input[@name='billingCity']")	WebElement city;
	@FindBy(xpath="//input[@name='billingPinCode']")	WebElement pincode;
	@FindBy(xpath="//button[@class='prime__btn   paynow__btn font16']/span")	WebElement pay;
	
	
	//step 2
	public void billingAddress()
	{
		Select sel=new Select(country);
		sel.selectByValue("CA");
		wait.until(ExpectedConditions.visibilityOf(state));
		state.sendKeys("Ontario");
		wait.until(ExpectedConditions.visibilityOf(addr));
		addr.sendKeys("230 Queen st");
		wait.until(ExpectedConditions.visibilityOf(city));
		city.sendKeys("Toronto");
		wait.until(ExpectedConditions.visibilityOf(pincode));
		pincode.sendKeys("M4B 1C3");
		Reporter.log("Billing Address");
	}
	
	public void pay()
	{
		wait.until(ExpectedConditions.visibilityOf(pay));
		Assert.assertTrue(pay.isDisplayed());
		pay.click();
	}
	
	
	public AirlineBillingAddress(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
