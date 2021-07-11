package thkoeln.archilab.st2.exercises.payment.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

@Setter
@Getter
public class Voucher {
    private Float amount;
    private String currency;
    private Customer customer;
    private Stack<Date> withdrawalDates = new Stack<>();
    private Stack<Float> withdrawalAmounts = new Stack<>();
    private Stack<String> withdrawalCurrencies = new Stack<>();
    private Stack<String> withdrawalPurposes = new Stack<>();

    public Voucher( Float amount, String currency, Customer customer ) {
        if ( !customer.isValid() ) throw new RuntimeException();
        if ( amount == null ) throw new RuntimeException();
        if ( amount < 0 ) throw new RuntimeException();
        if ( currency == null ) throw new RuntimeException();
        if ( !currency.equals( "EUR") && !currency.equals( "DKR") && !currency.equals( "SEK") ) throw new RuntimeException();
        this.amount = amount;
        this.currency = currency;
        this.customer = customer;
    }

    public boolean hasBeenCashed() {
        return ( amount <= 0f );
    }

}
