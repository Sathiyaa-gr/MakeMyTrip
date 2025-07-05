package AirlinePackage;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirlineLoginPage2 {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="//input[@placeholder='Enter email or mobile number']")	WebElement enterMobile;
	
	@FindBy(xpath="//span[normalize-space()='Continue']")	WebElement btn_continue;
	
	
	@FindBy(xpath="//button[@data-cy='login']")	WebElement veifylogin;
	@FindBy(xpath="//div[@class='indexstyle__IconWrap-sc-1aj4s42-1 hTezXr']")	WebElement flights;

	@FindBy(xpath="//p[@data-cy='LoginHeaderText']")	WebElement Login;
	@FindBy(xpath="//p[@class='makeFlex hrtlCenter flagCountryCode']")	WebElement code;
	
	@FindBy(xpath="//input[@id='enterCountry']")	WebElement enterCountrycode;
	@FindBy(xpath="//div[@class='cntrycode__list']/child::div[2]")	WebElement indiacode;
	@FindBy(xpath="//div[@class='switchLoginFlow']")	WebElement loginviapwd;
	@FindBy(xpath="//input[@name='password']")	WebElement enterpwd;	
	//step 2
	public void enterMobile()
	{
		enterMobile.sendKeys("9940271110");	
		
	}
	public void enterCntryCode()
	{
		wait.until(ExpectedConditions.elementToBeClickable(code)).click();
		enterCountrycode.sendKeys("India");
		indiacode.click();
		wait.until(ExpectedConditions.elementToBeClickable(btn_continue)).click();
			
	}
	public void loginviapwd()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginviapwd)).click();
		enterpwd.sendKeys("Jashu@16");
		wait.until(ExpectedConditions.elementToBeClickable(veifylogin)).click();
			
	}
	public void clickLogin() throws InterruptedException 
	{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(veifylogin)).click();	
		
	}
	public void Login() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
		
	}
	
	public AirlineLoginPage2(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
}
