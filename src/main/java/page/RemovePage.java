package page;

 

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RemovePage  {
	
	WebDriver driver;
	int previousSize;

	public RemovePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = " body > div.controls > input[type=submit]:nth-child(1)")
	WebElement REMOVEBUTTON_ELEMENT;
	@FindBy(how = How.CSS, using = "ul > li:nth-child(1) > input")
	WebElement SINGLEITEM_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"todos-content\"]/form/ul/li[2]/text()")
	WebElement LISTITEM_ELEMENT;
	// @FindBy(name = "todo[1]")
	// WebElement singleItem;

	public void clickRemoveButton() {

		previousSize = driver.findElements(By.cssSelector("ul > li")).size();
		REMOVEBUTTON_ELEMENT.click();

	}

	public void clickSingleItem() {
		SINGLEITEM_ELEMENT.click();
	}

	public void listItemElement() {
		LISTITEM_ELEMENT.getText();
	}

	public boolean verifyItemRemoved() {

		int currentSize = driver.findElements(By.cssSelector("ul > li")).size();

		if (currentSize == previousSize - 1) {

			System.out.println("Element Removed");
			return true;
		} else {

			System.out.println("Element not Removed");
			return false;
		}

	}

}