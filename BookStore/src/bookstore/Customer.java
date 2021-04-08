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

import static bookstore.BookStore.items;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple class of customer
 * @author Chilka Castro
 */
public class Customer extends User {
    private int vipLevel;
    private ArrayList<Item> itemsInCart;
    private static int nextCustomerId = 1;

    /**
     * Default constructor
     */
    public Customer() {
        super();
        super.setId(String.format("%c%04d", 'U', nextCustomerId++));
        this.vipLevel = -1;
        this.itemsInCart = new ArrayList<>();
    }
    
    /**
     * Constructor with all data members
     * @param vipLevel the VIP level of the customer
     * @param itemsInCart items the customer has added to the cart
     * @param point the amount of points of the customer
     * @param name the name of the customer
     * @param gender the gender of the customer
     * @param phoneNo the phone number of the customer
     * @param email the email of the customer
     */
    public Customer(int vipLevel, ArrayList<Item> itemsInCart, int point, 
            String name, String gender, String phoneNo, String email) {
        super(point, name, gender, phoneNo, email);
        super.setId(String.format("%c%04d", 'U', nextCustomerId++));
        this.vipLevel = vipLevel;
        this.itemsInCart = itemsInCart;
    }
    
    /**
     * Copy constructor
     * @param customer the customer object to copy
     */
    public Customer(Customer customer) {
        super(customer);
        this.vipLevel = customer.vipLevel;
        this.itemsInCart = new ArrayList<>(customer.itemsInCart);
    }
    
    /**
     * Updates the VIP level of a customer. The cost (number of points) 
     * to update depends on the current VIP level of the customer
     * @return True if the customer has enough points to update his/her VIP level 
     * and False if not
     */
    private boolean updateVip() {
        int[] updateCosts = {50, 100, 150};
        
        if (vipLevel < 0 || vipLevel >= 3)
            return false;
        
        setPoint(getPoint() - updateCosts[vipLevel]);
        vipLevel++;
        return true;
    // My solution
//        int updateCosts = 50;
//        int updateCost2 = 100;
//        int updateCost3 = 150;
//        
//        if (vipLevel == 0 && getPoint() >= updateCost) {
//            vipLevel = 1;
//            setPoint(getPoint() - updateCost);
//            return true;
//        }
//        if (vipLevel == 1 && getPoint() >= updateCost2) {
//            vipLevel = 2;
//            setPoint(getPoint() - updateCost2);
//            return true;
//        }
//        if (vipLevel == 2 && getPoint() >= updateCost3) {
//            vipLevel = 3;
//            setPoint(getPoint() - updateCost3);
//            return true;
//        }
//        return false; 
    }
    
    /**
     * Allows the customer to use this method to add an item to its cart.
     * @param item the item object to be deep copied
     * @param amount the amount the customer wants to buy/ or add to his/her cart
     */
    public void addItemToCart(Item item, int amount) {
        // instanceof & casting will prevent checkout to be false all the time
        if (item instanceof Book) {     
            Book book = new Book((Book) item);
            book.amount = amount;
            itemsInCart.add(book);
        }
        else {               
            Cd cd = new Cd((Cd) item);
            cd.amount = amount;
            itemsInCart.add(cd);
        }
    }
    
    /**
     * Calculates the total price of all items in a customer's cart
     * @return the total price of all the items
     */
    public double calcPrice() {
        double totalPrice = 0;
        double fedTaxRatio = 0.05;  
        double proTaxRatio = 0.1;
        
        for (Item cartItem : itemsInCart)
            totalPrice += cartItem.price * cartItem.amount;
        
        double fedTax = totalPrice * fedTaxRatio;
        double proTax = totalPrice * proTaxRatio;
        
        return totalPrice + fedTax + proTax;
    }

