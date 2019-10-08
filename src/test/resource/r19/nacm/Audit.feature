Feature: Audit contains scenarios related to Network Snapshot and Gold Standard operations

  Scenario: User view network snapshot
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network section is open
    When Network Element is selected
    And network snapshot has started
    Then network snapshot operation is verified


  Scenario: User create gold standard from network element
     Given user log into NACM application with login "nokadmin" and password "nokadmin"
     And Network section is open
     When Network Element is selected
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
    And Network section is open
    When Network Element is selected
    Then Audit operation is executed
    And Audit Completion has been verified


  Scenario: User run audit and reconcile is executed
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network section is open
    And change is made on the network element to emulate anomaly
    When Network Element is selected
    And Audit operation is executed
    And audit discrepancies should be shown
    Then automatic reconcile should be executed
    And anomaly should be corrected


