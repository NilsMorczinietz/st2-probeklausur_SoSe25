# Aufgabe 3: Zykelfreiheit mit Hilfe des Dependency Inversion Principles (50 Punkte)

Der Code in dieser Aufgabenstellung enthält Zykel. Diese sind entweder unnötig, d.h. lassen
sich durch einfache Refactorings entfernen, oder sie sind in der Fachlichkeit angesiedelt. 
Im letzteren Fall können Sie das Dependency Inversion Principle anwenden, um die Zykel zu
entfernen.

![a3_domain_model.png](a3_domain_model.png)

Der Code implementiert ein einfaches Campus-Management-System. Studierende (`Student`)
können sich für Kurse (`Course`) anmelden. Für jeden Kurs kann die durchschnittliche 
Semesteranzahl der Teilnehmenden berechnet werden. Für die Studierenden wiederum
wird ECTS-Last berechnet.

Es gibt als Hilfestellung zwei Tests unter `thkoeln.archilab.st2.a3`: 
- `StudentTest` testet die beschriebene Business-Logik (oberflächlich). Dieser Test ist
  jetzt grün. Sie können ihn nutzen, um sicherzustellen, dass die Business-Logik beim 
  Refactoring korrekt bleibt.
- `CycleTest` testet auf Zykelfreiheit. Dieser Test ist jetzt nicht grün; durch Ihr
  Refactoring sollte er grün werden. 


## Aufgabenstellung 

1. Schauen Sie sich die Klassen in `thkoeln.archilab.st2.a3` und identifizieren Sie die 
   Gründe für die Zykel.
2. Refactorn Sie den Code, so dass er keine Zykelmehr enthält. 
   - Das gegebene Domain-Model darf dabei nicht verändert werden (sprich: die 
     gewünschten Abhängigkeits-Richtungen liegen fest)
3. Die Tests sind nur Hilfestellung, bewertet wird der Code. 

