Feature: CRUD operations



    Scenario: user creates network account credentials
        Given user open NIAM login page
        And user enter "nokadmin" as login and "nokadmin" as password
        And user "nokadmin" log into NIAM dashboard with success
        When Resource Access Manager is open
        And tested adapter is selected
        Then user creates Network Account Credentials with following parameters
        | Login ID  | Password  | Store Name | Category | Security Profile |
        | test_user | password1 | Accounts   | nokadmin | default          |
        And create new account credentials is confirmed

    Scenario: user updates password manually in network account credentials
        Given user open NIAM login page
        And user enter "nokadmin" as login and "nokadmin" as password
        And user "nokadmin" log into NIAM dashboard with success
        When Resource Access Manager is open
        And tested adapter is selected
        And store name "Accounts" is selected
        Then password for the credential "test_user" is changed to "new_password"
        And update credentials is confirmed

    Scenario: user delete network account credentials
        Given user open NIAM login page
        And user enter "nokadmin" as login and "nokadmin" as password
        And user "nokadmin" log into NIAM dashboard with success
        When Resource Access Manager is open
        And tested adapter is selected
        Then selected credential "test_user" is deleted
        And delete of credentials is confirmed






