package object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//WebElement orgField = driver.findElement(By.name("accountname"));
	
	@FindBy(name = "accountname")
	private WebElement orgField;

	public WebElement getOrgField() {
		return orgField;
	}
	
	//driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	
	@FindBy(css = "input[title='Save [Alt+S]']")
	private WebElement clicksave;

	public WebElement getClickSave() {
		return clicksave;
	}


}
