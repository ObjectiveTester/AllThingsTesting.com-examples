Feature: Maths Test

 @smoketest
  Scenario: Multiplication
    Given I have 2 and 6
    When I multiply the values
    Then The result should be 12

  @smoketest
  Scenario: Addition
    Given I have 2 and 6
    When I add the values
    Then The result should be 8

  Scenario: Addition Table
    Given I add a series of values
    | 1|  1|  2|
    | 1|  2|  3|
    |99|  1|100|

  Scenario: Multiplication Table
    When I multiply a series of values
    |first|second|result| 
    |    1|     1|     1|
    |    2|     3|     6|
    |    4|     5|    20|
    |    6|     7|    42|
    |    8|     9|    72|
