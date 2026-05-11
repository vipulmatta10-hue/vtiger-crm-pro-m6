package crm.org;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTest {

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

//		create one Organizations
//		click on Organizations link
		driver.findElement(By.linkText("Organizations")).click();

//		click on plus icon
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

//		fill the form
		String orgName = "Qspiders";
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

//		save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		// verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		boolean status = actOrgName.equals(orgName);
		if (status) {
			System.out.println("Organisation created successfully!!!");
		} else {
			System.out.println("Failed.....");
		}

		// logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		profile.click();
		driver.findElement(By.linkText("Sign Out")).click();

//		browser closing
		Thread.sleep(3000);
		driver.quit();
	}
}
