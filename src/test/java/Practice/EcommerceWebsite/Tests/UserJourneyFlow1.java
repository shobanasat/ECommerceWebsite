package Practice.EcommerceWebsite.Tests;

import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Practice.EcommerceWebsite.PageObjects.CartPage;
import Practice.EcommerceWebsite.PageObjects.CheckoutPage;
import Practice.EcommerceWebsite.PageObjects.ConfirmationPage;
import Practice.EcommerceWebsite.PageObjects.LandingPage;
import Practice.EcommerceWebsite.PageObjects.OrderPage;
import Practice.EcommerceWebsite.PageObjects.ProductCatalogue;
import Practice.EcommerceWebsite.TestComponents.BaseTests;

public class UserJourneyFlow1 extends BaseTests {

	String productName = "ADIDAS ORIGINAL";

	@Test
	public void E2EUserJourney() throws IOException, InterruptedException {

		ProductCatalogue productCatalog = landingPage.loginToApplication("shobanasathyanathan@gmail.com", "Shobikr@1");

		productCatalog.findMatchingProduct(productName);
		productCatalog.addTocart(productName);
		CartPage cartPage = productCatalog.goToCart();

		Boolean match = cartPage.verifyAddedProduct(productName);
		Assert.assertTrue(match);
		CheckoutPage checkout = cartPage.clickCheckout();

		checkout.selectDropDownValue();
		ConfirmationPage confirmation = checkout.clickPlaceHolder();

		String message = confirmation.checkConfirmationMessage();
		Assert.assertEquals("THANKYOU FOR THE ORDER.", message);

	}

	@Test(dependsOnMethods = { "E2EUserJourney" })
	public void verifyOrderHistory() throws InterruptedException {
		
		landingPage.loginToApplication("shobana@gmail.com", "Shobikr@1");
		OrderPage orderPage = new OrderPage(driver);
		orderPage.goToOrders();
		Boolean match = orderPage.verifyAddedProduct(productName);
		Assert.assertTrue(match);
	}

}
