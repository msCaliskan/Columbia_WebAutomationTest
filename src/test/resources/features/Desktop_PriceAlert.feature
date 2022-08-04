Feature: Desktop | Price Alert

  @smoke
  Scenario: The user can select to PriceAlert and delete

    Given The user visits Columbia homepage
    And  The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials
    And The user clicks " GİRİŞ YAP" button
    And The user navigates to "Çocuk" "Ayakkabı" "Bot" category
    When The user verifies redirected to "/cocuk-ayakkabi-bot" page
#    And The user closes pop-Ups
    And The user clicks anyone product
    Then The user clicks " Fiyatı Düşünce Haber Ver" button
    And The user enters valid price
    Then The user clicks "Kaydet" button
    And The user clicks login button
    Then The user clicks "Fiyat Alarmlarım" button
    And The user verifies redirected to "/account/priceSubscription" page
    And The user clicks "Sil" button
    And The user verifies "Fiyat alarmı bulunmamaktadır." message
    And The user clicks login button
    Then The user clicks "Çıkış Yap" button
    And The user verifies redirected to homepage
