package thkoeln.archilab.st2.a1.customer.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a1.customer.domain.CustomerRepository;
import thkoeln.archilab.st2.a1.customer.domain.Customer;

/**
 * Service class to manage all our customers
 */
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("Customer must not be null");
        customerRepository.save(customer);
    }

    // ... we skip the other possible methods
}
