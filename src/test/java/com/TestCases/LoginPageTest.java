package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TestBase.TestBase;
import com.TestPages.LoginPage;


public class LoginPageTest extends TestBase{
	LoginPage loginpage;

	public LoginPageTest() { //created constructor to initilize 
		super();  // super in framework. communicate with testbase
	}
	
	@BeforeMethod
	public void SetUp() {
		initil();
		loginpage = new LoginPage();
	}
	
	@Test(priority =2)		//priority starts with 0 in TestNG
	public void TestLogin() throws InterruptedException {
		loginpage.VerifyLogin(prop.getProperty("userName"),prop.getProperty("passWord"));
		Thread.sleep(1000);
		boolean dashboard = loginpage.VerifyHomePage();
		Assert.assertTrue(dashboard);
	}
	
	@Test(priority =0)
	public void TestLogo() throws InterruptedException {
		boolean logo = loginpage.VerifyLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority =1)
	public void TestTitle() throws InterruptedException {
		String title = loginpage.VerifyTitle();
		Assert.assertEquals(title,"Login - TechFios Test Application - Billing");
	}
	
	@Test(priority =4)
	public void TestErrorMessage() throws InterruptedException{
		loginpage.ErrorMessage(prop.getProperty("invalidUser"),prop.getProperty("invalidPassword"));
		Thread.sleep(1000);
		boolean er = loginpage.VerifyError();
		Assert.assertTrue(er);
		System.out.println("TestErrorMessage = " + er +"\n \n");		
	}
	
	
	
	 @AfterMethod
	 public void Teardown() throws InterruptedException {
		 driver.quit();	 
	 }
	
}

