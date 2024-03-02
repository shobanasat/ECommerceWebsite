package Cucumber;


import java.io.IOException;

import org.testng.Assert;

import Practice.EcommerceWebsite.PageObjects.CartPage;
import Practice.EcommerceWebsite.PageObjects.CheckoutPage;
import Practice.EcommerceWebsite.PageObjects.ConfirmationPage;
import Practice.EcommerceWebsite.PageObjects.LandingPage;
import Practice.EcommerceWebsite.PageObjects.ProductCatalogue;
import Practice.EcommerceWebsite.TestComponents.BaseTests;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseTests {
	
	LandingPage landingPage;
	ProductCatalogue productCatalog;
	CartPage cartPage;
	ConfirmationPage confirmation;
	
	@Given("I have landed in the application")
	public void I_have_landed_in_the_application() throws IOException {
		landingPage = launchApplication();
	}
	
	 @Given("^I have logged in using username (.+) and password (.+)$")
	 public void I_have_logged_in_using_username_and_password(String name, String pwd) {
		 productCatalog = landingPage.loginToApplication(name, pwd);
	 }
	 
	 @When("^I select product (.+) and add to cart$")
	 public void I_select_product_and_add_to_cart(String productName) throws InterruptedException {
			productCatalog.findMatchingProduct(productName);
			productCatalog.addTocart(productName);
			cartPage = productCatalog.goToCart();
	 }
	 
	 @And("^Provide payment details and checkout product (.+)$")
	 public void Provide_payment_details_and_checkout_product(String productName) throws InterruptedException {
			Boolean match = cartPage.verifyAddedProduct(productName);
			Assert.assertTrue(match);
			CheckoutPage checkout = cartPage.clickCheckout();
			checkout.selectDropDownValue();
			confirmation = checkout.clickPlaceHolder();
	 }
	 
	 @Then("{string} message should be displayed")
	 public void message_should_be_displayed(String string) {
			String message = confirmation.checkConfirmationMessage();
			Assert.assertEquals("THANKYOU FOR THE ORDER.", message);
	 }
}
