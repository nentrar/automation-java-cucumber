Feature: Fingerprint verify configuration between Netguard application and Network Element

  Scenario: User view network snapshot
    Given user log into NACM application with login "nokadmin" and password "nokadmin"
    And Network Access is open
    When Verify Configuration on Network Element "test" is performed
    Then Fingerprint operation should finish in success


