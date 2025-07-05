package AirlineTestPkge;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import AirlinePackage.AirlineHomePage;
import AirlinePackage.AirlineLoginPage;
import AirlinePackage.AirlineLoginPage2;
import AirlinePackage.AirlineOnewayPage;
import AirlineUtil.IRetrylogic;
import AirlineUtil.MyListener;

@Listeners(MyListener.class)
public class TC1_Registration extends BaseClass{
	

	@Test(retryAnalyzer=IRetrylogic.class)
    public void Registration() throws InterruptedException {
    	
    	
    	AirlineLoginPage2 login = new AirlineLoginPage2(driver);
    	
    	login.enterMobile();
    	login.enterCntryCode();
    	login.loginviapwd();
    	AirlineHomePage home=new AirlineHomePage(driver);
    	home.verifylogin();
    }
    

   
	
}