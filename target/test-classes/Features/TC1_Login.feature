@Login
Feature: verify adactin login details

  Scenario Outline: verify adactinhotalapp login with valid credentials
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"

    Examples: 
      | userName         | password  |
      | gugansubramaniam | gugan@009 |

  Scenario Outline: verify adactinhotalapp login with valid credentials using EnterKey
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>" by pressing EnterKey
    Then user should verify after login success message "Hello gugansubramaniam!"

    Examples: 
      | userName         | password  |
      | gugansubramaniam | gugan@009 |

  Scenario Outline: verify adactinhotalapp login with Invalid credentials
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login Error message "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName | password  |
      | gugan    | gugan@123 |
