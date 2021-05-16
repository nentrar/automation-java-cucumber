Feature: Sekretna Biblioteczka wordpress dashboard is working without any problems occured

  Scenario: user log successfully log into wordpress dashboard
    Given user open Sekretna Biblioteczka login page
    When user enter "test" as login and "test" as password
    Then into Sekretna Biblioteczka wordpress dashboard with success