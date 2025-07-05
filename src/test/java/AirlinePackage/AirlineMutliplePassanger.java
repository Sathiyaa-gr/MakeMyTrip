package AirlinePackage;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AirlineMutliplePassanger {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
		
	@FindBy(xpath="//button[@class='addTravellerBtn']")	WebElement addnewAdult;
	@FindBy(xpath="//input[@placeholder='Mobile No']")	WebElement mobileNo;
	@FindBy(xpath="//input[@placeholder='Email']")	WebElement Email;
	@FindBy(xpath="//label[@class='checkboxContainer ']//input")	WebElement chk_adult;
	
	@FindBy(xpath="//input[@placeholder='First & Middle Name']")	WebElement fname;
	@FindBy(xpath="//input[@placeholder='Last Name']")	WebElement lastname;
	@FindBy(xpath="(//div[@class='makeFlex']/label)[2]")	WebElement female;
	@FindBy(xpath="//label//span[text()='MALE']")	WebElement male;
	@FindBy(xpath="(//div[@class='dropdown__input']/input)[1]")	WebElement countrycode;

	@FindBy(xpath="(//div[@class='dropdown__input']/input)[2]")	WebElement nationality;
	@FindBy(xpath="//div/h2[.='Traveller Details']")	WebElement traveller;
	@FindBy(xpath="//button[normalize-space()='CONFIRM']")	WebElement confirm;
		
	//step 2
	public void mobile_Email()
	{
		wait.until(ExpectedConditions.visibilityOf(mobileNo));
		mobileNo.sendKeys("4373661122");
		wait.until(ExpectedConditions.visibilityOf(Email));
		Email.clear();
		Email.sendKeys("sathiya@gmail.com");
		Email.sendKeys(Keys.TAB);
		Email.sendKeys(Keys.TAB);
		Email.sendKeys(Keys.ENTER);
	}
	public void adultDetails(String name,String lname)
	{
		wait.until(ExpectedConditions.visibilityOf(fname)).sendKeys(name);
	    wait.until(ExpectedConditions.visibilityOf(lastname)).sendKeys(lname);
	    wait.until(ExpectedConditions.visibilityOf(female)).click();
	    wait.until(ExpectedConditions.visibilityOf(countrycode));
	    countrycode.sendKeys("Canada"+Keys.ENTER);
	    wait.until(ExpectedConditions.visibilityOf(nationality));
	    nationality.sendKeys("India");
	    //nationality.sendKeys(Keys.ARROW_DOWN);
	    nationality.sendKeys(Keys.ENTER); 
	   
	    
	}
	public void femalechk()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", female);
		female.click();
	    
	}
	
	public void chk_adult() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(traveller));
		traveller.isDisplayed();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(addnewAdult)).click();
		Thread.sleep(1000);
	}
	
	public void traveller()
	{
		wait.until(ExpectedConditions.visibilityOf(traveller));
		traveller.isDisplayed();
	}
	public void clickconfirm()
	{
		wait.until(ExpectedConditions.visibilityOf(confirm));
		confirm.click();
		
	}
	
	
	public void switchToNewWindow() {
	    String parent = driver.getWindowHandle();
	    Set<String> handles = driver.getWindowHandles();
	    for (String handle : handles) {
	        if (!handle.equals(parent)) {
	            driver.switchTo().window(handle);
	            break;
	        }
	    }
	    
	    Reporter.log("switched to child window");
	}
	
	public AirlineMutliplePassanger(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
