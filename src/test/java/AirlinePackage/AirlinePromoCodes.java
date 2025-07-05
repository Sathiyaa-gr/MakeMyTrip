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

public class AirlinePromoCodes {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
	@FindBy(xpath="")	WebElement Oneway;
		
	@FindBy(xpath="//div[@class='promoHeader']")	WebElement prmoHeader;
	@FindBy(xpath="//input[@placeholder='Enter promo code here']")	WebElement enterPromo;
	@FindBy(xpath="//span[@class='boldFont appendRight10']")	WebElement apply;
	
	
	
	//step 2
	public void promoCodes()
	{
		wait.until(ExpectedConditions.visibilityOf(prmoHeader));
		prmoHeader.isDisplayed();
		Assert.assertEquals(prmoHeader.isDisplayed(),true);
		wait.until(ExpectedConditions.visibilityOf(enterPromo));
		enterPromo.sendKeys("Copu124");
		apply.click();
		Reporter.log("Verified promo codes");
		
	}
	
	public AirlinePromoCodes(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
}
