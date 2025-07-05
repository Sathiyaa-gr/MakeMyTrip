package AirlinePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatSelectionPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public SeatSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize all elements
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Sample seat element – update based on actual page
    @FindBy(xpath = "//span[text()='Seat']")
    WebElement seatSelectionHeader;

    @FindBy(xpath = "AUH$MAA$2025-08-26 22:35$3L-141_5A") // enabled seat
    WebElement availableSeat;

    @FindBy(xpath = "//button[text()='Continue']") // or use correct button locator
    WebElement continueBtn;

    // Method to select seat
    public void selectSeat() {
        wait.until(ExpectedConditions.visibilityOf(seatSelectionHeader));

        // Wait for available seats to load and click one
        wait.until(ExpectedConditions.elementToBeClickable(availableSeat)).click();

        // Proceed
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }
}