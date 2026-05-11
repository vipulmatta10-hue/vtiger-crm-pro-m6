package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//driver.findElement(By.linkText("Organizations")).click();
	
	@FindBy(linkText = "Organizations")
	private WebElement orgmenu;

	public WebElement getOrgMenu() {
		return orgmenu;
	}
	
	/*@FindBy(name = "user_password")
	private WebElement password;

	public WebElement getPwd() {
		return password;
	}*/

}
