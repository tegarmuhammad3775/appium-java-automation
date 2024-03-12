Feature: Register

  @register
  Scenario: Success Register
    Given Membuka Aplikasi
    When Input Data
    And Klik Lanjutkan
    Then User di homepage
