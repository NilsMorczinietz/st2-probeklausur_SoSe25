package thkoeln.archilab.st2.a1;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ContractRepo extends CrudRepository<Contract, UUID> {
    List<Contract> findAllByCustomerEntity( CustomerEntity customerEntity );
    List<Contract> findAllByTitle( String title );
}
