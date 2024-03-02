package Practice.EcommerceWebsite.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practice.EcommerceWebsite.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".toast-success")
	WebElement toast;
	
	/*
	 * @FindBy(css="button[routerlink=\"/dashboard/cart\"]") WebElement cart;
	 */
	
	By productsBy = By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".mb-3 button:last-of-type");
	
	public WebElement findMatchingProduct(String productName) {
		waitForElementToAppear(productsBy);
		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addTocart(String productName) {
		WebElement prod = findMatchingProduct(productName);	
		prod.findElement(addTocart).click();
		waitForElementToAppear(By.id("toast-container"));
		//waitForInvisibilityOfElement(toast);
	}
	

	
}
