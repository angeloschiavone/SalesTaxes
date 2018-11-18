package com.angelo.test;

import com.angelo.salestaxes.Item;
import com.angelo.salestaxes.Cart;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SalesTaxesUnitTest {

    private Cart cart;

    public SalesTaxesUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cart = new Cart();
    }

    @Test
    public void testCase1() {
        Item book = new Item("book", Item.NOT_IMPORTED, Item.TAX_FREE, 12.49);
        Item musicCd = new Item("music CD", Item.NOT_IMPORTED, Item.TAXABLE, 14.99);
        Item chocolate = new Item("chocolate bar", Item.NOT_IMPORTED, Item.TAX_FREE, 0.85);
        cart.addItem(book);
        cart.addItem(musicCd);
        cart.addItem(chocolate);
        System.out.println("OUTPUT 1");
        double bill = cart.printBill();
        assertEquals(29.83, bill, 0.0001);
    }

    @Test
    public void testCase2() {
        Item chocoImpo = new Item("imported box of chocolates", Item.IMPORTED, Item.TAX_FREE, 10.0);
        Item perfumeImpo = new Item("imported bottle of perfume", Item.IMPORTED, Item.TAXABLE, 47.50);
        cart.addItem(chocoImpo);
        cart.addItem(perfumeImpo);
        System.out.println("OUTPUT 2");
        double bill = cart.printBill();
        assertEquals(65.15, bill, 0.0001);
    }

    @Test
    public void testCase3() {

        Item perfumeImp = new Item("imported bottle of perfume", Item.IMPORTED, Item.TAXABLE, 27.99);
        Item perfume = new Item("bottle of perfume", Item.NOT_IMPORTED, Item.TAXABLE, 18.99);
        Item headhachePills = new Item("packet of headache pills", Item.NOT_IMPORTED, Item.TAX_FREE, 9.75);
        Item chocolateImported = new Item("imported box of chocolates", Item.IMPORTED, Item.TAX_FREE, 11.25);
        cart.addItem(perfumeImp);
        cart.addItem(perfume);
        cart.addItem(headhachePills);
        cart.addItem(chocolateImported);
        System.out.println("OUTPUT 3");
        double bill = cart.printBill();
        assertEquals(74.68, bill, 0.0001);
    }

    @After
    public void tearDown() {
        cart.clear();
    }
}
