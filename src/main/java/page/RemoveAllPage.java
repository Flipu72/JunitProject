package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemoveAllPage {
	
WebDriver driver;
	
	public RemoveAllPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH,using = "/html/body/div[3]/input[3]")
	WebElement TOGGLE_ELEMENT;
	@FindBy(how=How.XPATH,using = "/html/body/div[3]/input[1]")
	WebElement REMOVEALLBUTTON_ELEMENT;
	 
	
	public void checkToggleBox() {
		TOGGLE_ELEMENT.click();
	}
	
	public boolean clickRemoveButton() {
		REMOVEALLBUTTON_ELEMENT.click();
		return true;
	}
	public void verifyAllRemoved() {
		List<WebElement> Element = driver.findElements(By.cssSelector("input[name='todo[0]']"));
	
		
		if (Element.size() == 0) {  

			System.out.println("All Elements Removed");
		} else {  

			System.out.println("All Elements not Removed");
		}

	
	
	}
}