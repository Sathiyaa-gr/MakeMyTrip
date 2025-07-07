package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineRoundTripPage;
import AirlinePackage.DatePicker;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC14_DomesticRoundTrip extends BaseClass{
		

	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC14DomesticRoundTripPage() throws InterruptedException {
    	AirlineHomePage home = new AirlineHomePage(driver);
        home.close();
        
        AirlineRoundTripPage round=new AirlineRoundTripPage(driver);
        round.roundTrip();
        round.sourceCity("Chennai");
        round.destinationCity("Mumbai");
        AirelineDatepicker date=new AirelineDatepicker(driver);
        date.selectTravelDates("September 2025","13","14");
        home.Search();
    }
    

   
	
}