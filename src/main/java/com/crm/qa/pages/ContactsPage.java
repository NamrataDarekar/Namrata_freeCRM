package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	WebElement contactLebel;
	
	@FindBy(xpath = "//span[ contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	 
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement newCreateContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
	WebElement company;
	
	@FindBy(xpath = "//button[contains( text(),'Save') ]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//a[contains(text(),'1')]")
	WebElement dashB;
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		contactLebel.click();
		return contactsLink.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		dashB.click();
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//ancestor::div[@class=\"table-wrapper\"]")).click();
		
		
		
		
	}
	
	
	
	public void createNewContact(String title, String ftName, String ltName, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	

}
