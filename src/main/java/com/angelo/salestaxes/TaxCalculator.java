package com.angelo.salestaxes;

public class TaxCalculator {

    public static void Calculate(Item item) {
        long taxes = 0;
        if (!item.isTaxFree()) {
            taxes += roundUp(item.getPrice() / 10);
        }
        if (item.isImported()) {
            taxes += roundUp(item.getPrice() / 20);
        }
        item.setTaxes(taxes);
    }

    private static long roundUp(long number) {
        return (number + 4) / 5 * 5;
    }
}
