@test
Feature: Open Google

  @test
  Scenario: Open Google
    Given Navigate to Google
#    And click on "BrowerWindows"
#    And click on "NewTab"
#    And switch to new window
#    And click on "Alert"
#    And click on "Alertbtn"
#    And close the Alert
#     And click on "Interactions"
#     And click on "Sortable"
#    And switch to frame

  @test
  Scenario: Open Google
    Given Navigate to Google
    And user copy and paste through action

  @test
  Scenario: find broken links
    Given Navigate to Google
    And find broken links


  @test1
  Scenario: Initiate browserstack
    Given Open browserStack
    |site|next|
    |kcom|p   |

