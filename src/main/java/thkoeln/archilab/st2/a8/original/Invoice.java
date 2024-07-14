package thkoeln.archilab.st2.a8.original;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Invoice {
    // Purpose of the invoice - for what has money been paid? Belongs to the TR54-LZ field in the database.
    private String tr54LZ;
    // amount of the invoice
    private Float am;
    // currency of the invoice
    private String cur;
    // customer for whom this invoice is written
    private String cust;

    /**
     * Pays the invoice in full, or parts of it, from a voucher.
     * @param v
     * @return false if something goes wrong, else true
     */
    public boolean payPerVoucher( Voucher v ) {
        if ( cust == null ) return false;
        if ( cust.isEmpty() ) return false;
        if ( am == null ) return false;
        if ( am < 0 ) return false;
        if ( cur == null ) return false;
        if ( !cur.equals( "EUR") && !cur.equals( "DKR") && !cur.equals( "SEK") ) return false;
        if ( tr54LZ == null ) return false;
        if ( v == null ) return false;
        if ( v.getCustomer() == null ) return false;
        if ( v.getMoney1() == null ) return false;
        if ( v.getMoney1() < 0 ) return false;
        if ( v.getMoney2() == null ) return false;
        if ( !v.getMoney2().equals( "EUR") && !v.getMoney2().equals( "DKR") && !v.getMoney2().equals( "SEK") ) return false;
        if ( !cust.equals( v.getCustomer() ) ) return false;
        if ( !cur.equals( v.getMoney2() ) ) return false;
        if ( v.hasBeenCashed() ) return false;
        if ( am > v.getMoney1() ) {
            am -= v.getMoney1();
            Float reduction = v.getMoney1();
            v.setMoney1( 0f );
            v.getLastM1().add( reduction );
            v.getLastM2().add( cur );
            v.getLastPurposes().add( tr54LZ );
            v.getLastD().add( LocalDate.now() );
        }
        else if ( am.equals( v.getMoney1() ) ) {
            am = 0f;
            Float reduction = v.getMoney1();
            v.setMoney1( 0f );
            v.getLastM1().add( reduction );
            v.getLastM2().add( cur );
            v.getLastPurposes().add( tr54LZ );
            v.getLastD().add( LocalDate.now() );
        }
        else if ( am < v.getMoney1() ) {
            Float reduction = am;
            am = 0f;
            v.setMoney1( v.getMoney1() - reduction );
            v.getLastM1().add( reduction );
            v.getLastM2().add( cur );
            v.getLastPurposes().add( tr54LZ );
            v.getLastD().add( LocalDate.now() );
        }
        return true;
    }

    /**
     * Updates the invoice purpose. It is customary to add the customers name to the purpose.
     * @param newTr54LZ
     * @return false if something goes wrong, else true
     */
    public boolean updatePurpose ( String newTr54LZ ) {
        if ( newTr54LZ == null ) return false;
        if ( cust == null ) return false;
        if ( cust.isEmpty() ) return false;
        if ( am == null ) return false;
        if ( am < 0 ) return false;
        if ( cur == null ) return false;
        if ( !cur.equals( "EUR") && !cur.equals( "DKR") && !cur.equals( "SEK") ) return false;
        if ( tr54LZ == null ) return false;
        tr54LZ = newTr54LZ;
        tr54LZ += " (for " + cust + ")";
        return true;
    }


    /**
     * Voucher that can be given to customers to pay invoices.
     */
    @Setter
    @Getter
    @AllArgsConstructor
    public static class Voucher {
        // amount of the voucher
        private Float money1;
        // currency of the voucher
        private String money2;
        // voucher is valid for this customer only
        private String customer;
        // the last dates when this voucher was used
        private List<LocalDate> lastD = new ArrayList<>();
        // the last money amounts that were taken off this voucher
        private List<Float> lastM1 = new ArrayList<>();
        // the last currencies in which money was taken off this voucher
        private List<String> lastM2 = new ArrayList<>();
        // the last purposes for which money was taken off this voucher
        private List<String> lastPurposes = new ArrayList<>();

        public Voucher( Float amount, String currency, String customer ) {
            if ( customer.isEmpty() ) throw new RuntimeException();
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
}
