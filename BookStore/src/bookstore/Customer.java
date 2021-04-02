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
     * @param itemsInCart items the customer has added to its cart(items they plan on buying)
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
        int currentPoint = getPoint();
        int updatePointCost = 50;
        int updatePointCost2 = 100;
        int updatePointCost3 = 150;
        
        if (vipLevel == 0 && currentPoint >= updatePointCost) {
            vipLevel = 1;
            return true;
        }
        if (vipLevel == 1 && currentPoint >= updatePointCost2) {
            vipLevel = 2;
            return true;
        }
        if (vipLevel == 2 && currentPoint >= updatePointCost3) {
            vipLevel = 3;
            return true;
        }
        return false; 
    }
    
    /**
     * Allows the customer to use this method to add an item to its cart.
     * @param item the item object to be deep copied
     * @param amount the amount the customer wants to buy/ or add to his/her cart
     */
    public void addItemTocart(Item item, int amount) {
        Book book;
        Book bookCartItem;
        Cd cd;
        Cd cdCartItem;
        if (item instanceof Book) {
            book = (Book) item;
            bookCartItem = new Book(book);
            bookCartItem.amount = amount;
            itemsInCart.add(bookCartItem);
        }
        if (item instanceof Cd) {
            cd = (Cd) item;
            cdCartItem = new Cd(cd);
            cdCartItem.amount = amount;
            itemsInCart.add(cdCartItem);
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
            totalPrice += (cartItem.price * cartItem.amount);
        
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
        double regularVipRatio = 0.05;
        double goldenVipRatio = 0.10;
        double diamondVipRatio = 0.15;
        int extraPoint = 20;
        int extraPointThreshold = 200;
        int totalPoint = 0;

        if (vipLevel == 0)
            totalPoint = (int) calcPrice();
        if (vipLevel == 1)
            totalPoint = (int) (regularVipRatio * calcPrice());
        if (vipLevel == 2)
            totalPoint = (int) (goldenVipRatio * calcPrice());
        if (vipLevel == 3)
            totalPoint = (int) (diamondVipRatio * calcPrice());   
        
        if (totalPoint > extraPointThreshold)
            totalPoint += extraPoint;
        
        return totalPoint;
    }

    /**
     * Checkouts the items in a customer's cart. 
     * @return True if the store does have the item and the amount is enough and
     * False if not.
     */
    public boolean checkout() {
        boolean available;
        for (Item cartItem : itemsInCart) {
            available = false;
            for (Item bookStoreItem : items) 
                if (cartItem.equals(bookStoreItem) && cartItem.amount <= bookStoreItem.amount) {
                    available = true;
                    break;
                }
            // after the inner loop
            
            if (!available)
                return false;
        }
        // pay
        calcPrice();
        
        // update the book store items
        for (Item bookStoreItem : items) {
            for (Item cartItem : itemsInCart)
                if (bookStoreItem.equals(cartItem)) 
                    bookStoreItem.amount -= cartItem.amount;
        }
        // update the points
        setPoint(getPoint() + calcPoint());
        
        // clear items in cart
        for (int i = 0; i < itemsInCart.size(); i++)
            itemsInCart.remove(i--);
        
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
        str += String.format("\t%-15s : %d\n\n", "Vip Level", vipLevel);
        str += String.format("%s\n\n", "-------------------Cart Items---------------------");
        for (Item cartItem : itemsInCart) {
            str += String.format("%s\n\n", cartItem);
            str += String.format("%s\n", "---------------------------------------------------");
        }
        str += String.format("%-15s : %d\n", "Current Point", getPoint());
        str += String.format("%-15s : $%.2f\n", "Total Price", calcPrice());
        str += String.format("%-15s : %d\n", "Purchase Point", calcPoint());
        str += String.format("%-15s : %s\n\n", "Checkout", checkout() ? "Success" : "Failed");
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
    
    public static void main(String[] args) {
        Person p1 = new Person("Haruki Murakami", "Male", "123456789", "harukimurakami@yahoo.com");
        Person p2 = new Person("John Green", "Male", "987654321", "johngreen@gmail.com");
       
        ArrayList<Person> a1 = new ArrayList<>();
        ArrayList<Person> a2 = new ArrayList<>();
        a1.add(p1);
        a1.add(p2);
       
        Book b1 = new Book("Kafka On The Shore", a1, 17.99, 50, "Fiction", true);
        Book b2 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", true);
        Cd c1 = new Cd("After Laughter", p1, 9.14, 50, "Pop Rock, New wave, Synth-pop, Power pop", false);
        Cd c2 = new Cd("Love in Tokyo", p2, 10.53, 50, "Alternative/Indie", true);
        Cd c3 = new Cd("Viva La Vida or Death and All His Friends", p1, 8.97, 50, "Rock", false);
      
        Item itemb1 = (Item) b1;
        Item itemb2 = (Item) b2;
        Item itemc1 = (Item) c1;
        Item itemc2 = (Item) c2;
        Item itemc3 = (Item) c3;
        items.add(itemb1);
        items.add(itemb2);
        items.add(itemc1);
        items.add(itemc2);
        items.add(itemc3);

//        String str = "";
//        
//        str += String.format("%-10s\n", "Bookstore Items");
//        for (Item item : items)  {
//            str += String.format("%s\n", "---------------------------------------------");
//            str += String.format("%s\n", item);
//        }
//        
//          System.out.println(str);
                  
        ArrayList<Item> items1 = new ArrayList<>();
        Customer cu2 = new Customer(1, items1, 60, "Maegan Young", "Female", 
                "12731910", "maeganyoung@gmail.com");
        cu2.addItemTocart(b2, 4);
        cu2.addItemTocart(b1, 4);
        System.out.println(cu2);
    }
   
}
  
