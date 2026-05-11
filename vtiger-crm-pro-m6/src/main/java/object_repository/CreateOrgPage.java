package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage {
	
	public CreateOrgPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
	@FindBy(css = "img[title='Create Organization...']")
	private WebElement createorg;

	public WebElement getCreateOrg() {
		return createorg;
	}
	
}
