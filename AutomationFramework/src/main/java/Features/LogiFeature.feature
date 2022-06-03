Feature: Login feature

  Scenario Outline: Login into the application using invalid credientials
    Given User is at the Home Page
    And Navigate to LogIn Page
    When User enter invalid "<UserName>" and "<Password>"
    And  Click on the LogIn button
    Then Error message should be displayed

    Examples:
      | UserName                  | Password |
      |1235                       |reddy     |
      | manovikas26@gmail.com     |vikas7474 |
      | manovikasreddy26@gmail.com|Test@123  |

  @ValidTest
  Scenario: Login into the application
    Given User is at the Home Page
    And Navigate to LogIn Page
    When User enter UserName and Password
    And Click on the LogIn button
