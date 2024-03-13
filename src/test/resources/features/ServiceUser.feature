# language: en

Feature:User Service API Consumption


  @UserCreation
  Scenario:  Successful message from the create user service
   When the user sends a request to the create user service
      |username|Viviana|
      |password|Mora   |
    Then The user should see a successful response from the user creation

  @GetUser
  Scenario:  Get user by user name Success Message
    When the user sends a request to get user by user name
      |username|theUser|
    Then The user should see a successful response user by user name

  @DeletUser
  Scenario:  Delete user by user name Success Message
    When the user sends a request to delete user by user name
      |username|theUser|
    Then The user should see a successful response delete by user name
