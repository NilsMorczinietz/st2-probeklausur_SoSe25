# Aufgabe 8: Verständnisfragen zum Stoff der Vorlesung (15 Punkte)

In dieser Aufgabe sollen Sie drei Verständnisfragen zum Stoff der Vorlesung beantworten. 

## Frage 1: Entities

Sie haben folgende Entity-Definition. 
- In welcher Weise verstößt der Code gegen grundsätzliche Eigenschaften eines Entities? 
- Welche Fehler könnte es konkret bei der Verwendung geben?

- Tipp: Beachten Sie die @Lombok-Annotationen.

```
@Entity
@Getter @Setter
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private Double price;
    
    // ... business logic not shown ...
}
```

### Ihre Antwort: 
- price sollte ein Domainprimitve sein, da er aus Wert und Einheit besteht.


---
## Frage 2: SOLID

In Ihrem Softwaresystem gibt es eine Interface `BusinessOperations`, die alle Use Cases des Systems abdeckt. 
Methoden wie z.B. `createCustomer(...)`, `addProductToCatalog(...)`, `shipOrder(...)`, `calculateTax(...)`, 
`getInvoiceAsPDF(...)`, usw. Die Begründung ist, dass damit REST-Controller nur ein gemeinsames Interface 
benutzen müssen. Es gibt dann einen großen Service in Ihrem Backend, der das Interface implementiert und
zu den Application-Service-Klassen der einzelnen Aggregates (`Customer`, `Order`, `Shipment` etc.)
verzweigt.

Welche(s) SOLID-Prinzip(ien) werden hier verletzt und aus welchem Grund?

### Ihre Antwort:
Single Responsibility Principle:
- , da ein Service immer nur für eine Komponente des Sytems verwendet werden sollte. Es sollte demnach keinen großen Service  geben, der alle Implementiert oder auf alles verweist.- Dependency Inversion Principle:

DIP:
- Die Komponenten können nicht unabhängig voneinander agieren, was schlecht für die Wartbarkeit und Austauschbarkeit ist

Interface Segregation Principle:
-  Da es wie in der Aufgabenstellug gesagt ein grißen interface gibt an statt viele kleine. folgen siege DIP



---
## Frage 3: Repositories

Gegeben ist folgendes Repository:   

```
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
```

Was bedeuten die beiden generischen Typen `<Customer, UUID>` in dieser Repository-Definition?

### Ihre Antwort:

Cusomter → dass es ein Repo über das Aggregate/Entity Custoemr ist
Der Typ der PKs von Customer ist eine UUID


