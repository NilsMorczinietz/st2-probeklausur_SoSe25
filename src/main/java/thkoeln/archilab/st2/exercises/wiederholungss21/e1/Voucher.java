package thkoeln.archilab.st2.exercises.wiederholungss21.e1;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Voucher {
    private Float amount;
    private String currency;
    private Customer customer;
    private List<Date> withdrawalDates = new ArrayList<>();
    private List<Float> withdrawalAmounts = new ArrayList<>();
    private List<String> withdrawalCurrencies = new ArrayList<>();
    private List<String> withdrawalPurposes = new ArrayList<>();

    public Voucher( Float amount, String currency, Customer customer ) {
        this.amount = amount;
        this.currency = currency;
        this.customer = customer;
    }

    public void withdrawMoneyFrom( Customer customer, Float withdrawalAmount, String withdrawalCurrency ) {
        if ( ! currency.equals( withdrawalCurrency ) )  {
            // ...
        }
    }


}
