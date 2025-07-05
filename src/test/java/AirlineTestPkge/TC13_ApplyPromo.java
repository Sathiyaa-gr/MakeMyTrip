package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineBookFlight;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineMutliplePassanger;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlinePromoCodes;
import AirlinePackage.AirlineSeatSelection;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC13_ApplyPromo extends BaseClass{
		
	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC13ApplyPromo() throws InterruptedException {
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
        AirlinePromoCodes code=new AirlinePromoCodes(driver);
        code.promoCodes();
        
        
    }
    

   
	
}