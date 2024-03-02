package Practice.EcommerceWebsite.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Practice.EcommerceWebsite.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {

	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".table-hover tr td:nth-child(3)")
	List<WebElement> orderItems;
	
	By orderSection = By.cssSelector(".table-hover");
	
	public Boolean verifyAddedProduct(String productName) {
		waitForElementToAppear(orderSection);
		Boolean match = orderItems.stream().anyMatch(item->item.getText().equals(productName));
		return match;
	}
	
}
