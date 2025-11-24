package automatelogin;
//
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilityClass.BaseClass;
//
public class Login extends BaseClass {
	@Test(dataProvider = "loginData")
    public void loginTest(String username, String password) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//		driver.get("");
		driver.manage().deleteAllCookies();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.id("kt_login_signin_submit")).click();
        Thread.sleep(8000);

        String expectedSuccessURL = "https://testffc.nimapinfotech.com/dashboard";
        String expectedFailureURL = "https://testffc.nimapinfotech.com/auth/login";
        String actualURL = driver.getCurrentUrl();
        // Validate login success or failure
        if (actualURL.equals(expectedSuccessURL)) {
         System.out.println("LOGIN SUCCESSFUL for: " + username);
         Assert.assertEquals(actualURL, expectedSuccessURL, "User should navigate to Dashboard after successful login");
        } 
        else if (actualURL.equals(expectedFailureURL)) {
         System.out.println("LOGIN FAILED for: " + username);
         Assert.assertEquals(actualURL, expectedFailureURL, "User should stay on Login page for invalid credentials");
        } 
        else {
         System.out.println("UNKNOWN RESULT URL: " + actualURL);
         Assert.fail("Unexpected navigation occurred.");
        }
        //driver.findElement(By.xpath("//span[text()='Punch In']")).click();
            
        
    }

    @DataProvider(name = "loginData")

    public Object[][] getData() 
    {
             return new Object[][]{	
                {"avishkar7272@gmail.com", "Niphad@12345"},    // valid
                
    };
    }
}
