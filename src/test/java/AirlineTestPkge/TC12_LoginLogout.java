package AirlineTestPkge;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AirlinePackage.AirelineDatepicker;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineLoginPage2;
import AirlinePackage.AirlineLogout;
import AirlinePackage.AirlineMutlicityPage;
import AirlinePackage.AirlineOnewayPage;
import AirlinePackage.AirlineRoundTripPage;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC12_LoginLogout extends BaseClass{
		


	@Test(retryAnalyzer=IRetrylogic.class)
    public void TC12LoginLogout() throws InterruptedException {
    	
    	AirlineLoginPage2 login = new AirlineLoginPage2(driver);
    	login.enterMobile();
    	login.enterCntryCode();
    	login.loginviapwd();
    	AirlineHomePage home=new AirlineHomePage(driver);
    	home.verifylogin();
    	Thread.sleep(2000);
    	 
    	
    	AirlineLogout log=new AirlineLogout(driver);
    	log.hoverLoginorCreate();
    	log.logout();
    
    }
    

   
	
}