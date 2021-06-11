Instalacja:
- ściągnij nową wersję intellij
- Pobierz jave w wersji 12
- Pobierz Maven w wersji 3.3.9
- Dodaj do zmiennych środowiskowych ścieżki do javy i maven MAVEN_HOME, JAVA_HOME i w Path obie ścieżki
- Pobierz Webdrivera i umieść go w C:/chromedriver.exe
- Pobierz repo z github'a

Uruchamianie:
- Otwórz folder z ruuner'ami /src/test/java/runner
- Na danym ruuner'ze kliknij prawym i uruchom przez "Run"
- Test uruchomi się zawsze w kontekście dev, aby zmienić mależy w konsoli wpisać : mvn clean test -Prc lub w innym kontekście -Pprod,-Pdev

Troubleshooting:
- W plikach z krokami "steps" należy zakomentować @after, aby pod koniec testu nie było widocznych nullPointerów
- Możliwe problemy z dodawanie cookie's na początku testu