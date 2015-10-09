package scripts;
import models.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestLoginPage {
	private String url = "";
	private String email = "";
	private String pass = "";
	
	private WebElement emailInput;
	private WebElement passInput;
	private WebElement submit;
	
	private WebDriver driver;
	
	@Test
	public void testCorrectLogin() {
		initializeDriver();
		Login login = new Login(driver,url,emailInput,passInput,submit);
		login.readLoginData("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\login_credentials.data");
		login.login();
		
		// pause 1 second
		pause(1000);
		
		driver.get("https://login.yahoo.com/account/personalinfo");
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://login.yahoo.com/account/personalinfo");
		
		driver.close();
	}
	
	@Test
	public void testIncorrectLogin() {
		initializeDriver();
		Login login = new Login(driver,url,emailInput,passInput,submit);
		login.readLoginData("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\bad_login_credentials.data");
		login.login();
		
		// pause 1 second
		pause(1000);
		
		driver.get("https://login.yahoo.com/account/personalinfo");
		
		pause(1000);
		
		Assert.assertNotEquals(driver.getCurrentUrl(),"https://login.yahoo.com/account/personalinfo");
		
		driver.close();
	}
	
	// *************************************************** helpers ***********************************************************  
	private void initializeDriver() {
		//driver = new FirefoxDriver();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setJavascriptEnabled(true);

		driver = new RemoteWebDriver(capabilities);
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
