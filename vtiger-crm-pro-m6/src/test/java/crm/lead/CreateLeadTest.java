package crm.lead;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateLeadTest {

	public static void main(String[] args) throws InterruptedException {
//		browser opening
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// login
		driver.get("http://localhost:8888/");

		// enter username and password
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("admin");

//		click on login button
		driver.findElement(By.id("submitButton")).click();

//		create one Lead
//		click on Lead link
		driver.findElement(By.linkText("Leads")).click();
//		click on plus icon
		driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
//		fill the form
		String leadName = "Lead1";
		WebElement lnameField = driver.findElement(By.name("lastname"));
		lnameField.sendKeys(leadName);

		String cmpnyName = "TCS";
		WebElement cnameField = driver.findElement(By.name("company"));
		cnameField.sendKeys(cmpnyName);

//		save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// verification
		String actLeadName = driver.findElement(By.id("dtlview_Last Name")).getText();
		boolean status = actLeadName.equals(leadName);
		if (status) {
			System.out.println("Lead created successfully!!!");
		} else {
			System.out.println("Failed.....");
		}

//logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		profile.click();
		driver.findElement(By.linkText("Sign Out")).click();

//				browser closing
		Thread.sleep(3000);
		driver.quit();
	}
}
