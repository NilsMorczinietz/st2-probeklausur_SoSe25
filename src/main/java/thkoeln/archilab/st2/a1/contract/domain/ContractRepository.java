package thkoeln.archilab.st2.a1.contract.domain;

import org.springframework.data.repository.CrudRepository;
import thkoeln.archilab.st2.a1.customer.domain.CustomerId;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, ContractId> {
    List<Contract> findAllByCustomerId( CustomerId customerId );
    List<Contract> findAllByTitle( String title );
}
