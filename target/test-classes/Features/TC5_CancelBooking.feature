@CancelBooking
Feature: verify adactin cancel hotel booking details

  Scenario Outline: verify adactinhotalapp login with valid credentials then cancel hotel booking and generate success message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should search hotel using "<location>","<hotels>","<roomType>","<roomNos>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then user should verify after search hotel the success message "Select Hotel"
    And user should perform select hotel then click continue button
    Then user should verify after select hotel the success message "Book A Hotel"
    And user should perform booking hotel using "<firstName>","<lastName>" and "<billingAddress>"
      | creditCardNo     | creditCardType   | expiryMonth | expiryYear | cvvNo |
      | 3232456453425345 | VISA             | January     |       2022 |   343 |
      | 2345654565475635 | American Express | June        |       2024 |   333 |
      | 7676545434543454 | Master Card      | July        |       2029 |   303 |
      | 2324565678786756 | VISA             | December    |       2025 |   143 |
    Then user should verify after booking hotel the success message "Booking Confirmation" and save generated orderid
    And user should cancel generated orderid
    Then user should verify after cancel orderid the success message "The booking has been cancelled."

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom | firstName | lastName    | billingAddress |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       | 2 - Two      | gugan     | subramaniam | omr,chennai    |

  Scenario Outline: verify adactinhotalapp login with valid credentials then cancel existing orderid and generate success message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should cancel exixting order id using "<orderid>"
    Then user should verify after cancel orderid the success message "The booking has been cancelled."

    Examples: 
      | userName         | password  | orderid    |
      | gugansubramaniam | gugan@009 | GJJ29YP14I |
