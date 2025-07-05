package AirlinePackage;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirlineLoginPage {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//input[@placeholder='Enter email or mobile number']")	WebElement enterMobile;
	@FindBy(xpath="//button[@type='button']")	WebElement btn_continue;
	@FindBy(xpath="//button[@type='submit']")	WebElement verify;
	
	
		
	//step 2
	public void enterMobile()
	{
		enterMobile.sendKeys("9940271110");	
		//btn_continue.isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
		
	}
	
	public void Login() throws InterruptedException 
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(verify)).click();
		
	}
	
	public AirlineLoginPage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
