package scripts;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import models.*;

public class TestEditAccountPage {
	private final int SUCCESSFUL_NAME_COUNT = 5;
	private final int SUCCESSFUL_MOBILE_COUNT = 5;
	private final int SUCCESSFUL_HOME_PHONE_COUNT = 3;
	private final int SUCCESSFUL_HOME_FAX_COUNT = 3;
	private final int SUCCESSFUL_WORK_PHONE_COUNT = 3;
	private final int SUCCESSFUL_WORK_FAX_COUNT = 3;
	private final int SUCCESSFUL_HOME_ADDRESS_COUNT = 5;
	private final int SUCCESSFUL_WORK_ADDRESS_COUNT = 5;
	
	private String url = "";
	private String email = "";
	private String pass = "";
	
	private WebElement emailInput;
	private WebElement passInput;
	private WebElement submit;
	
	private WebDriver driver;
	
	// Test EditAccount page with successful data
	@Test
	public void testSuccessAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		driver.get("https://login.yahoo.com/account/personalinfo");
		
		// pause 1 second
		pause(1000);
		
		WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
		editAccount.click();
		
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		inputTestData(contact);
		
		WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
		submit.click();
		
		pause(1000);
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://login.yahoo.com/account/personalinfo");
		
		driver.close();
	}
	
	// Test the 3 name fields on the edit account page
	@Test
	public void testNameEditAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Name> names = readNames("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_name.data");
		
		for (int i = 0; i < names.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.name.setTitle(names.get(i).getTitle());
			contact.name.setFirstName(names.get(i).getFirstName());
			contact.name.setLastName(names.get(i).getLastName());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_NAME_COUNT);
	}
	
	//@Test
	public void testEmailAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Name> names = readNames("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_name.data");
		
		for (int i = 0; i < names.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.name.setTitle(names.get(i).getTitle());
			contact.name.setFirstName(names.get(i).getFirstName());
			contact.name.setLastName(names.get(i).getLastName());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_NAME_COUNT);
	}
	
	//@Test
	public void testMessengerAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Name> names = readNames("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_name.data");
		
		for (int i = 0; i < names.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.name.setTitle(names.get(i).getTitle());
			contact.name.setFirstName(names.get(i).getFirstName());
			contact.name.setLastName(names.get(i).getLastName());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_NAME_COUNT);
	}
	
	// test the 2 fields of the mobile component on the edit account page
	//@Test
	public void testMobileAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Phone> mobile = readMobile("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_mobile.data");
		
		for (int i = 0; i < mobile.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.mobile.setNumber(mobile.get(i).getNumber());
			contact.mobile.setShare(mobile.get(i).getShare());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1.5 seconds
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_MOBILE_COUNT);
	}
	
	// test the 2 fields of the home phone component on the edit account page
	//@Test
	public void testHomePhoneAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Phone> home = readMobile("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_home_phone.data");
		
		for (int i = 0; i < home.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.homePhone.setNumber(home.get(i).getNumber());
			contact.homePhone.setShare(home.get(i).getShare());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_HOME_PHONE_COUNT);
	}
	
	//@Test
	public void testWorkPhoneAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Phone> work = readMobile("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_work_phone.data");
		
		for (int i = 0; i < work.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.workPhone.setNumber(work.get(i).getNumber());
			contact.workPhone.setShare(work.get(i).getShare());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_WORK_PHONE_COUNT);
	}
	
	//@Test
	public void testHomeFaxAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Phone> home = readMobile("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_home_fax.data");
		
		for (int i = 0; i < home.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.homeFax.setNumber(home.get(i).getNumber());
			contact.homeFax.setShare(home.get(i).getShare());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_HOME_FAX_COUNT);
	}
	
	//@Test
	public void testWorkFaxAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Phone> work = readMobile("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_work_fax.data");
		
		for (int i = 0; i < work.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.workFax.setNumber(work.get(i).getNumber());
			contact.workFax.setShare(work.get(i).getShare());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_WORK_FAX_COUNT);
	}
	
	//@Test
	public void testHomeAddressAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Address> names = readAddress("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_home_address.data");
		
		for (int i = 0; i < names.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.homeAddress.setCountry(names.get(i).getCountry());
			contact.homeAddress.setStreet(names.get(i).getStreet());
			contact.homeAddress.setCity(names.get(i).getCity());
			contact.homeAddress.setZip(names.get(i).getZip());
			contact.homeAddress.setState(names.get(i).getState());
			contact.homeAddress.setShare(names.get(i).getShare());
			
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_HOME_ADDRESS_COUNT);
	}
	
	//@Test
	public void testWorkAddressAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Address> names = readAddress("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_work_address.data");
		
		for (int i = 0; i < names.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.workAddress.setCountry(names.get(i).getCountry());
			contact.workAddress.setStreet(names.get(i).getStreet());
			contact.workAddress.setCity(names.get(i).getCity());
			contact.workAddress.setZip(names.get(i).getZip());
			contact.workAddress.setState(names.get(i).getState());
			contact.workAddress.setShare(names.get(i).getShare());
			
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_WORK_ADDRESS_COUNT);
	}
	
	//@Test
	public void testWebsiteAccountPage() {
		initializeDriver();
		initializeLogin();
		
		// pause 1 second
		pause(1000);
		
		ContactInformation contact = new ContactInformation();
		int successCount = 0;
		
		contact = readTestData(contact,"C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_success.data"); 
		ArrayList<Name> names = readNames("C:\\Users\\dustin.landry\\Documents\\Eclipse Workspace\\YahooTest\\src\\data\\test_name.data");
		
		for (int i = 0; i < names.size() ; i++) {
			driver.get("https://login.yahoo.com/account/personalinfo");
			
			// pause 1 second
			pause(1000);
			
			WebElement editAccount = driver.findElement(By.xpath(".//*[@class=\"spread\"]"));
			editAccount.click();
			
			pause(1000);
			
			// add custom data
			contact.name.setTitle(names.get(i).getTitle());
			contact.name.setFirstName(names.get(i).getFirstName());
			contact.name.setLastName(names.get(i).getLastName());
			
			inputTestData(contact);
			
			WebElement submit = driver.findElement(By.xpath(".//*[@id='SaveBtn']"));
			submit.click();
			
			// pause 1 second
			pause(1000);
			
			if (driver.getCurrentUrl().subSequence(0,44).equals("https://login.yahoo.com/account/personalinfo")) 
				successCount++;
		} 
		
		driver.close();
		
		Assert.assertEquals(successCount,SUCCESSFUL_NAME_COUNT);
	}
	
	// *************************************************** helpers ***********************************************************  		
	private ContactInformation readTestData(ContactInformation contact, String file) {
		String content = "";
		
		try {
			content = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(content);
		
		String[] t = content.split("\n");
		
		contact.name.setTitle(t[0].split(",")[0]); 
		contact.name.setFirstName(t[0].split(",")[1]); 
		contact.name.setLastName(t[0].split(",")[2]); 
		contact.email.setEmail(t[1].split(",")[0]);
		contact.email.setShare(t[1].split(",")[1]);
		contact.messenger.setMessenger(t[2].split(",")[0]);
		contact.messenger.setShare(t[2].split(",")[1]);
		contact.mobile.setNumber(t[3].split(",")[0]);
		contact.mobile.setShare(t[3].split(",")[1]);
		contact.homePhone.setNumber(t[4].split(",")[0]);
		contact.homePhone.setShare(t[4].split(",")[1]);
		contact.workPhone.setNumber(t[5].split(",")[0]);
		contact.workPhone.setShare(t[5].split(",")[1]);
		contact.homeFax.setNumber(t[6].split(",")[0]);
		contact.homeFax.setShare(t[6].split(",")[1]);
		contact.workFax.setNumber(t[7].split(",")[0]);
		contact.workFax.setShare(t[7].split(",")[1]);
		contact.homeAddress.setCountry(t[8].split(",")[0]);
		contact.homeAddress.setStreet(t[8].split(",")[1]);
		contact.homeAddress.setCity(t[8].split(",")[2]);
		contact.homeAddress.setZip(t[8].split(",")[3]);
		contact.homeAddress.setState(t[8].split(",")[4]);
		contact.homeAddress.setShare(t[8].split(",")[5]);
		contact.workAddress.setCountry(t[9].split(",")[0]);
		contact.workAddress.setStreet(t[9].split(",")[1]);
		contact.workAddress.setCity(t[9].split(",")[2]);
		contact.workAddress.setZip(t[9].split(",")[3]);
		contact.workAddress.setState(t[9].split(",")[4]);
		contact.workAddress.setShare(t[9].split(",")[5]);
		contact.website.setUrl(t[10].split(",")[0]);
		contact.website.setShare(t[10].split(",")[1]);
		
		return contact;
	}
	
	private void inputTestData(ContactInformation contact) {
		ArrayList<WebElement> info = new ArrayList<WebElement>();
		info.add(driver.findElement(By.xpath(".//*[@id='Title']")));	
		info.add(driver.findElement(By.xpath(".//*[@id='GivenName']")));
		info.add(driver.findElement(By.xpath(".//*[@id='FamilyName']")));
		info.add(driver.findElement(By.xpath(".//*[@id='ImHandle0']")));
		info.add(driver.findElement(By.xpath(".//*[@id='MobileNumber0']")));
		info.add(driver.findElement(By.xpath(".//*[@id='PhoneNumber0']")));
		info.add(driver.findElement(By.xpath(".//*[@id='PhoneNumber1']")));
		info.add(driver.findElement(By.xpath(".//*[@id='PhoneNumber2']")));
		info.add(driver.findElement(By.xpath(".//*[@id='PhoneNumber3']")));
		info.add(driver.findElement(By.xpath(".//*[@id='AddressTxt0']")));
		info.add(driver.findElement(By.xpath(".//*[@id='City0']")));
		info.add(driver.findElement(By.xpath(".//*[@id='PostalCode0']")));
		info.add(driver.findElement(By.xpath(".//*[@id='AddressTxt1']")));
		info.add(driver.findElement(By.xpath(".//*[@id='City1']")));
		info.add(driver.findElement(By.xpath(".//*[@id='PostalCode1']")));
		info.add(driver.findElement(By.xpath(".//*[@id='WebsiteURL0']")));
		
		info.get(0).clear();
		info.get(1).clear();
		info.get(2).clear();
		info.get(3).clear();
		info.get(4).clear();
		info.get(5).clear();
		info.get(6).clear();
		info.get(7).clear();
		info.get(8).clear();
		info.get(9).clear();
		info.get(10).clear();
		info.get(11).clear();
		info.get(12).clear();
		info.get(13).clear();
		info.get(14).clear();
		info.get(15).clear();
	
		info.get(0).sendKeys(contact.name.getTitle());
		info.get(1).sendKeys(contact.name.getFirstName());
		info.get(2).sendKeys(contact.name.getLastName());
		info.get(3).sendKeys(contact.messenger.getMessenger());
		info.get(4).sendKeys(contact.mobile.getNumber());
		info.get(5).sendKeys(contact.homePhone.getNumber());
		info.get(6).sendKeys(contact.workPhone.getNumber());
		info.get(7).sendKeys(contact.homeFax.getNumber());
		info.get(8).sendKeys(contact.workFax.getNumber());
		info.get(9).sendKeys(contact.homeAddress.getStreet());
		info.get(10).sendKeys(contact.homeAddress.getCity());
		info.get(11).sendKeys(contact.homeAddress.getZip());
		info.get(12).sendKeys(contact.workAddress.getStreet());
		info.get(13).sendKeys(contact.workAddress.getCity());
		info.get(14).sendKeys(contact.workAddress.getZip());
		info.get(15).sendKeys(contact.website.getUrl());		
	}
	
	private ArrayList<Name> readNames(String file) {
		String content = "";
		ArrayList<Name> names = new ArrayList<Name>();
		
		try {
			content = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] t = content.split("\n");
		
		for (String n : t) {
			Name name = new Name();
			
			name.setTitle(n.split(",")[0]);
			name.setFirstName(n.split(",")[1]);
			name.setLastName(n.split(",")[2]);
			
			names.add(name);
		}
		
		return names;
	}
	
	private ArrayList<Phone> readMobile(String file) {
		String content = "";
		ArrayList<Phone> mobile = new ArrayList<Phone>();
		
		try {
			content = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] t = content.split("\n");
		
		for (String n : t) {
			Phone m = new Phone();
			
			m.setNumber(n.split(",")[0]);
			m.setShare(n.split(",")[1]);
			
			mobile.add(m);
		}
		
		return mobile;
	}
	
	private ArrayList<Address> readAddress(String file) {
		String content = "";
		ArrayList<Address> address = new ArrayList<Address>();
		
		try {
			content = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] t = content.split("\n");
		
		for (String n : t) {
			Address m = new Address();
			
			m.setCountry(n.split(",")[0]);
			m.setStreet(n.split(",")[1]);
			m.setCity(n.split(",")[2]);
			m.setZip(n.split(",")[3]);
			m.setState(n.split(",")[4]);
			m.setShare(n.split(",")[5]);
			
			address.add(m);
		}
		
		return address;
	}
	
	private void initializeDriver() {
		driver = new FirefoxDriver();
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
