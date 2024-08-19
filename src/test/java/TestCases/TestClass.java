package TestCases;




import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pages.LoginPage;
import junit.framework.Assert;

public class TestClass extends BaseClass {
	@Test
	public void LoginFailureTest() {
		LoginPage LP = new LoginPage();
		LP.LoginFunction("Secret_user","Sauce_secret");
		
		LP.Validation("Epic sadface: Username and password do not match any user in this service");
		
	}
	@Test
	public void LoginSuccessTest()  {
		LoginPage Lp = new LoginPage();
		Lp.LoginFunction("standard_user", "secret_sauce");
		WebElement element = driver.findElement(By.xpath("//div[contains(text(),'Products')]"));
		Assert.assertTrue(element.isDisplayed());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
	}
	@Test
	public void AddToCart() {
		LoginPage LP = new LoginPage();
		LP.LoginFunction("standard_user", "secret_sauce");
		WebElement button = driver.findElement(By.xpath("//div[@id='inventory_container']/div[1]/div[2]/div[1]/div[1]/div[3]/button[1]"));
		button.click();
		WebElement cartbtn = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
		cartbtn.click();
		WebElement checkoutbtn = driver.findElement(By.xpath("//a[text()='CHECKOUT']"));
		checkoutbtn.click();
		WebElement firstName = driver.findElement(By.id("first-name"));
		firstName.sendKeys("James");
		WebElement lastName = driver.findElement(By.id("last-name"));
		lastName.sendKeys("Camberwell");
		WebElement zipCode = driver.findElement(By.id("postal-code"));
		zipCode.sendKeys("RM70RT");
		}
	@Test
		public void LockedUserTest()  {
			LoginPage LP = new LoginPage();
			LP.LoginFunction("locked_out_user", "secret_sauce");
			LP.Validation("Epic sadface: Sorry, this user has been locked out.");
			
		}
	}
