package AirlinePackage;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AirlineBookFlight {

	WebDriver driver;
	WebDriverWait wait;
	//step 1
		
	@FindBy(xpath="(//div[@class='textRight flexOne']/following-sibling::button)[1]")	WebElement Booknow;
	@FindBy(xpath="(//button[@class='lato-black button buttonPrimary buttonBig fontSize14'])[1]")	WebElement booknow2;
	@FindBy(xpath="//li[normalize-space()='Premium Economy']")	WebElement premium;
	@FindBy(xpath="//li[normalize-space()='First Class']")	WebElement first;
	
	@FindBy(xpath="//button[normalize-space()='APPLY']")	WebElement apply;
	
	
		
	//step 2
	public void Bookflight()
	{
		wait.until(ExpectedConditions.visibilityOf(Booknow)).click();
		 try {
		        if (booknow2.isDisplayed()) {
		            wait.until(ExpectedConditions.elementToBeClickable(booknow2)).click();
		        }
		    } catch (NoSuchElementException | TimeoutException e) {
		        
		    }
	
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
	
	public AirlineBookFlight(WebDriver driver)
	{
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		
	}
}
