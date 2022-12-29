Feature: Scenarios related to notes

  Scenario: should add new note
    Given user taps add button
    And user fills title field with "Test Title"
    And user sets priority to "Low Priorities"
    And user fills description field with "Test Description"
    When user taps add new note button
    Then new note is added

  Scenario: should delete a note
    Given user creates new note with title "Title" and description "description" and priority "Low Priorities"
    And user taps more button
    And user taps Delete all button
    When user taps yes button
    Then note is deleted