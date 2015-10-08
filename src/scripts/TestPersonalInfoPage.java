package scripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://login.yahoo.com/account/personalinfo");
		
		// pause 1 second
		pause(1000);
		
		WebElement editAccount = driver.findElement(By.xpath(xpath));
		editAccount.click();
	}
	
	private void initializeDriver() {
		driver = new FirefoxDriver();
	}
	
	private void initializeLogin() {
		Login login = new Login(driver,url,emailInput,passInput,submit);
		login.readLoginData("C:\\Users\\dustin.landry\\Documents\\GitHub\\YahooTest\\YahooTest\\src\\data\\login_credentials.data");
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
