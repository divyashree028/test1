package com.amazon.stepDefinition;


import com.amazon.pageObject.Home_Page;
import com.amazon.runner.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class Amazon extends BaseClass{
	
	Home_Page homePage;
	
	
	@Given("Navigate to the Url")
	public void navigate_to_the_url() throws Exception {
		NavigateToUrl();
		homePage = new Home_Page(driver);
	}
	
	@Given("User log in to the amazon application {string}, {string}")
	public void user_log_in_to_the_amazon_application(String userName, String password) throws Exception {
		homePage.Login_To_Amazon(userName, password);
	}

	@When("Navigate to Car Accessories Section")
	public void navigate_to_car_accessories_section() throws Exception {
		homePage.Navigate_To_Car_Accessories();
	}

	@When("add any four products under five hundred INR to the cart and Validate the product prices and description")
	public void add_any_four_products_under_five_hundred_inr_to_the_cart_and_validate_the_product_prices_and_description() throws Exception {
		homePage.Select_Under_500_Validate_Items_Displayed();
		homePage.Fetch_First_Four_Product_Details();
		homePage.Add_First_Four_Products_To_Cart();
		homePage.Validate_Items_In_Cart();
	}

	@When("Proceed to Buy, select address and validate the prices")
	public void proceed_to_buy_select_address_and_validate_the_prices() throws Exception {
		homePage.Proceed_To_Buy_Select_Address_Validate_Price();
	}

	@When("Navigate back to Cart")
	public void navigate_back_to_cart() throws Exception {
		homePage.Navigate_Back_To_Cart();
	}

	@When("Delete the products in Cart and validate cart is empty")
	public void delete_the_products_in_cart_and_validate_cart_is_empty() throws Exception {
		homePage.Delete_Items_In_Cart_Validate_Cart_Is_Empty();
	}


}
