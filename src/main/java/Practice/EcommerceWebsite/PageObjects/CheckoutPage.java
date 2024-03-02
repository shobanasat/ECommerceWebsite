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

public class CheckoutPage extends AbstractComponents {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="[placeholder=\"Select Country\"]")
	WebElement inputValue;
	
	@FindBy(xpath="(//i[@class=\"fa fa-search\"])[2]")
	WebElement selectDropDown;
	
	@FindBy(css=".action__submit")
	WebElement placeholderButton;
	
	public void selectDropDownValue() {
		inputValue.sendKeys("India");
		selectDropDown.click();
	}
	
	public ConfirmationPage clickPlaceHolder() throws InterruptedException {
		scrollwindow();
		Thread.sleep(1000);
		placeholderButton.click();
		ConfirmationPage confirmation = new ConfirmationPage(driver);
		return confirmation;
	}
	
}
