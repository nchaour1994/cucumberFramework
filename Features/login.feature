Feature: login

@sanity
  Scenario: check if it is successful

    Given user is on login page
    When user enters user as "john1897@gmail.com" and pass as "John1897test"
    And click on login button
    Then user is navigated to homepage
    Then user should be on "Walgreens: Pharmacy, Health & Wellness, Photo & More for You"
@regression
  Scenario Outline: tdd

    Given user is on login page
    When user enters user as "<email>" and pass as "<pass>"
    And click on login button
    Then user is navigated to homepage
    Then user should be on "Walgreens: Pharmacy, Health & Wellness, Photo & More for You"

    Examples:
    |email|pass|
    |   ahmed@gmail.com  |  tests  |
    |  nabil@gmail.com   | testss   |


