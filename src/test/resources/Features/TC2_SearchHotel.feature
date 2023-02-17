@SearchHotel
Feature: verify adactin search hotels details

  Scenario Outline: verify adactinhotalapp login with valid credentials then search hotel and generate success message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should search hotel using "<location>","<hotels>","<roomType>","<roomNos>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then user should verify after search hotel the success message "Select Hotel"

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       | 2 - Two      |

  Scenario Outline: verify adactinhotalapp login with valid credentials then search hotel and generate success message by entering mandatory fields only
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should perform search hotel by entering mandatory fields only using "<location>","<roomNos>","<checkIn>","<checkOut>" and "<adultsPerRoom>"
    Then user should verify after search hotel the success message "Select Hotel"

    Examples: 
      | userName         | password  | location | roomNos | checkIn    | checkOut   | adultsPerRoom |
      | gugansubramaniam | gugan@009 | Sydney   | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       |

  Scenario Outline: verify adactinhotalapp login with valid credentials then enter Invalid dates in search page and generate error message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should search hotel using "<location>","<hotels>","<roomType>","<roomNos>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then user should verify after entering invalid date the Error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2024 | 14/12/2022 | 2 - Two       | 2 - Two      |

  Scenario Outline: verify adactinhotalapp login with valid credentials then click search button without entering any fields and generate Error message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should select search button
    Then user should verify after search hotel the Error message "Please Select a Location"

    Examples: 
      | userName         | password  |
      | gugansubramaniam | gugan@009 |
