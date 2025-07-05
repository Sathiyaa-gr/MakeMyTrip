package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineMutlicityPage;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineRoundTripPage;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC7_MutliCityPage extends BaseClass{
		

	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC7MutliCityPage() throws InterruptedException {
    	AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
        
        AirlineMutlicityPage multi=new AirlineMutlicityPage(driver);
        multi.mutliCity();
        multi.sourceDestCity("Chennai", "Dubai");
                    
        AirelineDatepicker dt=new AirelineDatepicker(driver);
        dt.selectTravelDate("20","August 2025");  
        
       
       multi.sourceDestCity2("Dubai","Chennai");
       dt.selectTravelDate("22","August 2025");
       home.Search();
        
    }
    

   
	
}