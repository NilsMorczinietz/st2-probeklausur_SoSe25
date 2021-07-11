package thkoeln.archilab.st2.exercises.wiederholungss21.e1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Invoice {
    private String purpose;
    private Float amount;
    private String currency;
    private Customer customer;

    public boolean payPerVoucher( Voucher voucher ) {
        return false;

        // hier wird die Transaktion ins Voucher eingetragen
        // auch die Summe abgezogen
    }
}
