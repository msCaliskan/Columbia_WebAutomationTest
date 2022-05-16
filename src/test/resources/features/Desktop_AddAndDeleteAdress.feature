Feature: Desktop | The user adds new adress and delete

  @smoke
  Scenario: Add new adress and delete

    Given The user visits Columbia homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    When The user enters valid credentials
    And The user clicks " GİRİŞ YAP" button
    And The user clicks login button
    Then The user clicks "Adreslerim" button
    And The user verifies redirected to "/account/addresses" page
    #And The user closes pop-Ups
    And The user verifies "Teslimat adresi bulunmamaktadır." message
    When The user clicks "Yeni Adres Ekle" button
    And The user enters valid informations
    And The user clicks "Kaydet" button
    And The user clicks "Sil" button
    And  The user clicks "EVET" button
    And The user verifies "Teslimat adresi bulunmamaktadır." message
    And The user clicks login button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to homepage
