package thkoeln.archilab.st2.a1;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContractRepo extends CrudRepository<Contract, ContractReferenceKeyType> {
    List<Contract> findAllByCustomerId( CustomerId customerId );
    List<Contract> findAllByTitle( String title );
}
