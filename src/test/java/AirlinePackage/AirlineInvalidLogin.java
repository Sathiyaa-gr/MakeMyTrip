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

public class AirlineInvalidLogin {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//input[@placeholder='Enter email or mobile number']")	WebElement enterMobile;
	
	@FindBy(xpath="//span[normalize-space()='Continue']")	WebElement btn_continue;
	
	
	@FindBy(xpath="//p[@class='font12 redText appendTop5 makeFlex serverError hrtlCenter']")	WebElement errormsg;
		
	//step 2
	public void enterMobile(String mobile)
	{
		enterMobile.sendKeys(mobile);	
		
	}
	public void continuebtn()
	{
		wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
		Assert.assertEquals(errormsg.getText(), "Invalid phone number");
			
	}
	
	public AirlineInvalidLogin(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
