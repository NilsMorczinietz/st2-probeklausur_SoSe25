package thkoeln.archilab.st2.a1;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerDBInterface extends CrudRepository<CustomerEntity, CustomerId> {
}
