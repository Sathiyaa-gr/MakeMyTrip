package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineBookFlight;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineMutliplePassanger;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineSeatSelection;
import AirlinePackage.SeatSelectionPage;
import AirlinePackage.SeatSelectionPage2;
import AirlinePackage.SeatSelectionPage3;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC8_SeatSelection_test2 extends BaseClass{
		

	@Test//(retryAnalyzer=IRetrylogic.class)
    
    
    public void TC8SeatSelection() throws InterruptedException {
    	AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
                
        AirlineOnewayPage oneway=new AirlineOnewayPage(driver);
        oneway.OnewayTrip();
        oneway.sourceCity("Chennai");
        oneway.destinationCity("Mumbai");
        
        AirelineDatepicker date=new AirelineDatepicker(driver);
        date.selectTravelDate("26","August 2025");  
        home.Search();
        
        AirlineBookFlight book=new AirlineBookFlight(driver);
        book.Bookflight();
       // book.Book2();
        book.switchToNewWindow();
      Thread.sleep(1000);
      //  home.clickcontinue();
        
        AirlineMutliplePassanger pass=new AirlineMutliplePassanger(driver);
        
        pass.chk_adult();
        
        pass.adultDetails("Sathiyaa", "Anbarsan");
        pass.mobile_Email();
        
       home.clickcontinue();
       pass.clickconfirm();
       
       AirlineSeatSelection seat=new AirlineSeatSelection(driver);
       seat.selectAvailableSeat();
       home.clickcontinue();
       home.clickcontinue();
       seat.Countinue_any();
       seat.proceedToPay();
       
    }
    

   
	
}