Feature: As a user I want to get relevant links on my image search request

  Scenario: Tags section should contain appropriate to image suggestions
    Given the user opens Yandex website
    When the user clicks on the "Картинки" menu item
    And the user chooses search by image function
    And the user uploads image "crane.jpg"
    Then at least, one tag from block contains "автокран"
