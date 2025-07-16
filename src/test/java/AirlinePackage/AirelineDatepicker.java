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

public class AirelineDatepicker {
    public	WebDriver driver;
    WebDriverWait wait;
	@FindBy(xpath="//input[@id='departure']")	WebElement depature;
	
	@FindBy(xpath="(//div[@class='DayPicker-Caption']/div)[1]")	WebElement Month;
	
	@FindBy(xpath="//div[contains(@class,'DayPicker-Months')]//span[1]")	WebElement year;
	@FindBy(xpath="//span[@aria-label='Next Month']/parent::div")	WebElement nextMonth;
	@FindBy(xpath="//span[@aria-label='Previous Month']/parent::div")	WebElement prevMonth;
	
	

	
	public void selectTravelDate(String day, String monthYear) {
		
        while (true) {
           if (Month.getText().equalsIgnoreCase(monthYear)) {
                break;
            }
           wait.until(ExpectedConditions.elementToBeClickable(nextMonth)).click();
                  
        }
        List <WebElement> alldates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
        for(WebElement dt:alldates)
        {
        	if(dt.getText().trim().equals(day)) {
        		dt.click();
        		break;
        	}
        }

	}
	
	public void selectTravelDates(String targetmonthYear,String date1,String date2) {
		System.out.println("Select date on "+targetmonthYear);
		
		while (true) {
		    String currentMonth = Month.getText();
		    System.out.println("Current month is "+currentMonth);
		    if (!currentMonth.contains(" ")) {
		        currentMonth = currentMonth.replaceAll("(?<=\\D)(?=\\d)", " "); // "July2025" -> "July 2025"
		       
		    }
		    if (currentMonth.equalsIgnoreCase(targetmonthYear)) {
		        break;
		    } else if (isMonthBefore(currentMonth, targetmonthYear)) {
		    	nextMonth.click();
		    } else {
		    	prevMonth.click();
		    }
		}
		 List <WebElement> alldates=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
	        for(WebElement dt:alldates)
	        {
	        	if(dt.getText().trim().equals(date1)) {
	        		dt.click();
	        		break;
	        	}
	        }

	        List <WebElement> alldates2=driver.findElements(By.xpath("//div[@class='DayPicker-Body']/div/div/div"));
	        for(WebElement dt:alldates)
	        {
	        	if(dt.getText().trim().equals(date2)) {
	        		dt.click();
	        		break;
	        	}
	        }

	}
	public boolean isMonthBefore(String currentMonth, String monthYear) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);
	    YearMonth current = YearMonth.parse(currentMonth, formatter);
	    YearMonth target = YearMonth.parse(monthYear, formatter);
	    System.out.println(current);
	    System.out.println(target);
	    return current.isBefore(target);
	}
	
	
	
	
	public AirelineDatepicker(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
}
