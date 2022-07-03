package thkoeln.archilab.st2.exercises.payment;

/**
 * Special case - Customer is a compony. No first name then!
 */
public class CCustomer extends Customer {

    public CCustomer(String name, String email ) {
        super( null, name, email );
    }

    public String getName() {
        return super.getLName();
    }

    public void setName( String name ) {
        super.setLName( name );
    }

    public String getFName() {
        throw new RuntimeException( "Companies don't have first names" );
    }

    public void setFName() {
        throw new RuntimeException( "Companies don't have first names" );
    }

}
