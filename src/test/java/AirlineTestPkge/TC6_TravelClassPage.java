package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineLogout;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineTravelClass;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC6_TravelClassPage extends BaseClass{
		

	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC6TravelClassPage() throws InterruptedException {
        AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
        
        AirlineOnewayPage oneway=new AirlineOnewayPage(driver);
        oneway.OnewayTrip();
        oneway.sourceCity("Chennai");
        oneway.destinationCity("Mumbai");
        oneway.selectTravelDate("26","August 2025");  
        
        
        AirlineTravelClass travel=new AirlineTravelClass(driver);
        travel.TravelClass("Economy");
        home.Search();
        travel.validateSearchTravelClass("Economy");
        
        
    }
    

   
	
}