package com.angelo.salestaxes;

public class Item {

    private final String description;
    private final boolean isImported;
    private final boolean isTaxFree;
    private final long price;
    private long taxes;
    
    static public final boolean IMPORTED = true;
    static public final boolean NOT_IMPORTED = false;
    static public final boolean TAX_FREE = true;
    static public final boolean TAXABLE = false;
    
    public Item(String description, boolean isImported, boolean isTaxFree, double price) {
        if ( price < 0.01 )
        {
            throw new IllegalArgumentException("The price must be a positive number, at least 1 cent");
        }
        if ( description.isEmpty() )
        {
            throw new IllegalArgumentException("Please provide a description for the item");
        }
        this.description = description;
        this.isImported = isImported;
        this.isTaxFree = isTaxFree;
        this.price = Math.round(price * 100); // work with cents (long) to avoid dobule's issues
    }

    public String getDescription() {
        return description;
    }

    public boolean isImported() {
        return isImported;
    }

    public boolean isTaxFree() {
        return isTaxFree;
    }

    public long getPrice() {
        return price;
    }

    public long getTaxes() {
        return taxes;
    }

    public void setTaxes(long taxes) {
        this.taxes = taxes;
    }

    public long getFinalPrice() {
        return price + taxes;
    }
}
