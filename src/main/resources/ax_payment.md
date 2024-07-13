Es ist ein kleines Beispiel (4 Klassen, 200 Zeilen Code insgesamt). Es geht um folgendes:

* Wir betrachten das Payment-Modul eines Webshops. Der Shop operiert in Deutschland, NL, Belgien, Österreich, Dänemark und Schweden. Er unterstützt also die Währungen EUR, DKR und SEK.
* Es gibt Kunden, die Rechnungen (Invoice) bekommen, für bestellte Waren. Kunden haben nur Vor- und Nachname sowie eine Email. Es gibt noch Firmenkunden, die nur einen Namen und eine Email haben.
* Umtausch auf Kulanz wird durch die Ausgabe von Gutscheinen (Voucher) geregelt. Diese sind personalisiert. Man kann Bestellungen mit solchen Vouchers bezahlen. Man kann die Vouchers auch mehrmals einsetzen, so lange, bis der Geldbetrag darauf verbraucht ist.

Sie sollen folgendes tun:

1. Wenden Sie Clean-Code-Regeln an.
1. Nutzen Sie die SOLID-Prinzipien, um den Code zu verbessern.
1. Implementieren Sie Domain Primitives.
1. Identifizieren Sie Entities, Value Objects und Aggregates.
1. Implementieren Sie dies mit JPA.
1. Spezifizieren Sie ein REST-API.
1. Implementieren Sie das REST-API.
1. Die nachfolgenden Aufgaben leiten Sie durch den Prozess. Die Reihenfolge ist ein kleines bisschen abgewandelt, damit es einfacher und nachvollziehbarer ist.


## E1) Clean Code - Meaningful Names

Sorgen Sie für "Meaningful Names", damit der Code ein bisschen weniger wirr ist.


## E2) Domain Primitives

Man kann im Code mindestens drei Domain Primitives finden. Implementieren Sie diese und sorgen Sie für ein entsprechendes Refactoring im Code.


## E3) Annotieren Sie die Verletzungen der folgenden Clean-Code-Regeln und SOLID-Prinzipien im Code

### Lösung E3

Machen Sie bitte in den Code, wie er sich jetzt darstellt, einfach mal "Marker" (als Kommentare) der folgenden Form, um Verletzungen von Clean-Code-Regeln und SOLID-Prinzipien anzuzeigen.

``` Java
//**  CC - no side effects
//**  CC - keep your methods small
//**  CC - proper error handling
//**  SOLID - single-responsibility-principle
//**  SOLID - open-closed-principle
//**  SOLID - liskov-substitution-principle
```


## E5) Identifizieren Sie Entities, Value Objects und Aggregates

Erstmal würde das als logisches Datenmodell genügen, in dem E, VO und AR als Annotationen drin sind, und die Aggregates umkringelt sind. Attribute brauchen nicht dargestellt zu werden, VOs sollten als eigene Klassen abgebildet werden.


## E6) Setzen Sie die Struktur aus E5 entsprechend mit Spring Data JPA persistent um


## E7) Spezifizieren Sie REST-Endpoints


| Aufgabe                                                              | Verb | Endpoint |
|----------------------------------------------------------------------|------|----------|
| Lege Kunde neu an                                                    |      |          |
| Hole Liste aller Kunden                                              |      |          |
| Zeige einen Kunden an                                                |      |          |
| Ändere die Email eines Kunden                                        |      |          |
| Lege eine Rechnung neu an                                            |      |          |
| Zeige eine bestimmte Rechnung an                                     |      |          |
| Suche alle Rechnungen für einen Kunden                               |      |          |
| Lösche eine Rechnung                                                 |      |          |
| Lege einen Voucher neu an                                            |      |          |
| Finde Vouchers, die für einen bestimmten Zweck eingelöst wurden      |      |          |
| Finde alle Vouchers einer Währung und >0 Geld drauf für einen Kunden |      |          |
| Bezahle Rechnung mit einem Voucher                                   |      |          |

(Beim letzten Endpoint muss eine Beziehung namens "vouchersForPayment" von Invoice zu Voucher ergänzt werden)


## E8) Implementieren Sie obigen Endpoints



