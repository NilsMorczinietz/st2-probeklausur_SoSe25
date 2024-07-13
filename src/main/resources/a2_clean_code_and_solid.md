# Aufgabe 1: Clean Code und SOLID-Prinzipien (25 Punkte)

Der Code in dieser Aufgabenstellung verstößt gegen Clean-Code-Regeln und die SOLID-Prinzipien
"Single Responsibility Principle" und "Open/Closed Principle". Refactorn Sie den Code so, dass 
diese Prinzipien wieder eingehalten werden. Folgende Verstöße gibt es:

- CC - Meaningful Names (4x)
- SOLID - Open-Closed-Principle (Implementierungsdetails unnötig nach außen getragen) (1x)
- SOLID - Single Responsibility Principle (Code an der falschen Stelle) (2x)

Die Klassen beschreiben Rennwagen (`Car`) und Rennen (`Race`). Rennwagen registrieren
sich für Rennen. 


## Aufgabenstellung 

1. Schauen Sie sich die Klassen in `thkoeln.archilab.st2.a2` und identifizieren Sie die 
   Regelverstöße.
2. Refactorn Sie den Code, so dass die Regeln eingehalten werden. Möglicherweise ist es 
   dafür sinnvoll, neue Klassen hinzufügen, bestehende Klassen umzubenennen oder ganz 
   zu entfernen, wenn sie unnötig sind. 
3. Es gibt auch einen Test (`thkoeln.archilab.st2.a2.RaceTest`), der Ihnen hilft, die 
   das Refactoring zu überprüfen. Der Test muss natürlich mit refactored werden.

