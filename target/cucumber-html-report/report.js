$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/amazon.feature");
formatter.feature({
  "name": "Amazon",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Amazon :: TC001 :: Validate the cart by adding or deleting the products to or from the cart",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Navigate to the Url",
  "keyword": "Given "
});
formatter.step({
  "name": "User log in to the amazon application \"\u003cuserName\u003e\", \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Navigate to Car Accessories Section",
  "keyword": "When "
});
formatter.step({
  "name": "add any four products under five hundred INR to the cart and Validate the product prices and description",
  "keyword": "Then "
});
formatter.step({
  "name": "Proceed to Buy, select address and validate the prices",
  "keyword": "When "
});
formatter.step({
  "name": "Navigate back to Cart",
  "keyword": "And "
});
formatter.step({
  "name": "Delete the products in Cart and validate cart is empty",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "userName",
        "password"
      ]
    },
    {
      "cells": [
        "testautomation94223@gmail.com",
        "PrimePass"
      ]
    }
  ],
  "tags": [
    {
      "name": "@P1"
    }
  ]
});
formatter.scenario({
  "name": "Amazon :: TC001 :: Validate the cart by adding or deleting the products to or from the cart",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@P1"
    }
  ]
});
formatter.step({
  "name": "Navigate to the Url",
  "keyword": "Given "
});
formatter.match({
  "location": "Amazon.navigate_to_the_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User log in to the amazon application \"testautomation94223@gmail.com\", \"PrimePass\"",
  "keyword": "And "
});
formatter.match({
  "location": "Amazon.user_log_in_to_the_amazon_application(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to Car Accessories Section",
  "keyword": "When "
});
formatter.match({
  "location": "Amazon.navigate_to_car_accessories_section()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "add any four products under five hundred INR to the cart and Validate the product prices and description",
  "keyword": "Then "
});
formatter.match({
  "location": "Amazon.add_any_four_products_under_five_hundred_inr_to_the_cart_and_validate_the_product_prices_and_description()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Proceed to Buy, select address and validate the prices",
  "keyword": "When "
});
formatter.match({
  "location": "Amazon.proceed_to_buy_select_address_and_validate_the_prices()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate back to Cart",
  "keyword": "And "
});
formatter.match({
  "location": "Amazon.navigate_back_to_cart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Delete the products in Cart and validate cart is empty",
  "keyword": "Then "
});
formatter.match({
  "location": "Amazon.delete_the_products_in_cart_and_validate_cart_is_empty()"
});
formatter.result({
  "status": "passed"
});
});