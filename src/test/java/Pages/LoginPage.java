package Pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;
import junit.framework.Assert;

public class LoginPage {
	WebDriver driver = BaseClass.driver;

	@FindBy(id = "user-name")
	WebElement insertUN;
	@FindBy(id = "password")
	WebElement insertPsd;
	@FindBy(id = "login-button")
	WebElement LoginBtn;
	@FindBy(tagName = "h3")
	WebElement errorMsg;
	
	public LoginPage(){
	 PageFactory.initElements(driver, this);
	}
	
public void LoginFunction(String UserNameVal, String PsdVal) {
	
	insertUN.sendKeys(UserNameVal);
	insertPsd.sendKeys(PsdVal);
	LoginBtn.click();
}
public void Validation(String ExpMsg) {
	String ActMsg = errorMsg.getText();
	Assert.assertEquals(ExpMsg, ActMsg);
}
public void alertBtn() {
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

}
