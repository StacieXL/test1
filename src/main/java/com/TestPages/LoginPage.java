package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class LoginPage extends TestBase{

	//page factory>>function like container
	//we keep all the locator AND METHOD I THIS CLASS-LoginPage Class
	//Locators below depends on what we need in test scenarios
	@FindBy(xpath="//input[@id=\"username\"]")
	WebElement Username;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement SignInButton;

	@FindBy(xpath="//img[@class=\"logo\"]")
	WebElement Logo;
	
	@FindBy(xpath="//div[@class=\"alert alert-danger fade in\"]")
	WebElement ErrorMessage;
	
	@FindBy(xpath="//h2[text()='Dashboard ']")
	WebElement Dashboard;

	public LoginPage() {  //page name will be changed, why?constructor name is class name
		PageFactory.initElements(driver,this);  // in this class, 1 time standard all the time
	}											//PageFactory is an enhancement of POM to initialize all the pages
	
	public void VerifyLogin(String user, String pass) throws InterruptedException {
		System.out.println("TestLogin \n");
		Thread.sleep(1000);
		Username.sendKeys(user);
		Thread.sleep(2000);
		Password.sendKeys(pass);
		Thread.sleep(1000);
		SignInButton.click();
	}
	
	public String VerifyTitle() throws InterruptedException {
		System.out.println("TestTitle \n");
		Thread.sleep(5000);
		return driver.getTitle();
	}
	
	public boolean VerifyLogo() throws InterruptedException {
		System.out.println("TestLogo \n");
		Thread.sleep(4000);
		return Logo.isDisplayed();
	}
	
	public void ErrorMessage(String user, String pass) throws InterruptedException {
		System.out.println("Verifying Invalid Login");
		Thread.sleep(1000);
		Username.sendKeys(user);
		Thread.sleep(2000);
		Password.sendKeys(pass);
		Thread.sleep(1000);
		SignInButton.click();
	}
	
	public boolean VerifyError() {
		return ErrorMessage.isDisplayed();	
	}	

	public boolean VerifyHomePage() {
		return Dashboard.isDisplayed();
	
	}
}
	
	
	
	
	
	
	
	
	
//	//Constructor created
//	
//	public LoginPage() {  //page name will be changed, why?constructor name is class name
//		//PageFactory is the class
//		PageFactory.initElements(driver,this);  // in this class, 1 time standard all the time
//								//"this">>keyword, contains all object we holding
//	//This constructor created to initialize PageFactory values/all the locators just created
//	
//	}
//	
//	// All action
////	public void VerifyLogin() {
////		Username.sendKeys(prop.getProperty("UserName"));
////		Username.sendKeys(prop.getProperty("PassWord"));
////		SignInButton.click();
////	}
//	
//	public void VerifyLogin(String UserName, String Password) {
//		Username.sendKeys(UserName);
//		Username.sendKeys(Password);
//		SignInButton.click();
//	}
//	
//	public String VerifyTitle() {
//		return driver.getTitle();	
//	}
//	
//	public boolean VerifyLogo() {
//		return Logo.isDisplayed();	
//	}
//	
//	public void ErrorMessage(String Un, String pw) {
//		Username.sendKeys(Un);
//		Username.sendKeys(pw);
//		SignInButton.click();
//	}
//	
//	public boolean VerifyError() {
//		return ErrorMessage.isDisplayed();	
//	}
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
