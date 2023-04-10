package com.amazon.pageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.amazon.runner.BaseClass;

public class Home_Page extends BaseClass {
	
	WebDriver driver;
	static String[] productNamesArr = new String[4];
	static String[] productPricesArr = new String[4];
	
	 public Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement helloSignIn_Text;

	@FindBy(xpath="//span[@class='hm-icon-label']")
	private WebElement allNavigation_Link;
	
	@FindBy(xpath="//div[text()='shop by category']")
	private WebElement shopByCategory_Text;
	
	@FindBy(xpath="//div[text()='see all']")
	private  WebElement seeAll_Link;
	
	@FindBy(xpath="//div[text()='Car, Motorbike, Industrial']")
	private  WebElement carMotorBikeIndustrial_Link;
	
	@FindBy(xpath="//a[text()='Car Accessories']")
	private  WebElement carAccessories_Link;
	
	@FindBy(xpath="//span[text()='Under ₹500']")
	private  WebElement under500_Link;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	private  WebElement productPrice_Text;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	private  WebElement productName_Text;
	
	@FindBy(id="add-to-cart-button")
	private  WebElement addToCart_Button;
	
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	private  WebElement addedToCart_Text;
	
	@FindBy(xpath="//a[@href='https://www.amazon.in/gp/cart/view.html?ref_=nav_cart']")
	private  WebElement cart_Button;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	private  WebElement productPriceInCart_Text;
	
	@FindBy(xpath="//span[@id='sc-subtotal-label-activecart']//preceding::span[@class='a-truncate-cut']")
	private  WebElement productNameInCart_Text;
	
	@FindBy(xpath="//input[@data-feature-id='proceed-to-checkout-action']")
	private  WebElement proceedToBuy_Button;
	
	@FindBy(id="ap_email")
	private  WebElement mobileNumber_TextBox;
	
	@FindBy(id="ap_password")
	private  WebElement password_TextBox;
	
	@FindBy(id="continue")
	private  WebElement continue_Button;
	
	@FindBy(id="signInSubmit")
	private  WebElement signIn_Button;
	
	@FindBy(xpath="//h1")
	private  WebElement header_Text;
	
	@FindBy(xpath="//h2")
	private  WebElement header2_Text;
	
	@FindBy(xpath="//input[@name='submissionURL'][1]")
	private  WebElement address_RadioButton;
	
	@FindBy(xpath="//td[@class='a-color-price a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']")
	private  WebElement orderTotal_Text;
	
	@FindBy(xpath="//input[@value='Delete']")
	private  WebElement deleteProductInCart_Button;
	
	
	//Login to Amazon Application
	public void Login_To_Amazon(String userName, String password) throws Exception {
		try {
			helloSignIn_Text.click();
			ExplicitWait(driver, mobileNumber_TextBox, 10);
			Assert.assertEquals(mobileNumber_TextBox.isDisplayed(), true);
			mobileNumber_TextBox.sendKeys(userName);
			continue_Button.click();
			ExplicitWait(driver, password_TextBox, 10);
			password_TextBox.sendKeys(password);
			signIn_Button.click();
			ExplicitWait(driver, helloSignIn_Text, 10);
			Assert.assertEquals(helloSignIn_Text.getText(), "Hello, Divya");
			System.out.println("Login to Amazon Application - Successful");
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Login to Amazon Application");
		}
	}
	
	//Navigate to Car Accessories Page
	public void Navigate_To_Car_Accessories() throws Exception {
		try {
			allNavigation_Link.click();
			ExplicitWait(driver, shopByCategory_Text, 10);
			Assert.assertEquals(shopByCategory_Text.isDisplayed(), true);
			seeAll_Link.click();
			ExplicitWait(driver, carMotorBikeIndustrial_Link, 10);
			Assert.assertEquals(carMotorBikeIndustrial_Link.isDisplayed(), true);
			carMotorBikeIndustrial_Link.click();
			ExplicitWait(driver, carAccessories_Link, 10);
			Assert.assertEquals(carAccessories_Link.isDisplayed(), true);
			carAccessories_Link.click();
			Thread.sleep(5000);
			ExplicitWait(driver, under500_Link, 20);
			Assert.assertTrue(under500_Link.isDisplayed());
			Assert.assertEquals(header2_Text.getText().trim(), "Car essentials, parts and accessories");
			System.out.println("Navigated to Car Accessories Page - Successful");
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Navigate to Car Accessories Page");
		}
	}
	
	//Click Under 500 INR link and validate products displayed are less then 500
	public void Select_Under_500_Validate_Items_Displayed () throws Exception {
		try {
			under500_Link.click();
			ExplicitWait(driver, productPrice_Text, 10);
			List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			boolean productsLessThan500 = true;
			for(WebElement ele:productPrices) {
				if(Integer.parseInt(ele.getText())>=500) {
					productsLessThan500 = false;
					break;
				}
			}
			Assert.assertTrue(productsLessThan500);
			System.out.println("Products Displayed are less than 500 INR - Successful");
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Products displayed are not having price less than 500");
		}
	}
	
	//Fetch First Four Product Details - Name and Price
	public void Fetch_First_Four_Product_Details () throws Exception {
		try {
			List<WebElement> productName = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
			List<WebElement> productPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			int cnt = 0;
			for(WebElement ele:productName) {
				productNamesArr[cnt] = ele.getText().trim().toLowerCase();
				System.out.println(productNamesArr[cnt]);
				cnt++;
				if(cnt==4) {
					System.out.println("Fetched the First Four Product Names - " + Arrays.toString(productNamesArr) +" - Successful");
					break;
				}
			}
			cnt = 0;
			for(WebElement ele:productPrice) {
				productPricesArr[cnt] = ele.getText().trim().toLowerCase();
				System.out.println(productPricesArr[cnt]);
				cnt++;
				if(cnt==4) {
					System.out.println("Fetched the First Four Product Prices - " + Arrays.toString(productPricesArr) + " - Successful");
					break;
				}
			}
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Fetch the Product Details");
		}
	}
	
