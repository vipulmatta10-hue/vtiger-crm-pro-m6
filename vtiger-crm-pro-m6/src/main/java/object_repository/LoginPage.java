package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(name = "user_name")
//	private WebElement username;

//	AutoHealing	
	@FindAll(
			{
				@FindBy(id = "username"),
				@FindBy(name = "user_name")
			}
			)
	private WebElement username;
	
	public WebElement getUn() {
		return username;
	}

	@FindBy(name = "user_password")
	private WebElement password;

	public WebElement getPwd() {
		return password;
	}

	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
