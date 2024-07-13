package thkoeln.archilab.st2.ax_payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
    private Customer c;

    /**
     * Pays the invoice in full, or parts of it, from a voucher.
     * @param v
     * @return false if something goes wrong, else true
     */
    public boolean payPerVoucher( Voucher v ) {
        if ( c == null ) return false;
        if ( !c.isOk() ) return false;
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
        if ( !c.equals( v.getCustomer() ) ) return false;
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
        else if ( am == v.getMoney1() ) {
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
     * Updates the invoice purpose. It is customary to add the customers first and last name to the purpose.
     * @param newTr54LZ
     * @return false if something goes wrong, else true
     */
    public boolean updatePurpose ( String newTr54LZ ) {
        if ( newTr54LZ == null ) return false;
        if ( c == null ) return false;
        if ( !c.isOk() ) return false;
        if ( am == null ) return false;
        if ( am < 0 ) return false;
        if ( cur == null ) return false;
        if ( !cur.equals( "EUR") && !cur.equals( "DKR") && !cur.equals( "SEK") ) return false;
        if ( tr54LZ == null ) return false;
        tr54LZ = newTr54LZ;
        if ( c instanceof CCustomer) {
            // CompanyCustomer doesn't have a first name
            tr54LZ += " (for " + c.getLName() + ")";
        }
        else {
            tr54LZ += " (for " + c.getFName() + " " + c.getLName() + ")";
        }
        return true;
    }
}
