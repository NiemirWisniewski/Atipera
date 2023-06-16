Github API - Lista repozytoriów
Ta aplikacja to przykładowe rozwiązanie zadania rekrutacyjnego polegającego na implementacji REST API, które pobiera informacje o repozytoriach użytkownika z serwisu GitHub.

Instalacja
Sklonuj to repozytorium lub pobierz pliki źródłowe.

Przejdź do katalogu projektu.

Uruchom aplikację.

Użycie
REST API jest dostępne pod adresem http://localhost:8080/api.

Pobieranie informacji o repozytoriach
Endpoint: GET /api/repositories/{username}

Obsługa błędów
Gdy użytkownik nie istnieje, otrzymasz odpowiedź HTTP 404 z treścią błędu w formacie JSON.

Gdy nagłówek Accept nie jest ustawiony na application/json, otrzymasz odpowiedź HTTP 406 z treścią błędu w formacie JSON.

Kontrybucje
Chętnie przyjmiemy kontrybucje do tego projektu. Jeśli masz propozycje na udoskonalenie lub naprawę błędów, utwórz pull request lub zgłoś problem w sekcji "Issues".

Licencja
Ten projekt jest licencjonowany na mocy licencji MIT License.