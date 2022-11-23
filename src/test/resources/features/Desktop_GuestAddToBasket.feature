Feature: Desktop | Guest add to basket

  @smoke
  Scenario:Guest add to basket and delete product from basket
    Given The user visits Columbia homepage
    And The user verifies redirected to homepage
    And The user closes popUp
    And The user navigates to "Kadın" "Tekstil" "Yağmurluk" category
    When The user verifies redirected to "/kadin-tekstil-yagmurluk" page
    And The user closes pop-Ups
    And The user clicks any product
    And The user chooses size
    And The user clicks "SEPETE GİT" button
    And The user verifies redirected to "/basket" page
    When The user clicks "Üye Olmadan Devam Et" button
    And The user verifies redirected to "/checkout" page
    And The user clicks "Yeni Adres Ekle" button
    When The user enters valid informations for guest
    And The user clicks "Kaydet" button
    And The user clicks "Ödeme Adımına Geç" buttonn
    And The user enters invalid informations
    And The user selects 3D Secure, On Bilgilendirme and Mesafeli Satis Sozlesmesi buttons
    And The user clicks "Siparişi Tamamla" button
    And The user verifies "Kart numarası geçersizdir" message
    Then The user clicks Sepetim button
    And The user clicks "Kaldır" button
    And The user verifies "Sepetinizde ürün bulunmamaktadır." message
