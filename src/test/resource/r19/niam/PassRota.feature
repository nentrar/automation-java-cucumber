Feature: Password Rotation with Schedule
  Scenario: Perform Password Rotation with success
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Secure Access Scheduler is open
    When user creates new Password Rotation Schedule with following parameters
    | Name          | Start Hour  | Start Minute  | Start Clock | Status      | Network Element | NE Group |
    | test-schedule | 11          | 20            | AM          | Enabled     | test            | Linux    |
    Then Password Rotation Schedule "test-schedule" is performed within the time set with success