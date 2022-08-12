@smoke
Feature: Desktop | Login with valid and invalid credentials

  Background:
    Given The user visits Columbia homepage
    And The user verifies redirected to homepage
    And The user clicks login button

  Scenario: Login with valid credentials
    And The user enters valid credentials
    And The user clicks " GİRİŞ YAP" button
    When The user clicks login button
    And The user clicks "Üyelik Bilgilerim" button
    And The user verifies redirected to "/account/info" page
    #And The user closes pop-Ups
    And The user checks "Musa", "Çalışkan", "musainveon@gmail.com" and "0(507) 500 29 20" informations
    And The user clicks login button
    And The user clicks "Çıkış Yap" button
    And The user verifies redirected to "/?logout=true" page

  Scenario: The user must not be able to login with invalid email
    And The user enters invalid email
    And The user clicks " GİRİŞ YAP" button
    And The user verifies "E-posta adresiniz ve/veya şifreniz hatalıdır." message

  Scenario: The user must not be able to login with invalid password
    And The user enters invalid password
    And The user clicks " GİRİŞ YAP" button
    And The user verifies "E-posta adresiniz ve/veya şifreniz hatalıdır." message
