Feature: Audit contains scenarios related to Network Snapshot and Gold Standard operations

  Scenario: User view network snapshot
    Given user open NIAM login page
    And user enter "nokadmin" as login and "nokadmin" as password
    And user "nokadmin" log into NIAM dashboard with success
    When Network Snapshot Browser is open
    And Network Element "test" is selected from the NE Group "Linux"
    Then Network Snapshot is taken from Network Element "test" of NE Group "Linux"

  Scenario: User creates Gold Standard from Network Element
    Given user open NACM login page
    And user enter "nokadmin" as login and "nokadmin" as password
    And user "nokadmin" log into NIAM dashboard with success
    When Network is open
    And Network Element "test" is selected
    Then Gold Standard "test-GS" is created from network element "test"
    And Gold Standard operation is confirmed
    And application is closed


  Scenario: User assign gold standard to Network Element
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Gold Standards section is open
    Then Gold Standard "test-GS" is assigned to Network Element "test"
    And assigning gold standard to network element "test-GS" is confirmed
     And application is closed

  Scenario: User Run Audit against Network Snapshot
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network is open
    And Network Element "test" is selected
    When Audit operation is executed for network element "test"
    Then Audit Completion has been verified


  Scenario: User run audit and reconcile is executed

    To execute this scenario properly one need to make an anomaly on network element and set MIN in Gold Standard to automation.

    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network is open
    When Network Element "test" is selected from the NE Group "Linux"
    And Audit operation is executed for network element "test" with retrival
    And audit discrepancies should be shown
    Then Audit operation is executed for network element "test" with retrival
    And audit discrepancies should not be shown
