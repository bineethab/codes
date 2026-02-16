package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	 
	By username=By.id("user-name");
	By password=By.id("password");
	By loginbtn=By.id("login-button");
	By errorMsg=By.xpath("//h3[@data-test='error']");
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLoginbtn() {
		driver.findElement(loginbtn).click();
	}
	
	public boolean isLoginSuccessful() {
		return driver.getCurrentUrl().contains("inventory");
	}
	
	public boolean iserrorMsgDisplayed() {
		return driver.findElements(errorMsg).size()>0;
	}
}
