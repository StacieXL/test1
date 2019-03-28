package com.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;

public class ProductNServicesPage extends TestBase{

	
	
	@FindBy(xpath="//input[@id=\"name\"]")
	WebElement Name;

	@FindBy(xpath="//input[@id=\"sales_price\"]")
	WebElement SalesPrice;
	
	@FindBy(xpath="//input[@id=\"item_number\"]")
	WebElement ItemNumber;

	@FindBy(xpath="//textarea[@class=\"form-control\"]")
	WebElement Description;
	
	public ProductNServicesPage() {
		PageFactory.initElements(driver, this);
	
	}
	









}
