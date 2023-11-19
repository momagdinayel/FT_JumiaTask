@Runner
Feature: Registration|| user could register to the site

Scenario: user could register entering valid data

    And Open "https://www.jumia.com.eg/"
    And user close Ad and click on Account then SignIn
    And user enter valid email"9dlf5js@gmail.com" then click Continue
    Then validate the email"9dlf5js@gmail.com" and create password"5skdlfjs409"
    And Enter firstname"Mohamed" and lastname"Magdi" and mobileNumber"01274586549" then click continue
    Then Select the gender"male" and birthdate"6""6""1998"
    And check read the terms and click continue
    Then validate account has been created with name"Mohamed"