    /**
     * Calculates the amount of points of a customer gains after a shopping 
     * session
     * @return the total amount of points for a customer
     */
    @Override
    public int calcPoint() {
        int additionalPointThreshold = 200;
        int additionalPoint = 20;
        double[] ratios = {0, 0.05, 0.1, 0.15};
        
        // call calcPrice() method
        double spent = calcPrice();
        
        // to view a value in the ratios array based on vipLevel as the index
        return (int) (((1 + ratios[vipLevel]) * calcPrice()) + 
                spent >= additionalPointThreshold ? additionalPoint : 0);

// My solution(corrected version + 1--> so points is higher than the price)
//        double regularVipRatio = 0.05
//        double goldenVipRatio = 0.10
//        double diamondVipRatio = 0.15
//        int extraPoint = 20;
//        int extraPointThreshold = 200;
//        int totalPoint = 0;
//
//        if (vipLevel == 0)
//            totalPoint = (int) calcPrice();
//        if (vipLevel == 1)
//            totalPoint = (int) (1 + regularVipRatio * calcPrice());
//        if (vipLevel == 2)
//            totalPoint = (int) (1 + goldenVipRatio * calcPrice());
//        if (vipLevel == 3)
//            totalPoint = (int) (1 + diamondVipRatio * calcPrice());   
//        
//        if (totalPoint > extraPointThreshold)
//            totalPoint += extraPoint;
//        
//        return totalPoint;
    }

    /**
     * Checkouts the items in a customer's cart. 
     * @return True if the store does have the item and the amount is enough and
     * False if not.
     */
    public boolean checkout() {
        // 1. Check items in cart if available and if bookstore has enough amount
        boolean available;
        for (Item cartItem : itemsInCart) {
            available = false;
            for (Item bookStoreItem : items) 
                if (cartItem.equals(bookStoreItem) && cartItem.amount <= bookStoreItem.amount) {
                    available = true;
                    break;
                }
            if (!available)    // this line is outside of the inner for loop
                return false;  // Checkout : failed
        }
        
        // 2. Calculate the total price 
        calcPrice();
        
        // 3. Update the amount of items in the bookstore 
        for (Item bookStoreItem : items) 
            for (Item cartItem : itemsInCart)
                if (bookStoreItem.equals(cartItem)) 
                    bookStoreItem.amount -= cartItem.amount;
        
        // 4. Update the points of the customer
        setPoint(getPoint() + calcPoint());
        
        // 5. Clear the items in the cart of the customer
        for (int i = 0; i < itemsInCart.size(); i++)
            itemsInCart.remove(i--);
        
        // 6. Checkout : Success
        return true;
    }

    /**
     * Creates a hash code for a customer object
     * @return a hash code integer value for a customer object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + super.hashCode();
        hash = 17 * hash + this.vipLevel;
        hash = 17 * hash + Objects.hashCode(this.itemsInCart);
        return hash;
    }

    /**
     * Compares if two objects are the same or not
     * @param obj the object to be compared with
     * @return True if the objects are the same and False if not
     */
    @Override    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Customer other = (Customer) obj;
        if (!super.equals(other))
            return false;
        if (this.vipLevel != other.vipLevel)
            return false;
        if (!Objects.equals(this.itemsInCart, other.itemsInCart))
            return false;
        return true;
    }

    /**
     * Creates a String that represents a customer object
     * @return a String that represents a customer object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += super.toString();
        str += String.format("%-15s : %d\n\n", "Vip Level", vipLevel);
        str += String.format("%s\n\n", "--------------------Cart Items---------------------");
        for (Item cartItem : itemsInCart) {
            str += String.format("%s\n\n", cartItem);
            str += String.format("%s\n\n", "--------------------------------------------------");
        }
        str += String.format("%-15s : $%.2f\n", "Total Price", calcPrice());
        // Uncomment if checkout is called
//        str += String.format("%-15s : %d\n", "Purchase Point", calcPoint());
//        str += String.format("%-15s : %s\n\n", "Checkout", checkout() ? "Success" : "Failed");

        return str;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public ArrayList<Item> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(ArrayList<Item> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public static int getNextCustomerId() {
        return nextCustomerId;
    }

    public static void setNextCustomerId(int nextCustomerId) {
        Customer.nextCustomerId = nextCustomerId;
    }
}
  
