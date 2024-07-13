package thkoeln.archilab.st2.ax_payment;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Customer {
    // first name
    private String fName;
    // last name
    private String lName;
    // the email address
    private String mail;
    // true if this is a valid customer, all necessary attributes set
    private boolean ok;

    public Customer(String firstName, String lastName, String mail) {
        this.fName = firstName;
        this.lName = lastName;
        this.mail = mail;
        this.ok = ( mail != null && mail.contains( "@" ) );
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = ( Customer ) o;
        return Objects.equals(mail, customer.mail);
    }
}
