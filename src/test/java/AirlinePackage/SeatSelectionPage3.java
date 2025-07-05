package AirlinePackage;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class SeatSelectionPage3 {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SeatSelectionPage3(WebDriver driver) {
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

      // Method to select seat
   public void selectAvailableSeat() {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(seatRows));

	        List<WebElement> rows =driver.findElements(By.xpath("//div[contains(@class,'seatRow')]"));
	        boolean seatSelected = false;

	        for (WebElement row : rows) {
	            List<WebElement> seats = row.findElements(
	                By.xpath(".//div[contains(@class,'seatBlock') and not(contains(@class,'seatSelected')) and not(contains(@class,'unavailable'))]")
	            );

	            if (!seats.isEmpty()) {
	                WebElement seat = seats.get(0);
	                
	                // Scroll and click
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", seat);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", seat);

	                // ✅ Wait for seat to be marked as selected
	                wait.until(ExpectedConditions.attributeContains(seat, "class", "seatSelected"));

	                System.out.println("Seat selected: " + seat.getDomAttribute("class"));
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
   private void skipSeatSelection() {
	 try {
         wait.until(ExpectedConditions.invisibilityOf(overlay));
        
         skipButton.click();
         System.out.println("Skipped seat selection.");
     } catch (Exception e) {
         System.out.println("Skip to add-ons button not found or clickable: " + e.getMessage());
     }
 }
}
   