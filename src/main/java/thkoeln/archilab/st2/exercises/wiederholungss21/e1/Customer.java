package thkoeln.archilab.st2.exercises.wiederholungss21.e1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private Boolean valid;

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.valid = ( email != null && email.contains( "@") );
    }
}