	//Add First Four Products to the Cart
	public void Add_First_Four_Products_To_Cart () throws Exception {
		try {
			List<WebElement> productName = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
			String parentWindow = driver.getWindowHandle();
			int cnt = 0;
			for(WebElement ele:productName) {
				ele.click();
				Thread.sleep(2000);
				switchWindow(parentWindow);
				addToCart_Button.click();
				ExplicitWait(driver, addedToCart_Text, 10);
				Assert.assertTrue(addedToCart_Text.isDisplayed());
				driver.close();
				driver.switchTo().window(parentWindow);
				cnt++;
				if(cnt==4) {
					System.out.println("Added First Four Products to Cart - Successful");
					break;
				}
			}
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Add Products to Cart");
		}
	}
	
	//Validate Items Displayed in the Cart
	public void Validate_Items_In_Cart () throws Exception {
		try {
			cart_Button.click();
			ExplicitWait(driver, productNameInCart_Text, 10);
			List<WebElement> productNameInCart = driver.findElements(By.xpath("//span[@id='sc-subtotal-label-activecart']//preceding::span[@class='a-truncate-cut']"));
			int cnt = 0;
			for(int itr=0; itr<4; itr++) {
//				System.out.println("Array Element - " + productNamesArr[itr]);
				for(int itrm=0; itrm<productNameInCart.size(); itrm++) {
					String productName = productNameInCart.get(itrm).getText().trim().toLowerCase();
					if(productName.contains("…")) {
						productName = productName.split("…")[0];
					}
//					System.out.println("element - " + productName);
					if(productNamesArr[itr].contains(productName)) {
						cnt++;
						break;
					}
				}
			}
			Assert.assertEquals(cnt, 4);
			System.out.println("Expected Product Names are displayed in the Cart - Successful");
			List<WebElement> productPriceinCart = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
			cnt = 0;
			for(int itr=0; itr<4; itr++) {
				for(int itrm=0; itrm<productPriceinCart.size(); itrm++) {
					String productPrice = productPriceinCart.get(itrm).getText().trim().toLowerCase();
					productPrice = productPrice.replace("₹", "");
					productPrice = productPrice.substring(0, productPrice.indexOf("."));
					if(productPricesArr[itr].equalsIgnoreCase(productPrice)) {
						cnt++;
						break;
					}
				}
			}
			Assert.assertEquals(cnt, 4);
			System.out.println("Expected Product Prices are displayed in the Cart - Successful");
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Expected Items are not Displayed in the Cart");
		}
	}
	
	
	//Proceed to Buy, Select Address and Validate Total Price
	public void Proceed_To_Buy_Select_Address_Validate_Price() throws Exception {
		try {
			proceedToBuy_Button.click();
			ExplicitWait(driver, address_RadioButton, 10);
			address_RadioButton.click();
			int totalAmount = 0;
			for(int itr=0; itr<productPricesArr.length; itr++) {
				totalAmount = totalAmount + Integer.parseInt(productPricesArr[itr]);
			}
			String actualOrderTotal = orderTotal_Text.getText().trim();
			actualOrderTotal = actualOrderTotal.replace("₹", "");
			actualOrderTotal = actualOrderTotal.replace(",", "");
			actualOrderTotal = actualOrderTotal.substring(0, actualOrderTotal.indexOf("."));
			
			System.out.println(actualOrderTotal);
			System.out.println(totalAmount);
			Assert.assertEquals(Integer.parseInt(actualOrderTotal), totalAmount);
			System.out.println("Order Total Price is Matched - Expected: "+ totalAmount + " - Actual: "+ Integer.parseInt(actualOrderTotal));
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Validate the Order Total Price");
		}
	}
	
	//Navigate Back to Cart
	public void Navigate_Back_To_Cart() throws Exception {
		try {
			driver.navigate().back();
			ExplicitWait(driver, cart_Button, 10);
			cart_Button.click();
			ExplicitWait(driver, productNameInCart_Text, 10);
			Assert.assertEquals(header_Text.getText().trim(), "Shopping Cart");
			System.out.println("Navigated Back to Cart - Successful");
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Navigate Back to Cart");
		}
	}
	
	//Delete all the Items in the Cart
	public void Delete_Items_In_Cart_Validate_Cart_Is_Empty() throws Exception {
		try {
			List<WebElement> productsInCartDel = driver.findElements(By.xpath("//input[@value='Delete']"));
//			for(WebElement ele: productsInCartDel) {
//				ele.click();
//				Thread.sleep(1000);
//				productsInCartDel = driver.findElements(By.xpath("//input[@value='Delete']"));
//			}
			for(int itr=0; itr<productsInCartDel.size(); itr++) {
				deleteProductInCart_Button.click();
				Thread.sleep(1000);
			}
			Assert.assertEquals(header_Text.getText().trim(), "Your Amazon Cart is empty.");
			System.out.println("Deleted all the Items in the Cart - Successful");
		}catch(Exception exp) {
			System.out.println(exp.toString());
			throw new Exception("Failed to Delete Items in the Cart");
		}
	}

	
	
	
}
