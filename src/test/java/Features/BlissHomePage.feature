Feature: This feature is to test the functionality of Bliss Home page and Services
  Scenario: This scenario is to test the particular service is displayed and user able to select
    Given User is on Bliss Software solutions Home page
    When User selects Services Option
    Then User find the services "OTT Broadcast" offered by Bliss
    And User can select "OTT Broadcast" service
