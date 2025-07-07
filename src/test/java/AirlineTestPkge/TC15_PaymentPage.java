package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineBillingAddress;
import AirlinePackage.AirlineBookFlight;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineMutliplePassanger;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlinePaymentPage;
import AirlinePackage.AirlineSeatSelection;
import AirlinePackage.SeatSelectionPage2;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC15_PaymentPage extends BaseClass{
		

	@Test(retryAnalyzer=IRetrylogic.class)
     
    public void TC15PaymentPage() throws InterruptedException {
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
       
        book.switchToNewWindow();
        Thread.sleep(1000);
      
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
       
       AirlinePaymentPage payment=new AirlinePaymentPage(driver);
       payment.cardDetails();
       payment.expiryMonth();
       
       AirlineBillingAddress bill=new AirlineBillingAddress(driver);
       bill.billingAddress();
       bill.pay();
    }
    

   
	
}