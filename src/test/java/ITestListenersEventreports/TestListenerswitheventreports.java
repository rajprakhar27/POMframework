package ITestListenersEventreports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListenerswitheventreports implements ITestListener {
	
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void setup()
	{
		reporter=new ExtentSparkReporter("G:\\Extentreports\\Extentreportgenerate.html");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Tester Name", "Prakhar");
		reports.setSystemInfo("Browser Name", "Chrome");
		
		reporter.config().setDocumentTitle("Extent report generation");
		reporter.config().setReportName("Report on data driven testing,pom framework with page factory");
		reporter.config().setTheme(Theme.DARK);
	}
	
	public void onStart(ITestContext context) {
		setup();
		System.out.println("onstart method");
	}
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("onTeststart method"+result.getName());
		
		
	}
	
	
	public void onTestSuccess(ITestResult result)
	{System.out.println("onTestSuccess method"+result.getName());
	test=reports.createTest(result.getName());
	test.log(Status.PASS, MarkupHelper.createLabel("This is the pass test case "+result.getName(), ExtentColor.GREEN));}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestfailure method"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("This is the failed test case "+result.getName(), ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestskipped method"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("This is the skip test case "+result.getName(), ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("onfinish method");
		reports.flush();
	}
	
	public void onTestFailedButSuccessPercentage (ITestResult result) {
		
	}
	
	
	

}
