package AirlinePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SeatSelectionPage2 {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SeatSelectionPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize all elements
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Sample seat element – update based on actual page
   @FindBy (xpath="//div[contains(@class,'seatRow')]") WebElement seatRows;
   @FindBy (xpath="\".//div[contains(@class,'seatBlock') and not(contains(@class,'unavailable'))]") WebElement availableSeatWithinRow;
   @FindBy (css=".OverlayGreyBg") WebElement overlay;
   @FindBy (xpath="//span[normalize-space()='Skip to add-ons']") WebElement skipButton;
   @FindBy(xpath = "//span[text()='Seat']")   WebElement seatSelectionHeader;
   @FindBy(xpath = "AUH$MAA$2025-08-26 22:35$3L-141_5A")    WebElement availableSeat;

   @FindBy(xpath = "//button[text()='Continue']")    WebElement continueBtn;
    // Method to select seat
   public void selectAvailableSeat() {
	    try {
	    	 wait.until(ExpectedConditions.visibilityOf(seatRows));


	        List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'seatRow')]"));
	        boolean seatSelected = false;

	        for (WebElement row : rows) {
	            List<WebElement> seats = driver.findElements(By.xpath("//body/div[@id='root']/div/div[@class='reviewTravellerAddons']/div[@class='flightBody']/div[@class='flightsContainer footerSpace']/div[@class='makeFlex spaceBetween']/div[@class='pageLeftConainer']/form[@id='mainSection_1']/div/div[@class='makeFlex column gap20']/div[@id='SEATS_N_MEALS']/div[@id='SEATS_N_MEALS']/div[@class='componentContainer']/div[@class='ancillaryContainer']/div/div/div[@class='ancillaryScrollWrap singleLengthWrap']/div[@id='MAA$BOM$2025-07-10 11:45$AI-574']/div/div[@class='flightWrap']/div[@class='flightSeatMatrix']/div/div[1]"));
	            if (!seats.isEmpty()) {
	                WebElement seat = seats.get(0);
	                System.out.println(seat);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", seat);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", availableSeat);
	                System.out.println("Seat selected: " + seat.getAttribute("id"));
	                seatSelected = true;
	                break;
	            }
	        }

	        if (!seatSelected) {
	            System.out.println("No available seat found. Skipping selection.");
	            skipSeatSelection();
	        }

	    } catch (Exception e) {
	        System.out.println("Seat selection failed: " + e.getMessage());
	        skipSeatSelection();
	    }
   }
	    public void skipSeatSelection() {
	        try {
	            wait.until(ExpectedConditions.invisibilityOf(overlay));
	            WebElement skip = wait.until(ExpectedConditions.elementToBeClickable(skipButton));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", skip);
	            System.out.println("Skipped seat selection.");
	        } catch (Exception e) {
	            System.out.println("Skip to add-ons button not found or clickable: " + e.getMessage());
	        }
	    }
	}
   