package AirlineTestPkge;


import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineBookFlight;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineMutliplePassanger;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineSeatSelection;
import AirlineUtil.IRetrylogic;


public class TC11_validateafterBooking extends BaseClass{
		


	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC11validateAfterBook() throws InterruptedException {
    	AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
                
        AirlineOnewayPage oneway=new AirlineOnewayPage(driver);
        oneway.OnewayTrip();
        oneway.sourceCity("Dubai");
        oneway.destinationCity("Chennai");
        
        AirelineDatepicker date=new AirelineDatepicker(driver);
        date.selectTravelDate("26","August 2025");  
        home.Search();
        
        AirlineBookFlight book=new AirlineBookFlight(driver);
        book.Bookflight();
        book.switchToNewWindow();
      //  Thread.sleep(1000);
      //  home.clickcontinue();
        
        AirlineMutliplePassanger pass=new AirlineMutliplePassanger(driver);
        
        pass.chk_adult();
        //pass.femalechk();
        pass.adultDetails("Sathiyaa", "Anbarsan");
        
        //pass.mobile_Email();
      
        
    }
    

   
	
}