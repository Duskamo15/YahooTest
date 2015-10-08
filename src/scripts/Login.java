package scripts;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	private WebDriver driver;
	
	private WebElement emailInput;
	private WebElement passInput;
	private WebElement submit;
	
	private String url = "";
	private String email = "";
	private String pass = "";
	
	public Login(WebDriver driver, String url, WebElement emailInput, WebElement passInput, WebElement submit) {
		this.driver = driver;
		this.emailInput = emailInput;
		this.passInput = passInput;
		this.submit = submit;
		this.url = url;
	}
	public void login() {		
		driver.get(url);
		emailInput = driver.findElement(By.xpath(".//*[@id='login-username']"));
		passInput = driver.findElement(By.xpath(".//*[@id='login-passwd']"));
		submit = driver.findElement(By.xpath(".//*[@id='login-signin']"));
		
		emailInput.sendKeys(email);
		passInput.sendKeys(pass);
		
		// pause 1 second
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		submit.click();
	}

	public void readLoginData(String file) {
		String content = "";		
		
		try {
			content = new String(Files.readAllBytes(Paths.get(file)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] t = content.split("\n");
		
		url = t[0];
		email = t[1];
		pass = t[2];
	}
}
