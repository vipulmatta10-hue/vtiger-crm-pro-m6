package generic_utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriverUtility {

//	Don't Repeat Yourself
	
	WebDriver driver;
	String PID;
	
	public WebDriverUtility(WebDriver driver){
		this.driver = driver;
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Moves the mouse to the middle of the element. 
	 * The element is scrolled into view and its location is calculated using getClientRects.
	 * 
	 * @param element to move to
	*/
	public void hover(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}

	public void switchToWindow(String partialUrl) {
//		step 1 => get the home address/parent session id
		PID = driver.getWindowHandle();

//		step 3 => get all the win addresses/ session IDs
		Set<String> CIDs = driver.getWindowHandles();

//		step 4 => switch to all  the windows and break the loop where condition meets
		for (String i : CIDs) {
			driver.switchTo().window(i);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}
	public void getBackHome() {
		driver.switchTo().window(PID);
	}
}
