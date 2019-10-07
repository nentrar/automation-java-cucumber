Feature: NIAM login

  Scenario: user log successfully log into NIAM
    Given user open NIAM login page
    When user enter "nokadmin" as login and "nokadmin" as password
    Then user "nokadmin" log into NIAM dashboard with success