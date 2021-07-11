package thkoeln.archilab.st2.exercises.payment.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DomainTests {
    private Customer ralf, alva, bjoern;
    private CompanyCustomer besserEssen;
    private Voucher vr, va, vb1, vb2, ve;
    private Invoice ir, ia, ib, ie;

    @BeforeEach
    public void setUp() {
        ralf = new Customer( "Ralf", "Hanstorf", "ralf@hanstorf-familie.de" );
        alva = new Customer( "Alva", "Jensen", "alva.jensen.1827@gmail.com" );
        bjoern = new Customer( "Björn", "Ladesund", "bjoern@ladesund-services.se" );
        besserEssen = new CompanyCustomer( "Besser Essen GmbH", "info@besser-essen-gmbh.de" );

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
        assertTrue( bjoern.isValid() );
        assertTrue( besserEssen.isValid() );

        Customer invalidCustomer = new Customer( "X", "Yz", "123456" );
        assertFalse( invalidCustomer.isValid() );
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
        assertEquals( "DKR", v.getCurrency() );
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
        assertEquals( 99f - 23f, ir.getAmount() );
        assertEquals( 0f, vr.getAmount() );
        assertEquals( ir.getPurpose(), vr.getWithdrawalPurposes().peek() );
        assertEquals( 23f, vr.getWithdrawalAmounts().peek() );
        assertEquals( ir.getCurrency(), vr.getWithdrawalCurrencies().peek() );
    }

    @Test
    public void testPayInvoiceFullyByVoucher() {
        ia.payPerVoucher( va );
        assertEquals( 0f, ia.getAmount() );
        assertEquals( 71f - 12f, va.getAmount() );
        assertEquals( ia.getPurpose(), va.getWithdrawalPurposes().peek() );
        assertEquals( 12f, va.getWithdrawalAmounts().peek() );
        assertEquals( ia.getCurrency(), va.getWithdrawalCurrencies().peek() );
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
        assertEquals( "Some stuff (for Ralf Hanstorf)", ir.getPurpose() );
        ie.updatePurpose( "Some stuff" );
        assertEquals( "Some stuff (for Besser Essen GmbH)", ie.getPurpose() );
    }
}
