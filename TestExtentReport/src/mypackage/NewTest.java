package mypackage;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest {
	public static ExtentHtmlReporter htmlReporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	
	
  @Test
  public void f() {
	  
	  test = extent.createTest("Bulk Login Test","This is a set of test cases with valid and invalid login credentials");
	  System.out.println("Git Change");
	  System.out.println("Another Change");
  }
  
  @BeforeSuite
  public void extendReportSetUp()
  {
  	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/GeneratedExtentReport.html");
  	extent = new ExtentReports();
  	extent.attachReporter(htmlReporter);
  	extent.setSystemInfo("Operating System", "Windows 10");
  	extent.setSystemInfo("Testing Region", "Guru 99 Bank Demo Site");
  	extent.setSystemInfo("Environment", "Developing Automation Script");
  	extent.setSystemInfo("Developed By", "Rakesh");
  	htmlReporter.config().setDocumentTitle("Generated Extent Report Guru 99 Demo Bank Site");
  	htmlReporter.config().setReportName("Demo Test Result");
  	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
  	htmlReporter.config().setTheme(Theme.DARK);	

  }
      @AfterMethod
  	public void getResult(ITestResult result)
  	{
  		if(result.getStatus()==ITestResult.FAILURE)
  		{
  			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test Case Failed Due To Below Issue", ExtentColor.RED));
  			test.fail(result.getThrowable());
  		}
  		else if(result.getStatus()==ITestResult.SUCCESS)
  		{
  			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Case Passed", ExtentColor.GREEN));
  		}
  		else if(result.getStatus()==ITestResult.SKIP)
  		{
  			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test Case Skipped", ExtentColor.YELLOW));
  			test.skip(result.getThrowable());
  		}
  		
  	}
      
      @AfterSuite
  	public void writeReport()
  	{
  		extent.flush();
  	}
  
}

