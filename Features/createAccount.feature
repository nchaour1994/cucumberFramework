Feature: add account
  Background: common steps
    Given user is on login page
    When user enter the url "https://www.walgreens.com/"
    Then walgreen homepage  should appears
    When user click on account button
    Then drop down should appears
    And user click on register button
    Then registration page should appears


@regression
  Scenario: create a personal account
    When user enter first name as "ahmed"
    And user enter last name as "admin"
    And user enter email as "admin@gmail.com"
    And user enter password as "test"
    And user check the box agreement
    And click on continue button
    When landing page appears
    Then close the browser

@sanity
  Scenario: create a business account
    When user enter first name as "business"
    And user enter last name as "business"
    And user enter email as "business@gmail.com"
    And user enter password as "test"
    And user check the box agreement
    And click on continue button
    When landing page appears
    Then close the browser