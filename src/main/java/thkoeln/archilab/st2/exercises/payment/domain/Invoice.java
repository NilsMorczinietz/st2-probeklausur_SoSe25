package thkoeln.archilab.st2.exercises.payment.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class Invoice {
    private String purpose;
    private Float amount;
    private String currency;
    private Customer customer;

    /**
     * Pays the invoice in full, or parts of it, from a voucher.
     * @param voucher
     * @return false if something goes wrong, else true
     */
    public boolean payPerVoucher( Voucher voucher ) {
        if ( customer == null ) return false;
        if ( !customer.isValid() ) return false;
        if ( amount == null ) return false;
        if ( amount < 0 ) return false;
        if ( currency == null ) return false;
        if ( !currency.equals( "EUR") && !currency.equals( "DKR") && !currency.equals( "SEK") ) return false;
        if ( purpose == null ) return false;
        if ( voucher == null ) return false;
        if ( voucher.getCustomer() == null ) return false;
        if ( voucher.getAmount() == null ) return false;
        if ( voucher.getAmount() < 0 ) return false;
        if ( voucher.getCurrency() == null ) return false;
        if ( !voucher.getCurrency().equals( "EUR") && !voucher.getCurrency().equals( "DKR") && !voucher.getCurrency().equals( "SEK") ) return false;
        if ( !customer.equals( voucher.getCustomer() ) ) return false;
        if ( !currency.equals( voucher.getCurrency() ) ) return false;
        if ( voucher.hasBeenCashed() ) return false;
        if ( amount > voucher.getAmount() ) {
            amount -= voucher.getAmount();
            Float reduction = voucher.getAmount();
            voucher.setAmount( 0f );
            voucher.getWithdrawalAmounts().push(reduction);
            voucher.getWithdrawalCurrencies().push(currency);
            voucher.getWithdrawalPurposes().push(purpose);
            voucher.getWithdrawalDates().push(new Date());
        }
        else if ( amount == voucher.getAmount() ) {
            amount = 0f;
            Float reduction = voucher.getAmount();
            voucher.setAmount( 0f );
            voucher.getWithdrawalAmounts().push(reduction);
            voucher.getWithdrawalCurrencies().push(currency);
            voucher.getWithdrawalPurposes().push(purpose);
            voucher.getWithdrawalDates().push(new Date());
        }
        else if ( amount < voucher.getAmount() ) {
            Float reduction = amount;
            amount = 0f;
            voucher.setAmount( voucher.getAmount() - reduction );
            voucher.getWithdrawalAmounts().push(reduction);
            voucher.getWithdrawalCurrencies().push(currency);
            voucher.getWithdrawalPurposes().push(purpose);
            voucher.getWithdrawalDates().push(new Date());
        }
        return true;
    }

    /**
     * Updates the invoice purpose. It is customary to add the customers first and last name to the purpose.
     * @param newPurpose
     * @return false if something goes wrong, else true
     */
    public boolean updatePurpose ( String newPurpose ) {
        if ( newPurpose == null ) return false;
        if ( customer == null ) return false;
        if ( !customer.isValid() ) return false;
        if ( amount == null ) return false;
        if ( amount < 0 ) return false;
        if ( currency == null ) return false;
        if ( !currency.equals( "EUR") && !currency.equals( "DKR") && !currency.equals( "SEK") ) return false;
        if ( purpose == null ) return false;
        purpose = newPurpose;
        if ( customer instanceof CompanyCustomer ) {
            // CompanyCustomer doesn't have a first name
            purpose += " (for " + customer.getLastName() + ")";
        }
        else {
            purpose += " (for " + customer.getFirstName() + " " + customer.getLastName() + ")";
        }
        return true;
    }
}
