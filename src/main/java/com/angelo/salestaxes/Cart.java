package com.angelo.salestaxes;

import java.util.ArrayList;

public class Cart {

    private final ArrayList<Item> cart;

    public Cart() {
        cart = new ArrayList<>();
    }

    public void addItem(Item item) {
        TaxCalculator.Calculate(item);
        cart.add(item);
    }

    public void removeItem(Item item) {
        cart.remove(item);
    }

    public void clear() {
        cart.clear();
    }

    public double printBill() {
        long salesTaxes = 0;
        long finalPrice = 0;

        for (Item item : cart) {
            finalPrice += item.getFinalPrice();
            salesTaxes += item.getTaxes();
            System.out.println("1 " + item.getDescription() + ": " + item.getFinalPrice() / 100.0);
        }
        
        System.out.println("Sales taxes: " + salesTaxes / 100.0);
        System.out.println("Total: " + finalPrice / 100.0);
        return finalPrice / 100.0;
    }

}
