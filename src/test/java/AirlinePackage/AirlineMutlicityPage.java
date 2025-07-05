package AirlinePackage;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AirlineMutlicityPage {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//li[@data-cy='mulitiCityTrip']//span")	WebElement mutliCity;
		
	@FindBy(xpath="//label[@for='fromAnotherCity0']//span[.='From']")	WebElement sourceCity1;
	@FindBy(xpath="//label[@for='toAnotherCity0']//span[.='To']")	WebElement destination1;
	@FindBy(xpath="//label[@for='fromAnotherCity1']//span[.='From']")	WebElement sourceCity2;
	@FindBy(xpath="//label[@for='toAnotherCity1']//span[.='To']")	WebElement destination2;
	@FindBy(xpath="//input[@placeholder='From']")	WebElement srcinput;
	@FindBy(xpath="//input[@placeholder='To']")	WebElement destinput;
	@FindBy(xpath="//input[@id='anotherDeparture 0']")	WebElement depature;

	@FindBy(xpath="//input[@id='anotherDeparture 0']")	WebElement depature1;
	
	@FindBy(xpath="//div[contains(text(),'June 2025')]")	WebElement month;
	
	@FindBy(xpath="//span[@aria-label='Next Month']")	WebElement nextMonth;
	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")	WebElement previousMonth;
	
	@FindBy(xpath="//body") WebElement msg;
	
	
	

		
	//step 2
	public void mutliCity()
	{
		//wait.until(ExpectedConditions.elementToBeSelected(mutliCity));
		mutliCity.click();	
		Reporter.log("MutliCity Select");
	}
	
	public void sourceDestCity(String src, String dest) throws InterruptedException
	{
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modalLogin")));
		sourceCity1.click();
		wait.until(ExpectedConditions.elementToBeClickable(srcinput)).click();;
		//Thread.sleep(1000);
		srcinput.sendKeys(src);
		Thread.sleep(2000);
		srcinput.sendKeys(Keys.ARROW_DOWN);
		srcinput.sendKeys(Keys.ENTER);
		
		destination1.click();
		wait.until(ExpectedConditions.elementToBeClickable(destinput)).click();;
		//Thread.sleep(1000);
		destinput.sendKeys(dest);
		Thread.sleep(2000);
		destinput.sendKeys(Keys.ARROW_DOWN);
		destinput.sendKeys(Keys.ENTER);
		Reporter.log("First Source to "+"Destination city "+src+" to"+dest);

	}
	
	public void sourceDestCity2(String src, String dest) throws InterruptedException
	{
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("modalLogin")));
		sourceCity2.click();
		wait.until(ExpectedConditions.elementToBeClickable(srcinput)).click();;
		//Thread.sleep(1000);
		srcinput.sendKeys(src);
		Thread.sleep(2000);
		srcinput.sendKeys(Keys.ARROW_DOWN);
		srcinput.sendKeys(Keys.ENTER);
		
		destination2.click();
		wait.until(ExpectedConditions.elementToBeClickable(destinput)).click();;
		//Thread.sleep(1000);
		destinput.sendKeys(dest);
		Thread.sleep(2000);
		destinput.sendKeys(Keys.ARROW_DOWN);
		destinput.sendKeys(Keys.ENTER);
		Reporter.log("Second Source to "+"Destination city "+src+" to"+dest);
	}
	
	
	
	public AirlineMutlicityPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
