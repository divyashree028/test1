package com.amazon.stepDefinition;

import com.amazon.pageObject.Home_Page;
import com.amazon.runner.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class amazon extends BaseClass {
	
	
	@Given("Launch the Browser and Navigate to the Url")
	public void launch_the_browser_and_navigate_to_the_url() {
		Home_Page.LaunchBrowser_NavigateToUrl();
	}

	@When("Navigate to Cars Accessories Section")
	public void navigate_to_section(String string) {
		Home_Page.Navigate_To_Car_Accessories();
	}

	@When("add any four products under 500 INR to the cart and Validate the product prices and description")
	public void add_any_four_products_under_inr_to_the_cart_and_validate_the_product_prices_and_description(Integer int1) {
		Home_Page.Select_Under_500_Validate_Items_Displayed();
		Home_Page.Fetch_First_Four_Product_Details();
		Home_Page.Add_First_Four_Products_To_Cart();
		Home_Page.Validate_Items_In_Cart();
	}

	@When("Proceed to Buy, select address and validate the prices {string}, {string}")
	public void proceed_to_buy_select_address_and_validate_the_prices(String userName, String password) {
		Home_Page.Proceed_To_Buy_Select_Address_Validate_Price(userName, password);
	}

	@When("Navigate back to Cart")
	public void navigate_back_to_cart() {
		Home_Page.Navigate_Back_To_Cart();
	}

	@When("Delete the products in Cart and validate cart is empty")
	public void delete_the_products_in_cart_and_validate_cart_is_empty() {
		Home_Page.Delete_Items_In_Cart_Validate_Cart_Is_Empty();
	}


}
