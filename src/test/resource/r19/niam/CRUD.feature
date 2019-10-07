Feature: CRUD operations



    Scenario: user creates network account credentials
        Given user open NIAM login page
        And user enter "nokadmin" as login and "nokadmin" as password
        And user "nokadmin" log into NIAM dashboard with success
        When Resource Access Manager is open
        And NE Group "Linux" is open and adapter "test" is selected
        Then user creates Network Account Credentials for adapter "test" with following parameters
        | Login ID  | Password  |
        | test_user | password1 |
        And create new account credential "test_user" in "Accounts" databases is confirmed

    Scenario: user updates password manually in network account credentials
        Given user open NIAM login page
        And user enter "nokadmin" as login and "nokadmin" as password
        And user "nokadmin" log into NIAM dashboard with success
        When Resource Access Manager is open
        And NE Group "Linux" is open and adapter "test" is selected
        And store name "Accounts" is selected
        Then password for the credential "test_user" is changed to "new_password" with success

    Scenario: user delete network account credentials
        Given user open NIAM login page
        And user enter "nokadmin" as login and "nokadmin" as password
        And user "nokadmin" log into NIAM dashboard with success
        When Resource Access Manager is open
        And NE Group "Linux" is open and adapter "test" is selected
        Then from network element "test" a credential "test_user" is deleted with success







