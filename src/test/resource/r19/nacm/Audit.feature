Feature: Audit contains scenarios related to Network Snapshot and Gold Standard operations

  Scenario: User view network snapshot
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network Snapshot Browser is open
    When Network Element "test" is selected from the NE Group "Linux"
    Then Network Snapshot is taken from Network Element "test" of NE Group "Linux"

  Scenario: User create gold standard from network element
     Given user log into NACM application with login "nokadmin" and password "nokadmin"
     And Network is open
     When Network Element Group "Linux" is selected
     Then Gold Standard is created from network element
     And Gold Standard operation is confirmed


  Scenario: User assign gold standard to Network Element
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Gold Standards section is open
    When Gold Standard is selected
    Then Gold Standard is assigned to Network Element
    And assigning gold standard operation is confirmed


  Scenario: User run audit against network snapshot
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network Snapshot Browser is open
    When Network Element "test" is selected from the NE Group "Linux"
    Then Audit operation is executed
    And Audit Completion has been verified


  Scenario: User run audit and reconcile is executed
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network is open
    And change is made on the network element to emulate anomaly
    When Network Element "test" is selected from the NE Group "Linux"
    And Audit operation is executed
    And audit discrepancies should be shown
    Then automatic reconcile should be executed
    And anomaly should be corrected


