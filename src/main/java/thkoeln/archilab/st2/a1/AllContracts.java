package thkoeln.archilab.st2.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class to manage all contracts in the system.
 */
@Service
public class AllContracts {
    private final ContractRepo contractRepo;

    @Autowired
    public AllContracts( ContractRepo contractRepo ) {
        this.contractRepo = contractRepo;
    }


    public void addContract( Contract contract ) {
        if ( contract == null ) throw new IllegalArgumentException( "Contract must not be null" );
        contractRepo.save( contract );
    }


    public void deleteContract( Contract contract ) {
        if ( contract == null ) throw new IllegalArgumentException( "Contract must not be null" );
        contractRepo.delete( contract );
    }


    public List<Contract> getAllContractsForCustomer( CustomerEntity customerEntity ) {
        if ( customerEntity == null ) throw new IllegalArgumentException( "Customer must not be null" );
        return contractRepo.findAllByCustomerEntity( customerEntity );
    }

    // ... we skip the other possible methods
}
