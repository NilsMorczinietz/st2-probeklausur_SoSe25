package thkoeln.archilab.st2.a8.original;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {
    private Invoice.Voucher voucherAnna;
    private Invoice invoiceAnna, invoiceBernd;

    @BeforeEach
    public void setUp() {
        voucherAnna = new Invoice.Voucher( 100f, "EUR", "Anna" );
        invoiceAnna = new Invoice( "Purchase 23.07.2024", 30f, "EUR", "Anna" );
        invoiceBernd = new Invoice( "Some stuff", 60f, "EUR", "Bernd" );
    }


    @Test
    public void testInvalidVoucher() {
        // given
        // when
        // then
        assertThrows( RuntimeException.class, () -> {
            Invoice.Voucher nullAmount = new Invoice.Voucher( null, "EUR", "Bernd" );
        } );
        assertThrows( RuntimeException.class, () -> {
            Invoice.Voucher negativeAmount = new Invoice.Voucher( -50f, "EUR", "Bernd" );
        } );
        assertThrows( RuntimeException.class, () -> {
            Invoice.Voucher invalidCurrency = new Invoice.Voucher( 50f, "USD", "Bernd" );
        } );
        assertThrows( RuntimeException.class, () -> {
            Invoice.Voucher nullCurrency = new Invoice.Voucher( 50f, null, "Bernd" );
        } );
        assertThrows( RuntimeException.class, () -> {
            Invoice.Voucher nullCustomer = new Invoice.Voucher( 50f, "EUR", "" );
        } );
        assertThrows( RuntimeException.class, () -> {
            Invoice.Voucher emptyCustomer = new Invoice.Voucher( 50f, "EUR", null );
        } );
    }


    @Test
    public void testInvalidInvoice() {
        // given
        Invoice noPurpose = new Invoice( null, 50f, "EUR", "Bernd" );
        Invoice noAmount = new Invoice( "TR54-LZ", null, "EUR", "Bernd" );
        Invoice negativeAmount = new Invoice( "TR54-LZ", -50f, "EUR", "Bernd" );
        Invoice noCurrency = new Invoice( "TR54-LZ", 50f, null, "Bernd" );
        Invoice invalidCurrency = new Invoice( "TR54-LZ", 50f, "USD", "Bernd" );
        Invoice nullCustomer = new Invoice( "TR54-LZ", 50f, "EUR", null );
        Invoice emptyCustomer = new Invoice( "TR54-LZ", 50f, "EUR", "" );

        // when
        // then
        assertFalse( noPurpose.payPerVoucher( voucherAnna ) );
        assertFalse( noAmount.payPerVoucher( voucherAnna ) );
        assertFalse( negativeAmount.payPerVoucher( voucherAnna ) );
        assertFalse( noCurrency.payPerVoucher( voucherAnna ) );
        assertFalse( invalidCurrency.payPerVoucher( voucherAnna ) );
        assertFalse( nullCustomer.payPerVoucher( voucherAnna ) );
        assertFalse( emptyCustomer.payPerVoucher( voucherAnna ) );
    }


    @Test
    public void testTryPayingWithVoucherForWrongCustomer() {
        // given
        // when
        // then
        assertFalse( invoiceBernd.payPerVoucher( voucherAnna ) );
    }


    @Test
    public void testUpdatePurpose() {
        // given
        // when
        assertTrue( invoiceBernd.updatePurpose( "Some more stuff" ) );

        // then
        assertEquals( "Some more stuff (for Bernd)", invoiceBernd.getTr54LZ() );
    }


    @Test
    public void testPaySuccessfullyPerVoucher() {
        // given
        Float lastAmount = invoiceAnna.getAm();
        String lastCurrency = invoiceAnna.getCur();
        long lastDateEpoch = LocalDate.now().toEpochDay();
        String lastPurpose = invoiceAnna.getTr54LZ();

        // when
        assertTrue( invoiceAnna.payPerVoucher( voucherAnna ) );

        // then
        assertEquals( 0f, invoiceAnna.getAm() );
        assertEquals( 70f, voucherAnna.getMoney1() );
        assertEquals( "EUR", voucherAnna.getMoney2() );
        assertEquals( lastAmount, voucherAnna.getLastM1().get( 0 ) );
        assertEquals( lastCurrency, voucherAnna.getLastM2().get( 0 ) );
        assertEquals( lastDateEpoch, voucherAnna.getLastD().get( 0 ).toEpochDay() );
        assertEquals( lastPurpose, voucherAnna.getLastPurposes().get( 0 ) );
    }


    @Test
    public void testCashInVoucher() {
        // given
        Invoice invoice1 = new Invoice( "First invoice", 30f, "EUR", "Anna" );
        Invoice invoice2 = new Invoice( "Second invoice", 70f, "EUR", "Anna" );

        // when
        assertTrue( invoice1.payPerVoucher( voucherAnna ) );
        assertFalse( voucherAnna.hasBeenCashed() );

        // then
        assertTrue( invoice2.payPerVoucher( voucherAnna ) );
        assertTrue( voucherAnna.hasBeenCashed() );
    }



}
