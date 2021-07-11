package thkoeln.archilab.st2.exercises.wiederholungss21.e1;

public class CompanyCustomer extends Customer {

    public CompanyCustomer( String name, String email ) {
        super( null, name, email );
    }

    public String getName() {
        return super.getLastName();
    }

    public void setName( String name ) {
        super.setLastName( name );
    }

    public String getFirstName() {
        throw new RuntimeException( "Companies don't have first names" );
    }

    public void setFirstName() {
        throw new RuntimeException( "Companies don't have first names" );
    }

}
