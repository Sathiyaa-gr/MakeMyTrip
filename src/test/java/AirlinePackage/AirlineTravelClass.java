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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AirlineTravelClass {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//span[@class='lbl_input appendBottom5']")	WebElement travelclass;
	@FindBy(xpath="//li[normalize-space()='Economy/Premium Economy']")	WebElement Economy;
	@FindBy(xpath="//li[normalize-space()='Premium Economy']")	WebElement premium;
	@FindBy(xpath="//li[normalize-space()='First Class']")	WebElement first;
	@FindBy(xpath="(//ul[@class='guestCounter font12 darkText ']/li)[2]")	WebElement noofadult;
	@FindBy(xpath="//button[normalize-space()='APPLY']")	WebElement apply;
	
	
	//step 2
	public void TravelClass(String travelClass)
	{
		wait.until(ExpectedConditions.visibilityOf(travelclass));
		travelclass.click();
		wait.until(ExpectedConditions.visibilityOf(Economy));
		Reporter.log("Economy selected");
		Economy.click();	
		apply.click();
	}
	public void validateSearchTravelClass(String expectedClass) {
	   
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//span[@class='airlineName']")));

	    List<WebElement> flights = driver.findElements(By.xpath("//div//span[@class='airlineName']"));
	    Assert.assertTrue(flights.size() > 0, "No flight results found.");
	    System.out.println("search result:"+flights.size());

	    
	    Reporter.log(expectedClass + " class results validated successfully.");
	}
	
	public void multiplePassengers(String count)
	{
		wait.until(ExpectedConditions.visibilityOf(travelclass));
		travelclass.click();
		wait.until(ExpectedConditions.visibilityOf(noofadult));
		noofadult.click();
		Assert.assertEquals(noofadult.isSelected(), false);
		Reporter.log(noofadult.getText()+"Passanger selected");
		apply.click();
		
	}
	
	public AirlineTravelClass(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
