package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsAndCart {

	WebDriver driver;
	//add to cart
	
	By addtoCart=By.id("add-to-cart-sauce-labs-backpack");
	By cartCount=By.className("shopping_cart_badge");
	By cartIcon=By.className("shopping_cart_link");
	
	
	//remove and productname
	By productName=By.className("inventory_item_name");
	By removebtn=By.id("remove-sauce-labs-backpack");
	
	
	public ProductsAndCart(WebDriver driver) {
		this.driver=driver;
		
	}
	public void AddToCart() {
		driver.findElement(addtoCart).click();
		
	}
	public String getCartcount() {
		return driver.findElement(cartCount).getText();
	}
	public void ClickCartIcon(){
		driver.findElement(cartIcon).click();
	}

	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
public void removeBtn() {
	driver.findElement(removebtn).click();
}
}
