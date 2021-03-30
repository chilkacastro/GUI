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
import java.util.Random;

/**
 * A simp;e class of User
 * @author Chilka Castro
 */
public abstract class User extends Person implements Gift {
    private String id;
    private int point;

    /**
     * Default constructor
     */
    public User() {
        super();
        this.id = "";
        this.point = -1;
    }
    
    /**
     * Constructor with all data members
     * @param point the amount of points of the user
     * @param name the name of the user
     * @param gender the gender of the user
     * @param phoneNo the phoneNo of the user
     * @param email the email of the user
     */
    public User(int point, String name, String gender, String phoneNo, 
            String email) {
        super(name, gender, phoneNo, email);
        this.id = "";
        this.point = point;
    }
    
    /**
     * Copy constructor
     * @param user the user object to copy 
     */
    public User(User user) {
        super(user);
        this.id = user.id;
        this.point = user.point;
    }
    
    /**
     * An abstract method to calculate points for a user
     * @return the points for a user
     */
    public abstract int calcPoint();

    /**
     * Finds a random gift, could be a book or a CD
     * @return True if customer can exchange it for gift and False if not
     */
    @Override
    public boolean pointToGift() {
        // Check first the user points if its lower than the gift points cost
        int giftPoint = 50;
        if (getPoint() < giftPoint)
            return false;

        // Items that can be used as gift
        ArrayList<Item> giftItems = new ArrayList<>();
        
        for (Item bookStoreItem : items) {
            if (bookStoreItem.isGift && bookStoreItem.amount > 0)
                giftItems.add(bookStoreItem);
        }
        // get the random gift
        Random rand = new Random();
        Item item = giftItems.get(rand.nextInt(giftItems.size()));
        item.amount--;
        
        // reduce the points of the user
        setPoint(getPoint() - giftPoint);
  
        return true;
    }

    /**
     * Finds a random gift of specific type
     * @param type the gift type of the item that the customer wants
     * @return True if the customer can exchange it for a gift and False if not
     */
    @Override
    public boolean pointToGift(String type) {
        // Check first the user points if its lower than the gift points cost
        int giftPoint = 70;
        if (getPoint() < giftPoint)
            return false;

        // Items that can be used as gift
        ArrayList<Item> giftItems = new ArrayList<>();
        for (Item bookStoreItem : items) {
            if (bookStoreItem instanceof Book && type.equalsIgnoreCase("book") 
                    && bookStoreItem.isGift && bookStoreItem.amount > 0)
                    giftItems.add(bookStoreItem);
            if (bookStoreItem instanceof  Cd && type.equalsIgnoreCase("cd") 
                    && bookStoreItem.isGift && bookStoreItem.amount > 0)
                    giftItems.add(bookStoreItem);      
        }
        // get the random gift
        Random rand = new Random();
        Item item = giftItems.get(rand.nextInt(giftItems.size()));
        item.amount--;
        
        // reduce the points of the user
        setPoint(getPoint() - giftPoint);
  
        return true;
    }

    /**
     * Finds a specific gift based on the itemNo
     * @param item item that the customer wants
     * @return True if the customer can exchange it for a gift and False if not
     */
    @Override
    public boolean pointToGift(Item item) {
        // Checks if customer has enough points to use as payment for a gift
        int giftPoint = 100;
        if (getPoint() < giftPoint)
            return false;
        
        // Items that can be used as gift | isGift is TRUE
        ArrayList<Item> giftItems = new ArrayList<>();
        for (Item bookStoreItem : items) 
            if (bookStoreItem.isGift && bookStoreItem.amount > 0)
                giftItems.add(bookStoreItem);
      
        for (Item giftItem : giftItems) {
            for (Item bookStoreItem : items)
                if (giftItem.equals(item) && giftItem.equals(bookStoreItem)) {
                    bookStoreItem.amount--;
                    break;
                }
            break;
        }
        
        // Pay gift with points(reduce customer points)
        setPoint(getPoint() - giftPoint);
               
        return true;
    }
    /**
     * Creates a hash code for a user 
     * @return a hash code value for a user
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + super.hashCode();
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + this.point;
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
        final User other = (User) obj;
        if(!super.equals(other))
            return false;
        if (this.point != other.point)
            return false;
        if (!Objects.equals(this.id, other.id))
            return false;
        return true;
    }

    /**
     * Creates a String that represents the User Class
     * @return a String that represents a User Class
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s : %s\n", "Id", id);
        str += String.format("%-10s : %d\n", "Point", point);
        
        return str;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
