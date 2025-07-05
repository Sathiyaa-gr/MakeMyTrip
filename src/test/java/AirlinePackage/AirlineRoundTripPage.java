package AirlinePackage;
import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AirlineRoundTripPage {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//li[@data-cy='roundTrip']//span")	WebElement roundTrip;
		
	@FindBy(xpath="//input[@id='fromCity']")	WebElement sourceCity;
	@FindBy(xpath="//label[@for='toCity']")	WebElement destinationCity;
	@FindBy(xpath="//input[@placeholder='From']")	WebElement sourceInput;
	@FindBy(xpath="//input[@placeholder='To']")	WebElement destinationInput;
	
	@FindBy(xpath="//input[@id='departure']")	WebElement depature;
	
	@FindBy(xpath="(//div[@class='DayPicker-Caption']/div)[1]")	WebElement Month;
	@FindBy(xpath="//span[@aria-label='Next Month']")	WebElement nextMonth;
	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")	WebElement prevMonth;
	@FindBy(xpath="(//span[normalize-space()='Select return Date'])[1]")	WebElement selectreturn;
	
	@FindBy(xpath="//body") WebElement msg;
	
	
	@FindBy(xpath="//a[normalize-space()='Search']") WebElement search;
	
	
		
	//step 2
		
	public void sourceCity(String src) throws InterruptedException
	{
		sourceCity.click();
		//Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(sourceInput)).click();;
		//Thread.sleep(1000);
		sourceInput.sendKeys(src);
		Thread.sleep(2000);
		sourceInput.sendKeys(Keys.ARROW_DOWN);
        sourceInput.sendKeys(Keys.ENTER);
        Reporter.log("Source city: "+src);	
		
		
	}
	public void destinationCity(String dest) throws InterruptedException
	{
		destinationCity.click();
		wait.until(ExpectedConditions.visibilityOf(destinationInput));
		destinationInput.sendKeys(dest);
		Thread.sleep(2000);
		destinationInput.sendKeys(Keys.ARROW_DOWN);
		destinationInput.sendKeys(Keys.ENTER);
		 Reporter.log("Destination city: "+dest);	
	}
	
	
	
	public void roundTrip()
	{
		//Assert.assertEquals(roundTrip.isSelected(), true);
		wait.until(ExpectedConditions.visibilityOf(roundTrip));
		roundTrip.click();	
		Reporter.log("Round trip is selected");
	}
	 
	
	public AirlineRoundTripPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
	public void selectTravelDates(String targetmonthYear,String date1,String date2) {
		System.out.println("Select date on "+targetmonthYear);
		
		while (true) {
		    String currentMonth = Month.getText();
		    System.out.println("Current month is "+currentMonth);
		    if (!currentMonth.contains(" ")) {
		        currentMonth = currentMonth.replaceAll("(?<=\\D)(?=\\d)", " "); // "July2025" -> "July 2025"
		       
		    }
		    if (currentMonth.equalsIgnoreCase(targetmonthYear)) {
		        break;
		    } else if (isMonthBefore(currentMonth, targetmonthYear)) {
		    	nextMonth.click();
		    } else {
		    	prevMonth.click();
		    }
		}
		 List <WebElement> alldates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
	        for(WebElement dt:alldates)
	        {
	        	if(dt.getText().trim().equals(date1)) {
	        		dt.click();
	        		break;
	        	}
	        }

	        List <WebElement> alldates2=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
	        for(WebElement dt:alldates)
	        {
	        	if(dt.getText().trim().equals(date2)) {
	        		dt.click();
	        		break;
	        	}
	        }

	}
	public boolean isMonthBefore(String currentMonth, String monthYear) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
	    YearMonth current = YearMonth.parse(currentMonth, formatter);
	    YearMonth target = YearMonth.parse(monthYear, formatter);
	    System.out.println(current);
	    System.out.println(target);
	    return current.isBefore(target);
	}
}
