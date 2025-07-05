package AirlinePackage;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AirlineValidateFlightInfo {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="")	WebElement Oneway;
		
	@FindBy(xpath="(//span[text()='View Flight Details'])[1]")	WebElement viewFlight;
	@FindBy(xpath="(//a[@id='flightDetailsTab-0-tab-1'])[1]")	WebElement flightDetails;
	@FindBy(xpath="(//a[@id='flightDetailsTab-0-tab-2'])[1]")	WebElement FareSummary;
	@FindBy(xpath="(//a[@id='flightDetailsTab-0-tab-3'])[1]")	WebElement cancellation;
	
		
	//step 2
	public void flightdetails()
	{
		wait.until(ExpectedConditions.visibilityOf(viewFlight));
		viewFlight.click();
		wait.until(ExpectedConditions.visibilityOf(flightDetails));
		flightDetails.click();
		Assert.assertTrue(flightDetails.isDisplayed(), "flight details not displayed.");
		Reporter.log("flightDetails");
		
	}
	public void FareSummary()
	{
		wait.until(ExpectedConditions.visibilityOf(FareSummary));
		FareSummary.click();
		Assert.assertTrue(FareSummary.isDisplayed(), "Fare summary not displayed.");
		Reporter.log("FareSummary");
	}
	public void cancellation()
	{
		wait.until(ExpectedConditions.visibilityOf(cancellation));
		cancellation.click();
		Assert.assertTrue(cancellation.isDisplayed(), "cancellation not displayed.");
		Reporter.log("cancellation");
	}
	
	public AirlineValidateFlightInfo(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
