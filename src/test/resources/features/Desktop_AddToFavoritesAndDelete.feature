Feature: Desktop | Add to favorites and delete
  @smoke
  Scenario: The user can add to favorites and delete

    Given The user visits Columbia homepage
    And  The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials
    And The user clicks " GİRİŞ YAP" button
    And The user navigates to "Çocuk" "Ayakkabı" "Bot" category
    When The user verifies redirected to "/cocuk-ayakkabi-bot" page
#    And The user closes pop-Ups
    And The user clicks anyone product
    And The user clicks hearth button
    And The user clicks login button
    Then The user clicks "Favorilerim" button
    And The user verifies redirected to "/account/favorites" page
    When The user clicks hearth button
    And The user verifies "Favori ürün bulunmamaktadır." message
    And The user clicks login button
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to homepage
