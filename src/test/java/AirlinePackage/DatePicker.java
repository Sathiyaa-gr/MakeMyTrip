package AirlinePackage;

import java.time.Duration;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePicker {
WebDriver driver;
WebDriverWait wait;


@FindBy(xpath="//li[@data-cy='roundTrip']//span")	WebElement roundTrip;

@FindBy(xpath="//input[@id='fromCity']")	WebElement sourceCity;
@FindBy(xpath="//label[@for='toCity']")	WebElement destinationCity;
@FindBy(xpath="//input[@placeholder='From']")	WebElement sourceInput;
@FindBy(xpath="//input[@placeholder='To']")	WebElement destinationInput;

@FindBy(xpath="(//span[normalize-space()='Select return Date'])[1]")	WebElement selectreturn;


@FindBy(xpath="//input[@id='departure']")	WebElement depature;

@FindBy(xpath="(//div[@class='DayPicker-Caption']/div)[1]")	WebElement Month;

@FindBy(xpath="(//div/div[@class='DayPicker-Caption']/div)[1]/span")	WebElement Year;
@FindBy(xpath="//span[@aria-label='Next Month']")	WebElement nextMonth;
@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")	WebElement prevMonth;
	
	 public void selectFutureDate(WebDriver driver,String year,String month,String date, String date2)
	{
		while(true)
		{
			String currentMon = Month.getText();//actutal month
			String currentYear=Year.getText();//actual year
					
			if(currentMon.equals(month) && currentYear.equals(year))
				{
					System.out.println(currentMon+" "+currentYear);
					break;
				}
					
			if (ismonthYearBefore(currentMon, month)) {
	               wait.until(ExpectedConditions.elementToBeClickable(prevMonth)).click();
	           } else {
	               wait.until(ExpectedConditions.elementToBeClickable(nextMonth)).click();
	           }
	        }
	
		
		List<WebElement> allDates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
		
		for(WebElement dt:allDates)
			{
				if(dt.getText().equals(date))
				{
					dt.click();
					break;
				}
			}
		List<WebElement> allDates2=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
		
		for(WebElement dt:allDates)
			{
				if(dt.getText().equals(date2))
				{
					dt.click();
					break;
				}
			}		
	}
	
	 private boolean ismonthYearBefore(String currentMon, String Year) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

		    
		    currentMon = addSpace(currentMon);
		    String monthYear = addSpace(Year);

		    YearMonth current = YearMonth.parse(currentMon, formatter);
		    YearMonth target = YearMonth.parse(monthYear, formatter);

		    return target.isBefore(current);
	}
	 private String addSpace(String currentMon) {
		 return currentMon.replaceAll("([a-zA-Z]+)(\\d{4})", "$1 $2");
	}

	public DatePicker(WebDriver driver) {
			this.driver=driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			PageFactory.initElements(driver, this);
	 }
}
