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

public class CartPage extends AbstractComponents {

	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(xpath="//button[text()=\"Checkout\"]")
	WebElement checkout;
	
	By cartSection = By.cssSelector(".cartSection h3");
	
	public Boolean verifyAddedProduct(String productName) {
		waitForElementToAppear(cartSection);
		Boolean match = cartItems.stream().anyMatch(item->item.getText().equals(productName));
		return match;
	}
	
	public CheckoutPage clickCheckout() {
		checkout.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}
	
}
