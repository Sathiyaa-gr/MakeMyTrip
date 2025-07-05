package AirlinePackage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AirlineHomePage {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	
	@FindBy(xpath="//a[.='Continue with MakeMyTrip India 🇮🇳']") WebElement indiabtn;
	@FindBy(xpath="//input[@placeholder='Enter email or mobile number']")	WebElement enterMobile;
	@FindBy(xpath="//div[@class='makeFlex column userNameText latoBold']")	WebElement hover;
	@FindBy(xpath="//p[.='My Profile']")	WebElement profile;
	@FindBy(xpath="//div[@id='cta_section']/child::button")	WebElement continuebtn;
	@FindBy(xpath="//p[@data-cy='LoginHeaderText']")	WebElement Login;

	@FindBy(xpath="//span[text()='Verify & Create Account']")	WebElement verifyLogin;
	
	@FindBy(xpath="//span[@class='commonModal__close']")	WebElement Close;
	@FindBy(xpath="//a[normalize-space()='Search']") WebElement search;
	@FindBy(xpath="//p[@class='appendBottom3 truncate font11 lineHeight16 whiteText']")	WebElement verifylogin;
	public void enterMobile()
	{
		enterMobile.sendKeys("9940271110");	
		//btn_continue.isDisplayed();
		wait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();
		
	}
	public void close()
	{
		wait.until(ExpectedConditions.elementToBeClickable(Close)).click();
		
	}
	public void clickcontinue() throws InterruptedException
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continuebtn);
		
	}
	
	public void clickLogin() throws InterruptedException 
	{
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(verifyLogin)).click();	
		
	}
	public void Login() throws InterruptedException 
	{
		wait.until(ExpectedConditions.elementToBeClickable(Login)).click();
	}
	public void Search()
	{
		wait.until(ExpectedConditions.visibilityOf(search));
		search.click();
	}
	
	public void verifylogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(verifylogin)).click();
		System.out.println("Successfully logged in "+verifylogin.getText());
		Reporter.log("Successfully logged in "+verifylogin.getText());
		
	}
	
	public AirlineHomePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
}
