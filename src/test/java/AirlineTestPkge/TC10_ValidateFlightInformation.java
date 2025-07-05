package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineValidateFlightInfo;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC10_ValidateFlightInformation extends BaseClass{
		

	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC10ValidateFlightInformation() throws InterruptedException {
    	AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
        
        AirlineOnewayPage oneway=new AirlineOnewayPage(driver);
        oneway.OnewayTrip();
        oneway.sourceCity("Chennai");
        oneway.destinationCity("toronto");
        oneway.selectTravelDate("26","August 2025");  
        home.Search();
        
        AirlineValidateFlightInfo info=new AirlineValidateFlightInfo(driver);
       
        info.flightdetails();
        info.FareSummary();
        info.cancellation();
        
        
    }
    

   
	
}