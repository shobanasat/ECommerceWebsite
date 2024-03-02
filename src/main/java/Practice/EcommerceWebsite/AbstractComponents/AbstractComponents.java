package Practice.EcommerceWebsite.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Practice.EcommerceWebsite.PageObjects.CartPage;
import Practice.EcommerceWebsite.PageObjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitForElementToAppear(By FindBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	
	public void waitForInvisibilityOfElement(WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void scrollwindow() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)",""); 
	}
	
	public CartPage goToCart() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/cart\"]")).click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrders() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[routerlink=\"/dashboard/myorders\"]")).click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
}
