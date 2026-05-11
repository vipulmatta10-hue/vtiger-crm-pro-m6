package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	public LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"))
	
	@FindBy(css = "img[src='themes/softed/images/user.PNG']")
	private WebElement logoutbtn;

	public WebElement getLogOutBtn() {
		return logoutbtn;
	}

}
