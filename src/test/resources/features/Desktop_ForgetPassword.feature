Feature: Desktop | Forget Password - The user tries to send forget password email

  @smoke
  Scenario: The user tries to send an email with empty inputs
    Given The user visits Columbia homepage
    And The user verifies redirected to homepage
    And The user clicks login button
    And The user clicks "Şifremi Unuttum" button
    And The user verifies redirected to "/password/recovery/forgot" page
    And The user closes pop-Ups
    Then The user clicks Şifremi Sıfırla button
    And The user verifies "Email alanı zorunludur" message
    And The user enters forget password email adress
    And The user clicks Şifremi Sıfırla button
    Then The user verifies "Şifrenizi yenilemek için gerekli link email adresinize yollanmıştır. Lütfen emailinizi kontrol ediniz" message