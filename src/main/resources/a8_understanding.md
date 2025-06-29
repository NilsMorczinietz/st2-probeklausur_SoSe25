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



---
## Frage 3: Repositories

Gegeben ist folgendes Repository:   

```
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
```

Was bedeuten die beiden generischen Typen `<Customer, UUID>` in dieser Repository-Definition?

### Ihre Antwort:



