@smoke
Feature: Desktop | Change password of the account

  Background:
    Given The user visits Columbia homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    And The user enters valid credentials
    And The user clicks " GİRİŞ YAP" button
    And The user clicks login button
    And The user clicks "Şifre Değiştir" button
    And The user verifies redirected to "/account/changePassword" page

  Scenario: Change password of the current customer

    #And The user closes pop-Ups
    And The user enters old, new and confirm new password
    Then The user verifies "Şifrenizi başarıyla değiştirdiniz" message
    And The user clicks login button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/?logout=true" page

  Scenario: The user enters wrong old password

    And The user enters wrong old password
    Then The user verifies "Girmiş olduğunuz parola eski parola ile uyuşmamaktadır." message
    And The user clicks login button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/?logout=true" page

  Scenario: The user enters different new and confirm new passwords

    And The user enters different passwords
    Then The user verifies "Girilen parolalar uyuşmamaktadır." message
    And The user clicks login button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/?logout=true" page
