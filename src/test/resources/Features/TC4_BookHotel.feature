@BookHotel
Feature: verify adactin booking hotel details

  Scenario Outline: verify adactinhotalapp login with valid credentials then book hotel and generate success message
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
      | 2345654565475635 | American Express | June        |       2022 |   333 |
      | 7676545434543454 | Master Card      | July        |       2022 |   303 |
      | 2324565678786756 | VISA             | December    |       2022 |   143 |
    Then user should verify after booking hotel the success message "Booking Confirmation" and save generated orderid

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom | firstName | lastName    | billingAddress |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       | 2 - Two      | gugan     | subramaniam | omr,chennai    |

  Scenario Outline: verify adactinhotalapp login with valid credentials then book hotel without entering any fields and generate Error message
    Given user is on adactinhotelapp page
    When user should perform login using "<userName>","<password>"
    Then user should verify after login success message "Hello gugansubramaniam!"
    And user should search hotel using "<location>","<hotels>","<roomType>","<roomNos>","<checkIn>","<checkOut>","<adultsPerRoom>" and "<childPerRoom>"
    Then user should verify after search hotel the success message "Select Hotel"
    And user should perform select hotel then click continue button
    Then user should verify after select hotel the success message "Book A Hotel"
    And user should perform book hotel without entering any fields
    Then user should verify after clicking book now Error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName         | password  | location | hotels      | roomType | roomNos | checkIn    | checkOut   | adultsPerRoom | childPerRoom |
      | gugansubramaniam | gugan@009 | Sydney   | Hotel Creek | Standard | 2 - Two | 13/12/2022 | 14/12/2022 | 2 - Two       | 2 - Two      |
