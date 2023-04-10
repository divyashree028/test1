Feature: Amazon

  Scenario Outline: Amazon :: TC001 :: Validate the cart by adding or deleting the products to or from the cart
    Given Navigate to the Url
    And User log in to the amazon application "<userName>", "<password>"
    When Navigate to Car Accessories Section
    Then add any four products under five hundred INR to the cart and Validate the product prices and description
    When Proceed to Buy, select address and validate the prices
    And Navigate back to Cart
    Then Delete the products in Cart and validate cart is empty

    @P1
    Examples: 
      | userName                      | password  |
      | testautomation94223@gmail.com | PrimePass |
