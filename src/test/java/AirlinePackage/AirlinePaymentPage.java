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

public class AirlinePaymentPage {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//input[@id='cardNumber']")	WebElement cardNumber;
	@FindBy(xpath="//input[@id='nameOnCard']")	WebElement NameonCard;
	@FindBy(xpath="//select[@name='expiryMonth']")	WebElement expiryMonth;
	@FindBy(xpath="//select[@name='Year']")	WebElement expiryYear;
	@FindBy(xpath="//input[@id='cardCvv']")	WebElement cvv;
	@FindBy(xpath="//span[normalize-space()='pay now']")	WebElement pay;
	
	
	//step 2
	public void cardDetails()
	{
		wait.until(ExpectedConditions.visibilityOf(cardNumber));
		cardNumber.sendKeys("4547555511120021");
		wait.until(ExpectedConditions.visibilityOf(NameonCard));
		Assert.assertTrue(NameonCard.isDisplayed());
		NameonCard.sendKeys("Sathiyaa");
		Reporter.log("Entered Card details");
		
	}
	
	public void expiryMonth()
	{
		Select sel=new Select(expiryMonth);
		sel.selectByIndex(3);
		Select yr=new Select(expiryYear);
		yr.selectByIndex(3);
		wait.until(ExpectedConditions.visibilityOf(cvv));
		cvv.sendKeys("122");
	}
	
	
	public AirlinePaymentPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
