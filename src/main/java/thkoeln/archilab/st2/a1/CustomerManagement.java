package thkoeln.archilab.st2.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to manage all our customers
 */
@Service
public class CustomerManagement {
    private final CustomerDBInterface customerDBInterface;

    @Autowired
    public CustomerManagement( CustomerDBInterface customerDBInterface ) {
        this.customerDBInterface = customerDBInterface;
    }

    public void addCustomer( CustomerEntity customerEntity ) {
        if ( customerEntity == null ) throw new IllegalArgumentException( "Customer must not be null" );
        customerDBInterface.save( customerEntity );
    }

    // ... we skip the other possible methods
}
