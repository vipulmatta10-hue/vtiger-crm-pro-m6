package crm.email;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateEmailTest {

    public static void main(String[] args) throws InterruptedException {

        // 1. Browser Setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        try {
            // 2. Login to CRM
            driver.get("http://localhost:8888/");
            driver.findElement(By.name("user_name")).sendKeys("admin");
            driver.findElement(By.name("user_password")).sendKeys("admin");
            driver.findElement(By.id("submitButton")).click();

            // 3. Navigate to Email Compose
            driver.findElement(By.linkText("Email")).click();
            driver.findElement(By.linkText("Compose")).click();

            // 4. Handle 'Compose' Window Switch
            Thread.sleep(2000); // Allow window to open
            String parentId = driver.getWindowHandle();
            Set<String> allWindowIds = driver.getWindowHandles();

            for (String id : allWindowIds) {
                driver.switchTo().window(id);
                if (driver.getCurrentUrl().contains("EditView")) {
                    driver.findElement(By.cssSelector("img[title='Select']")).click();
                    break;
                }
            }

            // 5. Handle 'Contacts' Window Switch (Select Email ID)
            String composeWindow = driver.getWindowHandle();
            Set<String> contactWindowIds = driver.getWindowHandles();

            for (String id : contactWindowIds) {
                driver.switchTo().window(id);
                if (driver.getCurrentUrl().contains("Contacts")) {
                    driver.findElement(By.linkText("Mary Smith")).click();
                    driver.switchTo().window(composeWindow);
                    break;
                }
            }

            // 6. Generate and Enter Unique Subject
            int randomNumber = (int) (Math.random() * 1000);
            String finalSubject = "test" + randomNumber;

            WebElement subjectField = driver.findElement(By.id("subject"));
            subjectField.sendKeys(finalSubject);

            // 7. Save Email and Return to Main List
            driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
            driver.switchTo().window(parentId);

            // 8. Dynamic Subject Verification
            // Note: XPath is used here as CSS cannot search by inner text
            String xpathLocator = "//tr[starts-with(@id, 'row_')]//td//b[contains(text(),'" + finalSubject + "')]";
            String actualSubject = driver.findElement(By.xpath(xpathLocator)).getText();

            if (actualSubject.equals(finalSubject)) {
                System.out.println("SUCCESS: Mail successfully Saved -> " + finalSubject);
            } else {
                System.out.println("FAILED: Expected [" + finalSubject + "] but found [" + actualSubject + "]");
            }

            // 9. Logout Sequence
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']")).click();
            driver.findElement(By.linkText("Sign Out")).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 10. Termination
            Thread.sleep(3000);
            driver.quit();
        }
    }
}