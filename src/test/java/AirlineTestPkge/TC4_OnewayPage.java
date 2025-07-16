package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineLoginPage2;
import AirlinePackage.AirlineOnewayPage;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC4_OnewayPage extends BaseClass{
	
	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC4OnewayPage() throws InterruptedException {
		AirlineHomePage home = new AirlineHomePage(driver);
		home.close();
		    
       
    	AirlineOnewayPage oneway=new AirlineOnewayPage(driver);
        oneway.OnewayTrip();
        oneway.sourceCity("Dubai");
        oneway.destinationCity("Chennai");
        
        AirelineDatepicker date=new AirelineDatepicker(driver);
        date.selectTravelDate("26","August 2025");  
        home.Search();
        
    }
    

   
	
}