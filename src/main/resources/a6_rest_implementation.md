# Aufgabe 6: REST-Implementation (15 Punkte)

In dieser Aufgabe sollen Sie ein Teil eines **REST-API** implementieren. Der Kontext 
der Software ist derselbe wie in Aufgabe 5. 

## Aufgabenstellung

Sie sollen die Controller-Methoden für die Endpoints 1 und 2 implementieren. Im Package 
`thkoeln.archilab.st2.a6` finden Sie Klassen, um die ersten beiden Endpoints zu implementieren.

1. Daten eines `Doctors` abfragen (ohne Ausgabe der `AppointmentSlots`)
2. Spezialisierung (`specialization`) eines `Doctor` ändern


### Hinweise

1. Der RestController existiert schon, ist aber noch nicht vollständig implementiert. Sie
   müssen ihn mit den Controller-Methoden für die Endpoints 1 und 2 vervollständigen. 
2. Die Domain-Klassen und der ApplicationService sind schon vorhanden, auch die DTO-Klasse
   `DoctorDTO` ist da. 
3. Was noch fehlt, ist das Mapping zwischen `Doctor` und `DoctorDTO`. Es ist in Ordnung,
   wenn Sie das im Controller machen.
4. Es gibt einen Test `thkoeln.archilab.st2.a6.DoctorRESTTest`, der grün sein sollte, wenn
   Ihre Implementation da ist.
5. Überlegen Sie sich, in welcher Form Sie die Error-Returncodes zurückgeben wollen - das
   gibt es mehrere Möglichkeiten.
6. Sie können auch für unvollständige oder sogar nicht compilierende Lösungen Punkte
   erhalten. Versuchen Sie also, so weit wie möglich zu kommen. Die volle Punktzahl
   gibt es aber nur für eine vollständige, compilierende Lösung, bei der beide Tests
    grün sind.

