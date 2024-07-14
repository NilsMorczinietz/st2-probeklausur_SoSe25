# Aufgabe 8: Refactoring mit ChatGPT (20 Punkte)

In dieser Aufgabe sollen Sie die Qualität einer Antwort von ChatGPT 4o zu einer Refactoring-Aufgabe 
bewerten.

## Aufgabenstellung

In `thkoeln.archilab.st2.a8.original` liegt eine Klasse `Invoice`, die eine Rechnung repräsentiert.
Der Rechnungsbetrag kann in verschiedenen Währungen angegeben werden. Die Rechnung kann
mittels mehrere `Voucher` (Gutschein) bezahlt werden, die für den Kunden der Rechnung personalisiert
sind.

Die Klasse `Invoice` hat zahlreiche Verstöße gegen Clean Code und gutes Software-Design. An ChatGPT 4o
wurde folgende Anfrage gestellt: 

> This Java file contains pretty poorly written code, I am afraid. Can you refactor it?

ChatGPT 4o hat als Antwort die neue Klasse `thkoeln.archilab.st2.a8.chatgpt.Invoice` geliefert
und folgende Antwort gegeben:

> The provided code has several issues, such as poor validation handling, repetition, and 
> lack of clarity. Below is a refactored version of the code that addresses these issues 
> by improving the structure, readability, and maintainability.
> 
> Changes and Improvements:
> - Validation Logic: Moved validation logic into separate methods (isInvalidInvoice and 
>   isInvalidVoucher) to avoid repetition and improve readability.
> - Voucher Reduction: Encapsulated the voucher reduction logic into the reduceVoucher method.
> - Improved Exception Handling: Used IllegalArgumentException for better exception handling.
> - Renamed Variables: Improved variable names for clarity (tr54LZ to purpose, am to amount, 
>   cur to currency, cust to customer).
> 
> This refactored code is more organized, readable, and maintainable.

Wie beurteilen Sie die Qualität der Antwort von ChatGPT 4o? Schreiben Sie Ihre Antwort 
unten in diese Datei.

### Hinweise

1. Für die originale `Invoice`-Klasse gibt es einen Test `InvoiceTest`. Diesen können Sie
   für die Beurteilung der Qualität der Antwort von ChatGPT 4o nutzen.


## IHRE ANTWORT:

