package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BaseTest {
	
	
	@BeforeClass
	public void homePageSetUp(){
		homePage=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.goToContactsPage();
		System.out.println("In Contacts Page");
	}
	
	@Test(priority=1)
	public void verifyContactsPageTitleTest(){
	String title=	contactsPage.getContactsPageTitle();
	System.out.println("ContactsPage title is:"+title);
	Assert.assertEquals(title,ConstantsUtil.CONTACTS_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyContactsPageHeaderTest(){
		String header= contactsPage.getContactsPageHeader();
		System.out.println("ContactsPage header is:"+ header);
		Assert.assertTrue((header.contains(ConstantsUtil.CONTACTS_PAGE_HEADER)));
		
	}
	
	@DataProvider()
	public Object[][] getContactsTestData(){
		Object data[][]=ExcelUtil.getTestData(ConstantsUtil.CONTACTS_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider="getContactsTestData")
	public void createContactTest(String email,String firstName,String lastName,String jobTitle){
		contactsPage.createContact(email,firstName,lastName,jobTitle);
	}

}
