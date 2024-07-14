# Aufgabe 4: Domain Primitives (25 Punkte)

Für die Klasse `thkoeln.st.st2exam.exercise1.domain.MedicalCareCenter` gilt folgende Beschreibung (auf Englisch, um näher
an Attributen und Klassennamen zu bleiben):

A medical care center is certified for a certain number of diseases that it is allowed to treat.
Such a certification is always valid for a period of several years (i.e. from January 1st to December 31st).
The oldest certifications date back to the year 1990. Even outdated certifications need to be kept in the system
for legal reasons.


## Glossar (als Hilfe für den obigen Text)

| Englisch            | Deutsch                   |
|---------------------|---------------------------|
| medical care center | Gesundheitszentrum        |
| disease             | Krankheit                 |
| to treat            | behandeln                 |
| to certify          | zertifizieren             |
| nurse               | Krankenschwester/-pfleger |
| date back           | gehen zurück bis          |
| outdated            | nicht mehr gültig         |
| legal reasons       | gesetzliche Gründe        |


## Aufgabenstellung 

1. Gehen Sie in die Klasse `thkoeln.archilab.st2.a4.MedicalCareCenter` und identifizieren 
   Sie Attribute, die sich für die Umsetzung als Domain Primitive für den oben beschriebenen 
   Sachverhalt eignen. 
2. Legen Sie dieses Domain Primitive im Package `thkoeln.archilab.st2.a4.domainprimitives` an.
3. Führen Sie ein Refactoring des Code aus. 
4. Fügen Sie an der richtigen Stelle eine sinnvolle Validierung hinzu. Hierfür ist noch kein 
   Code vorhanden, aber Sie haben den Test `addInvalidCertifications()` (der momentan fehlschlägt). 
   Der kann Ihnen helfen, die Fehlerfälle zu identifizieren.
5. Verschieben Sie Logik in das Domain Primitive, wo das sinnvoll möglich ist. 

## Hinweise

1. Man könnte möglicherweise in dieser Klasse noch andere Domain Primitives identifizieren. Es geht in dieser
   Aufgabe aber **nur** um den oben beschriebenen Fall.  
2. Sie können davon ausgehen, dass **keine** geschachtelten Domain Primitives vorkommen.
3. Sie können auch für unvollständige oder sogar nicht compilierende Lösungen Punkte
   erhalten. Versuchen Sie also, so weit wie möglich zu kommen. Die volle Punktzahl
   gibt es aber nur für eine vollständige, compilierende Lösung, bei der beide Tests
   grün sind.
