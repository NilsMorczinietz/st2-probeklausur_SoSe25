# Aufgabe 7: Unit Tests (20 Punkte)

In dieser Aufgabe sollen Sie Unit Tests für ein neues Feature schreiben. Es kommt darauf an, ...
- dass Sie den Code für das Feature in sinnvolle Teile (Methoden) aufteilen, die jeweils an 
  der richtigen Stelle (so "niedrig" wie möglich in der Schichten-Hierarchie) angesiedelt sind,
- und dass Sie für jede der neuen Methoden jeweils einen oder mehrere passende Tests schreiben.

## Aufgabenstellung

In `thkoeln.archilab.st2.a7` finden Sie einige Klassen, die Lieferungen (`Shipment`) 
beschreiben. Ein `Shipment` hat einen Kunden-Namen (`customerName`) und ein Boole'sches
Flag, ob die Lieferung innerhalb der EU stattfindet. Außerdem gibt es im `Shipment`
eine Liste von `Container`-Objekten, in denen die eigentliche Ware liegt. Diese `Container`
haben eine Länge/Breite/Höhe (jeweils in m). 

Sie sollen jetzt ein Feature hinzufügen, das die Gesamtrechnung für einen Kunden (d.h.
über alle Lieferungen hinweg) berechnet. Die Rechnung wird wie folgt ermittelt:
- Jeder m3 Volumen, die die Container insgesamt haben, kostet 800,-- EUR. 
- Für jeden Container fallen zusätzlich 200,-- EUR Verladepauschale an. 
- Jede Lieferung kostet zusätzlich pauschal 500,-- EUR Zoll-Pauschale, wenn es nach 
  außerhalb der EU geht.

Sie können die EUR-Beträge einfach als `Float` behandeln, genauso wie das auch bei
den Maßen der Container der Fall ist.


### Hinweise

1. Überlegen Sie sich vorher kurz, welche Methoden Sie wo brauchen.
2. Gehen Sie strukturiert vor, von der "untersten" zur "obersten" Klasse in der Aufrufhierarchie.
3. Schreiben Sie Methode und zugehörige Tests am besten Hand in Hand. 
