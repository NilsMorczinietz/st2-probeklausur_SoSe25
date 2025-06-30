package thkoeln.archilab.st2.a1.Contract.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thkoeln.archilab.st2.a1.Contract.domain.Contract;
import thkoeln.archilab.st2.a1.Contract.domain.ContractRepository;
import thkoeln.archilab.st2.a1.Customer.domain.CustomerId;

import java.util.List;

/**
 * Service class to manage all contracts in the system.
 */
@Service
public class ContractService {
    private final ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }


    public void addContract( Contract contract ) {
        if ( contract == null ) throw new IllegalArgumentException( "Contract must not be null" );
        contractRepository.save( contract );
    }


    public void deleteContract( Contract contract ) {
        if ( contract == null ) throw new IllegalArgumentException( "Contract must not be null" );
        contractRepository.delete( contract );
    }


    public List<Contract> getAllContractsForCustomerId( CustomerId customerId ) {
        if ( customerId == null ) throw new IllegalArgumentException( "Customer must not be null" );
        return contractRepository.findAllByCustomerId( customerId );
    }

    // ... we skip the other possible methods
}
