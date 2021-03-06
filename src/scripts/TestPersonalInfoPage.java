package scripts;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPersonalInfoPage {
	private String url = "";
	private String email = "";
	private String pass = "";
	
	private WebElement emailInput;
	private WebElement passInput;
	private WebElement submit;
	
	private WebDriver driver;
	
	private WebDriverWait wait;
	
	@Test
	public void testEditAccountButton() {	
		initializeDriver();
		initializeLogin();
		testButton(".//*[@class=\"spread\"]");
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl().substring(0, 49),"https://edit.yahoo.com/config/edit_account?.done=");
		
		driver.close();
	}
	
	@Test
	public void testManageAccountButton() {
		initializeDriver();
		initializeLogin();
		testButton(".//*[@class=\"action-item-row last\"]//*[@class=\"spread\"]");
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl().substring(0, 47),"https://edit.yahoo.com/identity/manage?.scrumb=");
		
		driver.close();
	}
	
	@Test
	public void testPersonalInfoButton() {
		initializeDriver();
		initializeLogin();

		testButton(".//*[@class='clrfix selected']");
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl().substring(0, 44),"https://login.yahoo.com/account/personalinfo");
		
		driver.close();
	}
	
	@Test
	public void testAccountSecurityButton() {
		initializeDriver();
		initializeLogin();
		testButton(".//*[@class='clrfix '][1]//*[@class='title']");
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl().substring(0, 40),"https://login.yahoo.com/account/security");
		
		driver.close();
	}
	
	@Test
	public void testRecentActivityButton() {
		initializeDriver();
		initializeLogin();
		testButton(".//*[@class='clrfix '][2]//*[@class='title']");
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl().substring(0, 40),"https://login.yahoo.com/account/activity");
		
		driver.close();
	}
	
	@Test
	public void testPreferencesButton() {
		initializeDriver();
		initializeLogin();
		testButton(".//*[@class='clrfix '][3]//*[@class='title']");
		
		pause(1000);

		Assert.assertEquals(driver.getCurrentUrl().substring(0, 43),"https://login.yahoo.com/account/preferences");
		
		driver.close();
	}
	
	@Test
	public void testSubscriptionsButton() {
		initializeDriver();
		initializeLogin();
		testButton(".//*[@class='clrfix '][4]//*[@class='title']");
		
		pause(1000);

		Assert.assertEquals(driver.getCurrentUrl().substring(0, 45),"https://login.yahoo.com/account/subscriptions");
		
		driver.close();
	}
	
	// *************************************************** helpers ***********************************************************  
	
	private void testButton(String xpath) {
		// pause 1 second
		pause(1000);
		
		driver.get("https://login.yahoo.com/account/personalinfo");
		
		// pause 1 second
		pause(1000);
		
		//WebElement editAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		
		WebElement editAccount = driver.findElement(By.xpath(xpath));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", editAccount);
	}
	
	private void initializeDriver() {
		//driver = new FirefoxDriver();
		
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
			//wait = new WebDriverWait(driver, 10);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void initializeLogin() {
		Login login = new Login(driver,url,emailInput,passInput,submit);
		login.readLoginData("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\login_credentials.data");
		login.login();
	}
	
	private void pause(long mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
