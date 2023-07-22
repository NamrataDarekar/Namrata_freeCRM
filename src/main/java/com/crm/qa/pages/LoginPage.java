package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//import com.crm.qa.base.TestBase;

//import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(xpath="//span[text()='Log In'] ")
	WebElement loginClick;
	//Page Factory - OR:
	@FindBy(name="email")
	//(xpath="//input[@placeholder='Email']")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	///html/body/div[1]/main/section[1]/a/span[2]
	@FindBy(xpath="//header/div[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement crmLogo;
	//img[contains(@class,'img-responsive')]
	
//	@FindBy(xpath="//div[text()='Something went wrong...']")
//	WebElement errorMsg;
//	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		loginClick.click();	
		username.sendKeys(un);
		password.sendKeys(pwd);
			//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
//		if(errorMsg.isDisplayed()) {
//			signUpBtn.click();
//		}
//		else {
//			System.out.println("Login Successfully");
//		}
//		    	
		return new HomePage();
	}
	
}
