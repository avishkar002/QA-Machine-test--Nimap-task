package utilityClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver=null;
	@BeforeClass
	public void precondition() throws IOException {
	     String browser = ReadfromProperties.readproperties("browser");
	     String url = ReadfromProperties.readproperties("url");
	     
	    if(browser.equalsIgnoreCase("chrome")) {
	   	driver=new ChromeDriver();
	    }else if(browser.equalsIgnoreCase("edge")) {
	   	driver=new EdgeDriver();
	    }else if(browser.equalsIgnoreCase("firefox")) {
	   	 driver=new FirefoxDriver();
	   	 
	    }else {
	   System.out.println("enter incorrect browser !! ");
	    }
	  driver.get(url);
	  driver.manage().window().minimize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@BeforeMethod
	public void login() {

	}
	@AfterMethod
	public void logout() {
		
	}
	@AfterClass
	public void postconditon() {
	//driver.close();
	}
}
