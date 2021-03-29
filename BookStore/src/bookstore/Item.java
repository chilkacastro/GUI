/*
 * The MIT License
 *
 * Copyright 2021 Chilka Castro.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package bookstore;

import java.util.Objects;

/**
 * A simple class of Item
 * @author Chilka Castro
 */
public class Item {
    protected String itemNo;
    protected double price;
    protected int amount;
    protected String category;
    protected boolean isGift;

    /**
     * Default constructor
     */
    public Item() {
        this.itemNo = "";
        this.price = -1;
        this.amount = -1;
        this.category = "";
        this.isGift = false;
    }

    /**
     * Constructor with four data members
     * @param price the price of the item
     * @param amount the amount of the item in the store
     * @param category the category of the item
     * @param isGift if that item can be used as a gift or not
     */
    public Item(double price, int amount, String category, boolean isGift) {
        this.itemNo = "";
        this.price = price;
        this.amount = amount;
        this.category = category;
        this.isGift = isGift;
    }

    /**
     * Copy constructor
     * @param item the item object to copy
     */
    public Item(Item item) {
        this.itemNo = item.itemNo;
        this.price = item.price;
        this.amount = item.amount;
        this.category = item.category;
        this.isGift = item.isGift;
    }

    /**
     * Hash code of the Item class
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.price) 
                ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.category);
        return hash;
    }

    /**
     * Checks if two objects are the same or not
     * @param obj the object to be compared with
     * @return True if they are the same and False if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Item other = (Item) obj;
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price))
            return false;
        if (!Objects.equals(this.category, other.category))
            return false;
        return true;
    }

    /**
     * Creates a String that represents an item object
     * @return a String that represents an item object
     */
    @Override
    public String toString() {
        String str = "";

        str += String.format("%-10s : %s\n", "Item Number", itemNo);
        str += String.format("%-10s : %.2f\n", "Price", price);
        str += String.format("%-10s : %d\n", "Amount", amount);
        str += String.format("%-10s : %s\n", "Category", category);
        str += String.format("%-10s : %s\n", "Gift", isGift ? "Yes" : "No");
        
        return str;
        
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIsGift() {
        return isGift;
    }

    public void setIsGift(boolean isGift) {
        this.isGift = isGift;
    }
}
