package AirlinePackage;
import java.time.Duration;
import java.util.List;

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

public class AirlineLogout {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
		
	@FindBy(xpath="//li[@data-cy='account']")	WebElement hoverlogin;
	@FindBy(xpath="/div[@class='makeFlex column userNameText latoBold']/p")	WebElement hoverlogout;
	@FindBy(xpath="//div[@id='container']")	WebElement signwithgoogle;
	@FindBy(xpath="//input[@id='identifierId']")	WebElement enterEmail;
	@FindBy(xpath="//p[.='My Profile']")	WebElement profile;
	@FindBy(xpath="//li[normalize-space()='Logout']")	WebElement logout;	
	@FindBy(xpath="//button[normalize-space()='Logout']")	WebElement btnlogout;
	
		
	//step 2
	public void hoverLoginorCreate()
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(hoverlogin).perform();
	}
	public void hoverLogout()
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(hoverlogout).perform();
		
	}
	public void logout() throws InterruptedException
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal, .overlay")));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 800);");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", logout);

		
		wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
		wait.until(ExpectedConditions.elementToBeClickable(btnlogout)).click();
	}
	public void Logingmail()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signwithgoogle)).click();
		//driver.switchTo().frame(0);
		wait.until(ExpectedConditions.elementToBeClickable(enterEmail)).click();
		enterEmail.sendKeys("sathiya.nila@gmail.com");
	}
	
	
	
	
	
	public AirlineLogout(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
