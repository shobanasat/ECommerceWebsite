package Practice.EcommerceWebsite.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practice.EcommerceWebsite.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css=".toast-message")
	WebElement errorMessage;
	
	public ProductCatalogue loginToApplication(String name, String pwd) {
		userName.sendKeys(name);
		password.sendKeys(pwd);
		login.click();
		ProductCatalogue productCatalog = new ProductCatalogue(driver);
		return productCatalog;
	}
	
	public String getErrorMessage() {
		String errMessage = errorMessage.getText();
		return errMessage;
	}
	
	public void goToApplication() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}
}
