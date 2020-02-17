package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login extends scenarios.webSetup{
	// <input name="username" data-cy="username" placeholder="Usuario" type="text" class="ant-input ant-input-lg" value="" style="width: 100%;">
	By userName_input = By.name("username");
	// <input name="password" data-cy="password" type="password" placeholder="Contraseña" action="click" class="ant-input ant-input-lg" value="">
	By password_input = By.name("password");
	// <button data-cy="submit" type="submit" class="ant-btn ant-btn-lg" style="width: 256px; background: rgb(89, 89, 89); color: rgb(255, 255, 255);"><span>Ingresar</span></button>
	By login_btn = By.tagName("button");
	
	String loginPage = "https://staging.portalkoe.cl/login";
	
	String userName = "test@embonor.cl";
	String password = "test123";
	
	@Test
	public void loginTest() { // TODO Auto-generated method stub 
	driver.get(loginPage);
  	WebElement user = driver.findElement(userName_input);
  	WebElement pass = driver.findElement(password_input);
  	WebElement login = driver.findElement(login_btn);
  	
  	user.sendKeys(userName);
  	pass.sendKeys(password);
  	login.click();
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.invisibilityOf(login));
    
    String actualUrl = driver.getCurrentUrl();
  	String expectedUrl = "https://staging.portalkoe.cl/";
  	Assert.assertEquals(actualUrl,expectedUrl);
  	}   
}