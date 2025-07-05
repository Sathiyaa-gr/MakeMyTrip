package AirlineTestPkge;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineRoundTripPage;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

//@Listeners(MyListener.class)
public class TC2_ValidLogin extends BaseClass{
	

	@Test//(retryAnalyzer=IRetrylogic.class)
    public void testAirlineRegistration() throws InterruptedException {
    	
    	AirlineHomePage regPage = new AirlineHomePage(driver);
    	AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
    
    	//AirlineRegisterPage login = new AirlineRegisterPage(driver); not workijng
        AirlineRoundTripPage round=new AirlineRoundTripPage(driver);
        round.roundTrip();
        round.sourceCity("Chennai");
        round.destinationCity("Dubai");
      //  WebElement date = driver.findElement(By.xpath("//div[@aria-label='Mon Jul 14 2025']//div[@class='dateInnerCell']"));
        //System.out.println(date.getText());
        AirelineDatepicker date=new AirelineDatepicker(driver);
        date.selectTravelDate("26","August 2025");  
        home.Search();
        }
    

   
	
}