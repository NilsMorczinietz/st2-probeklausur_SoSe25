package thkoeln.archilab.st2.exercises.payment.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private boolean isValid;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isValid = ( email != null && email.contains( "@" ) );
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = ( Customer ) o;
        return Objects.equals(email, customer.email);
    }
}
