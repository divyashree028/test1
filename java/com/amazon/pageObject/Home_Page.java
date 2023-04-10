package com.amazon.pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.amazon.runner.BaseClass;

public class Home_Page extends BaseClass {
	
	static WebDriver driver;
	static String[] productNamesArr;
	static String[] productPricesArr;
	
	 public Home_Page(WebDriver driver) {
		this.driver = driver;
	}
	

	@FindBy(id="//a[@id='nav-hamburger-menu']")
	public static WebElement allNavigation_Link;
	
	@FindBy(xpath="//div[text()='shop by category']")
	public static WebElement shopByCategory_Text;
	
	@FindBy(xpath="//div[text()='see all']")
	public static  WebElement seeAll_Link;
	
	@FindBy(xpath="//div[text()='Car, Motorbike, Industrial']")
	public static  WebElement carMotorBikeIndustrial_Link;
	
	@FindBy(xpath="//a[text()='Car Accessories']")
	public static  WebElement carAccessories_Link;
	
	@FindBy(xpath="//span[text()='Under ₹500']")
	public static  WebElement under500_Link;
	
	@FindBy(xpath="//span[@class='a-price-whole']")
	public static  WebElement productPrice_Text;
	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	public static  WebElement productName_Text;
	
	@FindBy(id="add-to-cart-button")
	public static  WebElement addToCart_Button;
	
	@FindBy(xpath="//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	public static  WebElement addedToCart_Text;
	
	@FindBy(xpath="//a[@href='https://www.amazon.in/gp/cart/view.html?ref_=nav_cart']")
	public static  WebElement cart_Button;
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")
	public static  WebElement productPriceInCart_Text;
	
	@FindBy(xpath="//span[@id='sc-subtotal-label-activecart']//preceding::span[@class='a-truncate-cut']")
	public static  WebElement productNameInCart_Text;
	
	@FindBy(xpath="//input[@data-feature-id='proceed-to-checkout-action']")
	public static  WebElement proceedToBuy_Button;
	
	@FindBy(id="'ap_email']")
	public static  WebElement mobileNumber_TextBox;
	
	@FindBy(id="ap_password")
	public static  WebElement password_TextBox;
	
	@FindBy(id="continue")
	public static  WebElement continue_Button;
	
	@FindBy(xpath="//h1")
	public static  WebElement header_Text;
	
	@FindBy(xpath="//input[@name='submissionURL'][1]")
	public static  WebElement address_RadioButton;
	
	@FindBy(xpath="//td[@class='a-color-price a-size-medium a-text-right grand-total-price aok-nowrap a-text-bold a-nowrap']")
	public static  WebElement orderTotal_Text;
	
	@FindBy(xpath="//input[@value='Delete']")
	public static  WebElement deleteProductInCart_Button;
	
	
	@SuppressWarnings("deprecation")
	public static void LaunchBrowser_NavigateToUrl() {
		try {
			System.setProperty("webdriver.chrome.driver", "./setup/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Navigate_To_Car_Accessories () {
		try {
			allNavigation_Link.click();
			Assert.assertEquals(shopByCategory_Text.isDisplayed(), true);
			seeAll_Link.click();
			Assert.assertEquals(carMotorBikeIndustrial_Link.isDisplayed(), true);
			carMotorBikeIndustrial_Link.click();
			Assert.assertEquals(carAccessories_Link.isDisplayed(), true);
			carAccessories_Link.click();
			
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Select_Under_500_Validate_Items_Displayed () {
		try {
			Assert.assertEquals(under500_Link.isDisplayed(), true);
			under500_Link.click();
			List<WebElement> productPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			boolean productsLessThan500 = true;
			for(WebElement ele:productPrices) {
				if(Integer.parseInt(ele.getText())>=500) {
					productsLessThan500 = false;
					break;
				}
			}
			Assert.assertEquals(productsLessThan500, true);
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Fetch_First_Four_Product_Details () {
		try {
			List<WebElement> productName = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
			List<WebElement> productPrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
			String[] productNamesArr = new String[4];
			String[] productPricesArr = new String[4];
			int cnt = 0;
			for(WebElement ele:productName) {
				productNamesArr[cnt] = ele.getText();
				cnt++;
			}
			cnt = 0;
			for(WebElement ele:productPrice) {
				productPricesArr[cnt] = ele.getText();
				cnt++;
			}
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Add_First_Four_Products_To_Cart () {
		try {
			List<WebElement> productName = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
			String parentWindow = driver.getWindowHandle();
			for(WebElement ele:productName) {
				ele.click();
				switchWindow(parentWindow);
				addToCart_Button.click();
				Assert.assertEquals(addedToCart_Text.isDisplayed(), true);
				driver.close();
				driver.switchTo().window(parentWindow);
			}
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Validate_Items_In_Cart () {
		try {
			cart_Button.click();
			List<WebElement> productNameInCart = driver.findElements(By.xpath("//span[@id='sc-subtotal-label-activecart']//preceding::span[@class='a-truncate-cut']"));
			int cnt = 0;
			for(WebElement ele: productNameInCart) {
				Assert.assertEquals(ele.getText().trim(), productNamesArr[cnt]);
				cnt++;
			}
			Assert.assertEquals(cnt, 4);
			List<WebElement> productPriceinCart = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']"));
			cnt = 0;
			for(WebElement ele: productPriceinCart) {
				Assert.assertEquals(ele.getText().trim(), productPricesArr[cnt]);
				cnt++;
			}
			Assert.assertEquals(cnt, 4);
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Proceed_To_Buy_Select_Address_Validate_Price (String userName, String password) {
		try {
			proceedToBuy_Button.click();
			Assert.assertEquals(mobileNumber_TextBox.isDisplayed(), true);
			mobileNumber_TextBox.sendKeys(userName);
			continue_Button.click();
			password_TextBox.sendKeys(password);
			continue_Button.click();
			address_RadioButton.click();
			int totalAmount = 0;
			for(int itr=0; itr<productPricesArr.length; itr++) {
				totalAmount = totalAmount + Integer.parseInt(productPricesArr[itr]);
			}
			Assert.assertEquals(Integer.parseInt(orderTotal_Text.getText()), totalAmount);
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	
	public static void Navigate_Back_To_Cart() {
		try {
			driver.navigate().back();
			driver.navigate().back();
			cart_Button.click();
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}
	
	public static void Delete_Items_In_Cart_Validate_Cart_Is_Empty() {
		try {
			List<WebElement> productsInCartDel = driver.findElements(By.xpath("//input[@value='Delete']"));
			for(WebElement ele: productsInCartDel) {
				ele.click();
			}
			Assert.assertEquals(header_Text.getText(), "Your Amazon Cart is empty.");
		}catch(Exception exp) {
			System.out.println(exp.toString());
		}
	}

	public static void switchWindow(String parentWindow) {
		for(String ele:driver.getWindowHandles()) {
			if(!ele.equals(parentWindow)) {
				driver.switchTo().window(ele);
				break;
			}
		}
	}
	
	
}
