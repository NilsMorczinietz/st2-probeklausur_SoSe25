package thkoeln.archilab.st2.exercises.payment.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Stack;

@Setter
@Getter
public class Voucher {
    // amount of the voucher
    private Float money1;
    // currency of the voucher
    private String money2;
    // voucher is valid for this customer only
    private Customer customer;
    // the last dates when this voucher was used
    private Stack<Date> lastD = new Stack<>();
    // the last money amounts that were taken off this voucher
    private Stack<Float> lastM1 = new Stack<>();
    // the last currencies in which money was taken off this voucher
    private Stack<String> lastM2 = new Stack<>();
    // the last purposes for which money was taken off this voucher
    private Stack<String> lastPurposes = new Stack<>();

    public Voucher( Float amount, String currency, Customer customer ) {
        if ( !customer.isOk() ) throw new RuntimeException();
        if ( amount == null ) throw new RuntimeException();
        if ( amount < 0 ) throw new RuntimeException();
        if ( currency == null ) throw new RuntimeException();
        if ( !currency.equals( "EUR") && !currency.equals( "DKR") && !currency.equals( "SEK") ) throw new RuntimeException();
        this.money1 = amount;
        this.money2 = currency;
        this.customer = customer;
    }

    public boolean hasBeenCashed() {
        return ( money1 <= 0f );
    }

}
