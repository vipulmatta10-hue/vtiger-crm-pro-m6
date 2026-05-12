package Listeners_package;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseutility.BaseClass;
import generic_utility.JavaUtility;

public class Listeners_Implementations implements ISuiteListener, ITestListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("report configuration from listeners");
		String time = JavaUtility.generateDateTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./report/" + time + ".html");
		ExtentSparkReporter spark1 = new ExtentSparkReporter("./target/ExtentReports/index.html");
		spark.config().setDocumentTitle("VTiger CRM Report");
		spark.config().setReportName("Issue List of Organization Module");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.attachReporter(spark1);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Success !!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);

		test.addScreenCaptureFromBase64String(ss, "failed.png");

		test.log(Status.FAIL, "Failed....");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "skippedddd !!!");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		System.out.println("report backup from listeners");
	}
}

//@Listeners(IListeners.Listeners_Implementations.class)

