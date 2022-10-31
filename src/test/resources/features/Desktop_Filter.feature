Feature: Desktop | Filter feature

  @smoke
  Scenario: Filtering with selected options

    Given The user visits Columbia homepage
    And The user verifies redirected to homepage
    And The user navigates to "Erkek" "Yeni Gelenler" category
    When The user verifies redirected to "/erkek-yeni-gelenler" page
    And The user clicks "Alt Giyim" button
    Then The user verifies redirected to "/erkek-yeni-gelenler?defaultMinPrice=259&pageIndex=0&defaultMaxPrice=18000&lastSelectedFilter=%C3%9Cr%C3%BCn+Tipi&%C3%9Cr%C3%BCn+Tipi=61" page
    And The user clicks "Pantolon" button
    And The user verifies redirected to "/erkek-yeni-gelenler?defaultMinPrice=679&pageIndex=0&defaultMaxPrice=7500&lastSelectedFilter=%C3%9Cr%C3%BCn+Cinsi&%C3%9Cr%C3%BCn+Cinsi=132&%C3%9Cr%C3%BCn+Tipi=61" page