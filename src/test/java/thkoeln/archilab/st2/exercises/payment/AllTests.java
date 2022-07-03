package thkoeln.archilab.st2.exercises.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import thkoeln.archilab.st2.exercises.payment.CCustomer;
import thkoeln.archilab.st2.exercises.payment.Customer;
import thkoeln.archilab.st2.exercises.payment.Invoice;
import thkoeln.archilab.st2.exercises.payment.Voucher;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AllTests {
    private Customer ralf, alva, bjoern;
    private CCustomer besserEssen;
    private Voucher vr, va, vb1, vb2, ve;
    private Invoice ir, ia, ib, ie;

    @BeforeEach
    public void setUp() {
        ralf = new Customer( "Ralf", "Hanstorf", "ralf@hanstorf-familie.de" );
        alva = new Customer( "Alva", "Jensen", "alva.jensen.1827@gmail.com" );
        bjoern = new Customer( "Björn", "Ladesund", "bjoern@ladesund-services.se" );
        besserEssen = new CCustomer( "Besser Essen GmbH", "info@besser-essen-gmbh.de" );

        vr = new Voucher( 23f, "EUR", ralf );
        va = new Voucher( 71f, "DKR", alva );
        vb1 = new Voucher( 6f, "SEK", bjoern );
        vb2 = new Voucher( 28f, "SEK", bjoern );
        ve = new Voucher( 377f, "EUR", besserEssen );

        ir = new Invoice("Bestellung 23.06.2021", 99f, "EUR", ralf );
        ia = new Invoice("Bookshop", 12f, "DKR", alva );
        ib = new Invoice("Motorcykelhjälm", 189f, "SEK", bjoern);
        ie = new Invoice("Restaurant-Geschirr", 1877f, "EUR", besserEssen );
    }

    @Test
    public void testCreateInvalidCustomer() {
        assertTrue( bjoern.isOk() );
        assertTrue( besserEssen.isOk() );

        Customer invalidCustomer = new Customer( "X", "Yz", "123456" );
        assertFalse( invalidCustomer.isOk() );
    }

    @Test
    public void testCreateInvalidVoucher() {
        Customer invalidCustomer = new Customer( "X", "Yz", "123456" );
        assertThrows( RuntimeException.class, () -> {
            Voucher v = new Voucher( 2f, "EUR", invalidCustomer );
        });
        assertThrows( RuntimeException.class, () -> {
            Voucher v = new Voucher( -2f, "EUR", bjoern );
        });
        assertThrows( RuntimeException.class, () -> {
            Voucher v = new Voucher( null, "EUR", bjoern );
        });
        assertThrows( RuntimeException.class, () -> {
            Voucher v = new Voucher( 12f, null, alva );
        });
        assertThrows( RuntimeException.class, () -> {
            Voucher v = new Voucher( 12f, "abc", alva );
        });
        Voucher v = new Voucher( 12f, "DKR", alva );
        assertEquals( "DKR", v.getMoney2() );
    }


    @Test
    public void testCreateInvalidInvoice() {
        Customer invalidCustomer = new Customer( "X", "Yz", "123456" );
        Invoice invoice = new Invoice( "xyz", 2f, "EUR", invalidCustomer );
        assertFalse( invoice.payPerVoucher( vr ) );
        assertFalse( invoice.updatePurpose( "abc" ) );

        invoice = new Invoice( "xyz", 2f, "EUR", null );
        assertFalse( invoice.payPerVoucher( vr ) );
        assertFalse( invoice.updatePurpose( "abc" ) );

        invoice = new Invoice( null, 2f, "EUR", ralf );
        assertFalse( invoice.payPerVoucher( vr ) );
        assertFalse( invoice.updatePurpose( "abc" ) );

        invoice = new Invoice( "xyz", null, "EUR", ralf );
        assertFalse( invoice.payPerVoucher( vr ) );
        assertFalse( invoice.updatePurpose( "abc" ) );

        invoice = new Invoice( "xyz", -45f, "EUR", ralf );
        assertFalse( invoice.payPerVoucher( vr ) );
        assertFalse( invoice.updatePurpose( "abc" ) );

        invoice = new Invoice( "xyz", 23f, "abc", ralf );
        assertFalse( invoice.payPerVoucher( vr ) );
        assertFalse( invoice.updatePurpose( "abc" ) );
    }

    @Test
    public void testDecreaseInvoicePartiallyByVoucher() {
        ir.payPerVoucher( vr );
        assertEquals( 99f - 23f, ir.getAm() );
        assertEquals( 0f, vr.getMoney1() );
        assertEquals( ir.getTr54LZ(), vr.getLastPurposes().get( vr.getLastPurposes().size()-1 ) );
        assertEquals( 23f, vr.getLastM1().get( vr.getLastM1().size()-1 ) );
        assertEquals( ir.getCur(), vr.getLastM2().get( vr.getLastM2().size()-1 ) );
    }

    @Test
    public void testPayInvoiceFullyByVoucher() {
        ia.payPerVoucher( va );
        assertEquals( 0f, ia.getAm() );
        assertEquals( 71f - 12f, va.getMoney1() );
        assertEquals( ia.getTr54LZ(), va.getLastPurposes().get( va.getLastPurposes().size()-1 ) );
        assertEquals( 12f, va.getLastM1().get( va.getLastM1().size()-1 ) );
        assertEquals( ia.getCur(), va.getLastM2().get( va.getLastM2().size()-1 ) );
    }

    @Test
    public void testVoucherCustomerDoesntFit() {
        assertFalse( ia.payPerVoucher( vr ) );
    }

    @Test
    public void testVoucherCurrencyDoesntFit() {
        Voucher voucher = new Voucher( 377f, "SEK", besserEssen );
        assertFalse( ie.payPerVoucher( voucher ) );
    }

    @Test
    public void testUpdatePurpose() {
        ir.updatePurpose( "Some stuff" );
        assertEquals( "Some stuff (for Ralf Hanstorf)", ir.getTr54LZ() );
        ie.updatePurpose( "Some stuff" );
        assertEquals( "Some stuff (for Besser Essen GmbH)", ie.getTr54LZ() );
    }
}
