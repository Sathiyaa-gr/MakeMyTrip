package AirlineTestPkge;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import AirlinePackage.AirlineInvalidLogin;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;


@Listeners(MyListener.class)
public class TC3_InvalidLoginPage extends BaseClass{
	

	@Test(retryAnalyzer=IRetrylogic.class,dataProvider="logindata",dataProviderClass=AirlineUtil.DataFetching.class)
	    public void testAirlineLoginPage2(String mobile, String pwd ) throws InterruptedException {
	    	
	    	
		  AirlineInvalidLogin login = new AirlineInvalidLogin(driver);
	    	
	    	login.enterMobile(mobile);
	    	login.continuebtn();
	    	
	    }
	    
    

   
	
}