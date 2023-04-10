Feature: Amazon

  Scenario Outline: Amazon :: TC001 :: Validate the cart by adding/deleting the products to/from the cart
    Given Launch the Browser and Navigate to the Url
    When Navigate to Car Accessories Section
    Then add any four products under 500 INR to the cart and Validate the product prices and description
    When Proceed to Buy, select address and validate the prices "<userName>", "<password>"
    And Navigate back to Cart
    Then Delete the products in Cart and validate cart is empty

    @P1
    Examples: 
      | userName   | password  |
      | 9071956668 | PrimePass |