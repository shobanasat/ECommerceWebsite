package Practice.EcommerceWebsite.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import Practice.EcommerceWebsite.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents {

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 * String message = driver.findElement(By.className("hero-primary")).getText();
	 * Assert.assertEquals("THANKYOU FOR THE ORDER.", message);
	 */
	
	@FindBy(className="hero-primary")
	WebElement confirmationMessage;
	
	public String checkConfirmationMessage() {
		String message = confirmationMessage.getText();
		return message;
	}
	
	
}
