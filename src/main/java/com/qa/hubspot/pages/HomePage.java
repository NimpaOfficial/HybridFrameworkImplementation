package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//By Locator-OR
	private By header=By.tagName("h1");
	private By settingsIcon=By.id("navSetting");
	private By contactsParentMenu=By.id("nav-primary-contacts-branch");
	private By contactsSubMenu=By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver){
		elementUtil=new ElementUtil(driver);
		this.driver=driver;
	}
	
	public String homePageTitle(){
		//return driver.getTitle();
		return elementUtil.waitForTitlePresent(ConstantsUtil.HOME_PAGE_TITLE, 10);
	}
	
	public String getHeaderValue(){
//		if(driver.findElement(header).isDisplayed()){
//			return driver.findElement(header).getText();
//		}
//		return null;
		if(elementUtil.doIsDisplayed(header)){
			return elementUtil.doGetText(header);
		}
		return null;
	}
	
	public Boolean isSettingIconExists(){
		//return driver.findElement(settingsIcon).isDisplayed();
		return elementUtil.doIsDisplayed(settingsIcon);
	}

	public ContactsPage goToContactsPage(){
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
	private void clickOnContacts(){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		elementUtil.waitForElementPresent(contactsParentMenu, 10);
		elementUtil.doClick(contactsParentMenu);
		elementUtil.waitForElementPresent(contactsSubMenu, 10);
		elementUtil.doClick(contactsSubMenu);
	}
}
