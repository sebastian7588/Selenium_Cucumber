Feature: Stan paczki

  @StanPaczki
  Scenario Outline: Sprawdzenie Stanu paczki
    Given Użytkownik jest na stronie głównej
    When Użytkownik podaje numer paczki "<id>" i klika znajdź
    Then Paczka została znaleźiona, a status paczki jest "GOTOWY DO ODBIORU"
    # Asercja statusu nie jest możliwa, ponieważ paczki nieistnieją

    Examples:
      | id                       |
      | 680175798174312027659619 |
      | 605080798151518110154556 |
      | 505080798151518110154556 |