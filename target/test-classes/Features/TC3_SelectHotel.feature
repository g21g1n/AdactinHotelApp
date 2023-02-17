@SelectHotel
Feature: verify adactin hotel select hotel details

  Scenario Outline: verify adactinhotalapp login with valid credentials then select hotel and generate success message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should search hotel using "<location>","<hotels>","<roomType>","<roomNos>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then user should verify after search hotel the success message "Select Hotel"
    And user should perform select hotel then click continue button
    Then user should verify after select hotel the success message "Book A Hotel"

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       | 2 - Two      |

  Scenario Outline: verify adactinhotalapp login with valid credentials and click continue button without selecting hotel and generate Error message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should search hotel using "<location>","<hotels>","<roomType>","<roomNos>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then user should verify after search hotel the success message "Select Hotel"
    And user should  click continue button without selecting any hotel
    Then user should verify after clicking continue Error message "Please Select a Hotel"

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       | 2 - Two      |
