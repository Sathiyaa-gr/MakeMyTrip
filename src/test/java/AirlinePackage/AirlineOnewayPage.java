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

public class AirlineOnewayPage {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="(//span[@class='tabsCircle appendRight5'])[1]")	WebElement Oneway;
		
	@FindBy(xpath="//label[@for='fromCity']")	WebElement sourceCity;
	@FindBy(xpath="//label[@for='toCity']")	WebElement destinationCity;
	@FindBy(xpath="//input[@placeholder='From']")	WebElement sourceInput;
	@FindBy(xpath="//input[@placeholder='To']")	WebElement destinationInput;
	
	@FindBy(xpath="//input[@id='departure']")	WebElement depature;
	
	@FindBy(xpath="(//div[@class='DayPicker-Caption']/div)[1]")	WebElement currentmonth;
	
	@FindBy(xpath="//div[contains(@class,'DayPicker-Months')]//span[1]")	WebElement year;
	@FindBy(xpath="//span[@aria-label='Next Month']")	WebElement nextMonth;
	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")	WebElement previousMonth;
	
		
	//step 2
	public void OnewayTrip()
	{
		Assert.assertEquals(Oneway.isSelected(), false);
		wait.until(ExpectedConditions.visibilityOf(Oneway));
		if (!Oneway.isSelected()) {
			Oneway.click();
		}Reporter.log("One way selecte");
	}
	
	public void sourceCity(String src) throws InterruptedException
	{
		sourceCity.click();
		wait.until(ExpectedConditions.elementToBeClickable(sourceInput)).click();;
		sourceInput.sendKeys(src);
		//Thread.sleep(1000);
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
	
	public void selectTravelDate(String day, String monthYear) {
		
        while (true) {
           if (currentmonth.getText().equalsIgnoreCase(monthYear)) {
                break;
            }
           wait.until(ExpectedConditions.elementToBeClickable(nextMonth)).click();
           
            
        }
        List <WebElement> alldates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
        for(WebElement dt:alldates)
        {
        	if(dt.getText().trim().equals(day)) {
        		dt.click();
        		break;
        	}
        }

          
	}
	
	
		
	public AirlineOnewayPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
