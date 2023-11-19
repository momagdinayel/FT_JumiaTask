@Runner
Feature: Login || user could Login to the site

  Scenario: user could Login entering valid data

    And Open "https://www.jumia.com.eg/"
    And user close Ad and click on Account then SignIn
    And user enter valid email"5skdlf5js@gmail.com" and valid password"5skdlfjs409"
    And user hover on Supermarket and click on bakery
    And add two items to cart
    Then verify items are added and subtotal is calculated correctly