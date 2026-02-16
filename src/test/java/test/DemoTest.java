package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsAndCart;
import utils.ExcelUtils;

public class DemoTest extends BaseTest {
	
@Test(dataProvider="loginData")

public void workFlow(String username,String password,String expectedResult) {
	//loginpage
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(username);
	loginpage.enterPassword(password);
	loginpage.clickLoginbtn();
	
	if(expectedResult.equalsIgnoreCase("success")) {
		Assert.assertTrue(loginpage.isLoginSuccessful(), "Login should be successful");
	}else {
		Assert.assertTrue(loginpage.iserrorMsgDisplayed(), "Error message should be displayed");
	}
	//products&cartpage
	ProductsAndCart productsAndCart = new ProductsAndCart(driver);
	productsAndCart.AddToCart();
	Assert.assertEquals(productsAndCart.getCartcount(), "1");
	
	productsAndCart.ClickCartIcon();
	
	Assert.assertEquals(productsAndCart.getProductName(), "Sauce Labs Backpack");
	
	productsAndCart.removeBtn();
	
	
}
@DataProvider(name="loginData")
public static Object[][] loginData() throws Exception{
	
	return ExcelUtils.getExcelData("C:\\Users\\computer-2\\Documents\\excel test.xlsx", "sheet1");
	
	
	
}
}
