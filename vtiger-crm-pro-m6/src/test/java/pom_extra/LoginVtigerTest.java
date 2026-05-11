package pom_extra;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import object_repository.LoginPage;

import org.openqa.selenium.WebDriver;

public class LoginVtigerTest {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8888/");

		LoginPage lp = new LoginPage(driver);
		WebElement username = lp.getUn();
//					1100
		
		driver.navigate().refresh();
		
		username.sendKeys("admin");
//		1100

		WebElement password = lp.getPwd();
		
		password.sendKeys("admin");

//		driver.findElement(By.id("submitButton")).click();
		lp.getLoginBtn().click(); 
        Thread.sleep(2000);
		driver.quit();
	}

}
