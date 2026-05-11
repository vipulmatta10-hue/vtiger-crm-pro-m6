package gu_extra;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.WebDriverUtility; 

public class Handling_windows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://automationwithpiyush.vercel.app/popups.html");

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

//		step 2 => perform the task which will open new win/s
		driver.findElement(By.xpath("//button[@onclick='openMultipleWindows()']")).click();


		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		
		wdUtil.switchToWindow("flipkart");
		

//		step 5 => perform the task on target window
		Thread.sleep(2000);
		driver.close();

//		step 6 => get back home
		Thread.sleep(3000);

//		wdUtil.getBackHome();
		wdUtil.getBackHome();

//		close the main window
		Thread.sleep(2000);
		driver.close();

//		quit the server
		Thread.sleep(2000);
		driver.quit();

	}

}
