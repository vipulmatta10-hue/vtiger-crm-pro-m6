package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class CreateAnnTest {
	@Test(priority=-1)
	public void createContactTest() {
		System.out.println("Create");
		Reporter.log("Create"); 
	}
	@Test(priority=0)
	public void modifyContactTest() {
		System.out.println("Modify");
		Reporter.log("Modify"); 
	}
	@Test(priority=1)
	public void deleteContactTest() {
		System.out.println("Delete");
		Reporter.log("Delete"); 
	}
}