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
import Practice.EcommerceWebsite.PageObjects.ProductCatalogue;
import Practice.EcommerceWebsite.TestComponents.BaseTests;

public class ErrorValidation extends BaseTests {
	
	
	String productName = "ADIDAS ORIGINAL";
	@Test(groups= {"Errorhandling"})
	public void ErrorCheck1() throws IOException, InterruptedException {

		ProductCatalogue productCatalog = landingPage.loginToApplication("shobanasathyanathan@gmail.comm", "Shobikr@2");
		String message = landingPage.getErrorMessage();
		Assert.assertEquals("Incorrect email or password.", message);
	}
	
	@Test
	public void ErrorCheck2() throws IOException, InterruptedException {

		ProductCatalogue productCatalog = landingPage.loginToApplication("shobanasathyanathan@gmail.com", "Shobikr@1");

		productCatalog.findMatchingProduct(productName);
		productCatalog.addTocart(productName);
		CartPage cartPage = productCatalog.goToCart();

		Boolean match = cartPage.verifyAddedProduct("ADIDAS ORIGINA");
		Assert.assertTrue(match);
	}

}
