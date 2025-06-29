# ST2 Probeklausur (Typische Klausuraufgaben in einem einzigen Repo)

Diese Probeklausur ist eine Art "Selbst-Test" für die Klausur in Softwaretechnik 2. Sie enthält
Aufgaben, die in dieser Art und in diesem Umfang in der tatsächlichen Klausur vorkommen könnten.

Dieses Repo ist mit Labels versehen, um Klausur-Aufgaben früherer Semester anschauen zu können. 
Das aktuelle Semester ist immer auf dem letzten Commit des `main`-Branches zu finden. (Nach 
einem `git clone ...`-Kommando hat man automatisch das letzte Commit. Andernfalls kann man auf 
das letzte Commit durch das Kommando `git checkout main` wechseln. 

Folgende Semester können über Git-Tags zugegriffen werden: 
- SoSe 2024: `git checkout sose2024`


## Hinweise

Diese Sammlung ist deutlich länger als eine echte Klausur. Bei einer echten Klausur
werden einige Aufgabenarten ausgewählt, so dass man insgesamt auf 120 Minuten Netto-Bearbeitungszeit 
kommt. Diese Probeklausur hier ist etwas über 3h lang. Die Anzahl der Punkte an den einzelnen 
Aufgaben entspricht etwa der Anzahl Minuten, die man für die Bearbeitung brauchen sollte. 


### Bearbeitung

Es ist sinnvoll, diese Probeklausur auch unter Klausurbedingungen zu bearbeiten. Das bedeutet:
am besten ungestört am Stück. Hilfreich kann ein Timer sein, der die eigene Bearbeitungszeit
stoppt. Dann weiß man, wo man noch ggfs. etwas besser vorbereitet oder einfach nur "schneller" 
werden muss.

Nicht alle Aufgaben sind gleich schwer, und nicht alles beherrschen Sie gleich gut. Schauen
Sie also am Anfang einmal über alle Aufgaben drüber und bearbeiten sie in der Reihenfolge, die
Ihnen am besten liegt.


### Disclaimer

* Diese Probeklausur versucht, den Stoff der Vorlesung Softwaretechnik 2 abzudecken. Es gibt aber
  **keine Garantie auf Vollständigkeit**. Es kann sein, dass die echten Klausur Aufgaben enthalten 
  wird, die in dieser Probeklausur nicht oder in anderer Form und Länge vorkommen. Dies berechtigt nicht
  zu Einsprüchen gegen die ST2-Klausur. 
* Referenz für die ST2-Klausur sind die Workshops der Veranstaltung, die Inhalte des Praktikums 
  und die Veranstaltungsunterlagen inklusive der Videos.
* Diese Klausur wird im jeweils abschließenden ST2-Workshop des Semesters "probegeschrieben" und
  dann grob besprochen. In diesem Workshop kann man Fragen dazu klären. Darüber hinaus gibt es
  keine Musterlösung.
* Zu einigen der Aufgaben gibt es Tests, zu anderen nicht (das hängt von der Art der Aufgabe ab). 
  In der Klausur werden wir aber immer den Code bewerten, nicht die Tests (anders als im 
  Praktikum!). Die Tests sind also nur eine Hilfestellung für Sie während der Bearbeitung.
* In der echten Klausur wird es keine aufeinander aufbauenden Aufgaben geben. Damit hat man zwar
  einen "Kontextwechsel" für jede neue Aufgabe, aber man kann die Aufgaben völlig unabhängig 
  voneinander bearbeiten. 
  - In dieser Probeklausur wird dies (aus Aufwandsgründen) nicht konsequent umgesetzt. 
    D.h. es können sich punktuell Kontexte überschneiden oder wiederholen. Diese Stellen 
    sind aber gekennzeichnet.
* Diese Probeklausur kann aus Zeitgründen nicht so rigoros getestet werden wie die echte Klausur.
  Wenn Sie Unklarheiten oder missverständliche Formulierungen finden, melden Sie per Mail oder
  per Discord bei uns, damit wir das korrigieren können.


## Aufgabenstellungen

Die Aufgabenstellungen zu den einzelnen Aufgaben finden Sie in `src/main/resources` (jeweils in
eigenen Markdown-Files):

* [Aufgabe 1: DDD-Konventionen und Aggregates (15 Punkte)](./src/main/resources/a1_ddd_conventions_and_aggregates.md)
* [Aufgabe 2: Clean Code und SOLID-Prinzipien (25 Punkte)](./src/main/resources/a2_clean_code_and_solid.md)
* [Aufgabe 3: Zykelfreiheit mit Hilfe des Dependency Inversion Principles (50 Punkte)](./src/main/resources/a3_dip_zykelfreiheit.md)
* [Aufgabe 4: Domain Primitives (25 Punkte)](./src/main/resources/a4_domain_primitives.md)
* [Aufgabe 5: REST-Spezifikation (15 Punkte)](./src/main/resources/a5_rest_spezifikation.md)
* [Aufgabe 6: REST-Implementation (15 Punkte)](./src/main/resources/a6_rest_implementation.md)
* [Aufgabe 7: Unit Tests (20 Punkte)](./src/main/resources/a7_unit_tests.md)
* [Aufgabe 8: Refactoring mit ChatGPT (20 Punkte)](./src/main/resources/a8_chatgpt_refactoring.md)
