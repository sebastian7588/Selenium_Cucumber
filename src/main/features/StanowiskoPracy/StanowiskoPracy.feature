Feature: Stanowisko Pracy

  @StanowiskoPracy
  Scenario: Wyszukanie stanowiska pracy
    Given Użytkownik jest na stronie kariera
    And Użytkownik wybiera stanowisko pracy IT w lokalizacji mazowieckie i wyszukuje "Tester Aplikacji Backend"
    When Użytkownik Wybiera pierwszą ofertę pracy i aplikuje
    Then Użytkownik wypełnia formularz i dodaje CV
      | Imię   | Nazwisko  | E-mail           | Telefon   | Miasto   |
      | Tester | Testowski | tester@tester.pl | 123123123 | Warszawa |