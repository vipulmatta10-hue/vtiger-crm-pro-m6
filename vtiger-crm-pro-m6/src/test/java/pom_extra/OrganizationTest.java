package pom_extra;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseutility.BaseClass;
import generic_utility.FileUtiltity;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.CreateOrgPage;
import object_repository.HomePage;
import object_repository.LogOutPage;
import object_repository.LoginPage;
import object_repository.OrganizationPage;
import object_repository.VerifyOrgPage;

@Listeners(Listeners_package.Listeners_Implementations.class)
public class OrganizationTest extends BaseClass {
	//public ExtentReports report;

	/*@BeforeSuite
	public void repConfig() {
		String time = JavaUtility.generateDateTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/java/work_on_advance_report/" + time + ".html");
		spark.config().setDocumentTitle("advance_rep_M6");
		spark.config().setReportName("FB report");
		spark.config().setTheme(Theme.STANDARD);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("key1", "value1");
		report.setSystemInfo("key2", "value2");
		report.setSystemInfo("key3", "value3");
	}*/

	@Test
	public void createOrganizationTest() {

// Home page pom object		
		HomePage hp = new HomePage(driver);
		hp.getOrgMenu().click();
//      System.out.println("org menu clicked");
		CreateOrgPage crp = new CreateOrgPage(driver);
		crp.getCreateOrg().click();
		OrganizationPage orgp = new OrganizationPage(driver);
		String orgName = "Qspider" + JavaUtility.generateRandomNum();
		WebElement orgField = orgp.getOrgField();
		orgField.sendKeys(orgName);
		orgp.getClickSave().click();
		VerifyOrgPage vop = new VerifyOrgPage(driver);
		String actOrgName = vop.getOrgName().getText();
		//boolean status = JavaUtility.compareName(actOrgName, orgName);
		Assert.assertEquals(actOrgName, orgName);
	}
	/*@AfterSuite
	public void repBackup() {
		report.flush();
	}*/
}
