package AirlineUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import AirlineTestPkge.BaseClass;


public class MyListener  implements ITestListener{


	
	public WebDriver driver;
	
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
	    WebDriver driver = ((BaseClass) currentClass).driver;
	    String methodName = result.getMethod().getMethodName();
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String screenshotName = methodName + "_" + timeStamp + ".png";

	    if (driver != null) {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
	    	Reporter.log("Listener:Test is Pass");
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\anbuj\\eclipse-workspace\\AirlineProject2\\Screenshot1\\Pass\\"+screenshotName);
			try {
				FileHandler.copy(src, dest);
				System.out.println("Sceenshots taken for  Pass");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("Driver is null, cannot take screenshot.");
	    }
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
	    WebDriver driver = ((BaseClass) currentClass).driver;
	    String methodName = result.getMethod().getMethodName();
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String screenshotName = methodName + "_" + timeStamp + ".png";

	    if (driver != null) {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
	    	Reporter.log("Listener:Test is Fail");
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\anbuj\\eclipse-workspace\\AirlineProject2\\Screenshot1\\Fail\\"+screenshotName);
			try {
				FileHandler.copy(src, dest);
				System.out.println("Sceenshots taken for  fail");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("Driver is null, cannot take screenshot.");
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
	   WebDriver driver = ((BaseClass) currentClass).driver;
	    String methodName = result.getMethod().getMethodName();
	    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    String screenshotName = methodName + "_" + timeStamp + ".png";

	    
	    if (driver != null) {
	    	TakesScreenshot ts=(TakesScreenshot) driver;
	    	Reporter.log("Listener:Test is skiped");
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("C:\\Users\\anbuj\\eclipse-workspace\\AirlineProject2\\Screenshot1\\Skip\\"+screenshotName);
			try {
				FileHandler.copy(src, dest);
				System.out.println("Sceenshots taken for skip");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    } else {
	        System.out.println("Driver is null, cannot take screenshot.");
	    }
	}

	
}


