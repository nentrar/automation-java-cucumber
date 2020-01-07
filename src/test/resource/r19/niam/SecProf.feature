Feature: Network Security Profile

  Scenario: Assign User to Network Security Profile
    Given user log into NIAM application with login "nokadmin" and password "nokadmin"
    And Resource Access Manager is open
    And Network Element "test" is selected from the NE Group "Linux"
    And store name "Accounts" is selected
    When Assign Network Security Profile is performed for the selected user "dupa"
    Then Network Security Profile should be assigned successfully
