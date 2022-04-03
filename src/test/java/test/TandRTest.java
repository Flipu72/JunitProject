package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;
import page.RemoveAllPage;
import page.RemovePage;
import page.TogglePage;
import util.BrowserFactory;

public class TandRTest {
	
	WebDriver driver;
	
	@Before
	public void startBrowser() {
		driver = BrowserFactory.init();
	}
	
	@Test
	public void validateToggle () throws InterruptedException {
	 
		
		TogglePage togglepage = PageFactory.initElements(driver, TogglePage.class);
		togglepage.addItems();
		togglepage.checkToggleBox();
		boolean verify = togglepage.verifyChecked();
		Assert.assertTrue(verify);
		
	}
	@Test 
	public void validateSingleListItem() throws InterruptedException {
	 
		
		RemovePage removepage = PageFactory.initElements(driver, RemovePage.class);
		removepage.clickSingleItem();
		removepage.clickRemoveButton();
		removepage.verifyItemRemoved();  
		boolean verify = removepage.clickSingleItem(); 
		Assert.assertTrue(verify); 
	  
		
	}
	@Test
	public void validdateAllListItems() throws InterruptedException {
	 
		
		RemoveAllPage removeallpage = PageFactory.initElements(driver, RemoveAllPage.class);
		
		removeallpage.checkToggleBox();
		removeallpage.verifyAllRemoved();
		boolean verify = removeallpage.clickRemoveButton();
		Assert.assertTrue(verify);
	 
	}
	@After
	public void closeBrowser() throws InterruptedException {
		BrowserFactory.tearDown();
	}

}