package thkoeln.archilab.st2.a1.Contract.domain;

import org.springframework.data.repository.CrudRepository;
import thkoeln.archilab.st2.a1.domainprimitives.ContractReferenceKeyType;
import thkoeln.archilab.st2.a1.Customer.domain.CustomerId;

import java.util.List;

public interface ContractRepository extends CrudRepository<Contract, ContractReferenceKeyType> {
    List<Contract> findAllByCustomerId( CustomerId customerId );
    List<Contract> findAllByTitle( String title );
}
