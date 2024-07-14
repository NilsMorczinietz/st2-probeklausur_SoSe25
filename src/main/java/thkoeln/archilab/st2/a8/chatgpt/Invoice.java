package thkoeln.archilab.st2.a8.chatgpt;

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
    private String purpose; // Purpose of the invoice
    private Float amount; // Amount of the invoice
    private String currency; // Currency of the invoice
    private String customer; // Customer for whom this invoice is written

    /**
     * Pays the invoice in full, or parts of it, from a voucher.
     *
     * @param voucher The voucher used for payment
     * @return false if something goes wrong, else true
     */
    public boolean payPerVoucher(Voucher voucher) {
        if (isInvalidInvoice() || isInvalidVoucher(voucher) || !customer.equals(voucher.getCustomer()) || !currency.equals(voucher.getCurrency()) || voucher.hasBeenCashed()) {
            return false;
        }

        if (amount > voucher.getAmount()) {
            reduceVoucher(voucher, voucher.getAmount());
        } else {
            reduceVoucher(voucher, amount);
            amount = 0f;
        }

        return true;
    }

    private boolean isInvalidInvoice() {
        return customer == null || customer.isEmpty() || amount == null || amount < 0 || currency == null || !isValidCurrency(currency) || purpose == null;
    }

    private boolean isInvalidVoucher(Voucher voucher) {
        return voucher == null || voucher.getCustomer() == null || voucher.getAmount() == null || voucher.getAmount() < 0 || voucher.getCurrency() == null || !isValidCurrency(voucher.getCurrency());
    }

    private boolean isValidCurrency(String currency) {
        return currency.equals("EUR") || currency.equals("DKR") || currency.equals("SEK");
    }

    private void reduceVoucher(Voucher voucher, Float reduction) {
        amount -= reduction;
        voucher.setAmount(voucher.getAmount() - reduction);
        voucher.getLastAmounts().add(reduction);
        voucher.getLastCurrencies().add(currency);
        voucher.getLastPurposes().add(purpose);
        voucher.getLastDates().add(LocalDate.now());
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Voucher {
        private Float amount; // Amount of the voucher
        private String currency; // Currency of the voucher
        private String customer; // Voucher is valid for this customer only
        private List<LocalDate> lastDates = new ArrayList<>(); // The last dates when this voucher was used
        private List<Float> lastAmounts = new ArrayList<>(); // The last money amounts that were taken off this voucher
        private List<String> lastCurrencies = new ArrayList<>(); // The last currencies in which money was taken off this voucher
        private List<String> lastPurposes = new ArrayList<>(); // The last purposes for which money was taken off this voucher

        public Voucher(Float amount, String currency, String customer) {
            if (customer.isEmpty() || amount == null || amount < 0 || currency == null || !isValidCurrency(currency)) {
                throw new IllegalArgumentException("Invalid voucher parameters");
            }
            this.amount = amount;
            this.currency = currency;
            this.customer = customer;
        }

        public boolean hasBeenCashed() {
            return amount <= 0f;
        }

        private boolean isValidCurrency(String currency) {
            return currency.equals("EUR") || currency.equals("DKR") || currency.equals("SEK");
        }
    }
}
