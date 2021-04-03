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
     * @return True if user can exchange it for gift and False if not
     */
    @Override
    public boolean pointToGift() {
        // 1.  Check first the user points if its lower than the gift points cost
        int giftPoint = 50;
        if (getPoint() < giftPoint)
            return false;

        // 2. Items that can be used as gift
        ArrayList<Item> giftItems = new ArrayList<>();
        
        for (Item bookStoreItem : items) {
            if (bookStoreItem.isGift && bookStoreItem.amount > 0)
                giftItems.add(bookStoreItem);
        }
        // 3. Get the random gift
        Random rand = new Random();
        Item item = giftItems.get(rand.nextInt(giftItems.size()));
        
        // 4. Reduce the amount of the bookstore item
        for (Item bookStoreItem : items) 
            if (bookStoreItem.equals(item))
                bookStoreItem.amount--;
        
        // 5. Reduce the points of the user
        setPoint(getPoint() - giftPoint);
  
        return true;
    }

    /**
     * Finds a random gift of specific type
     * @param type the gift type of the item that the user wants
     * @return True if the user can exchange it for a gift and False if not
     */
    @Override
    public boolean pointToGift(String type) {
        // 1. Check first the user points if its lower than the gift points cost
        int giftPoint = 70;
        if (getPoint() < giftPoint)
            return false;

        // 2. Items that can be used as gift
        ArrayList<Item> bookGiftItems = new ArrayList<>();
        ArrayList<Item> cdGiftItems = new ArrayList<>();
        for (Item bookStoreItem : items) {
            if (bookStoreItem instanceof Book && bookStoreItem.isGift 
                    && bookStoreItem.amount > 0)
                bookGiftItems.add(bookStoreItem);
            if (bookStoreItem instanceof  Cd && bookStoreItem.isGift 
                    && bookStoreItem.amount > 0)
                cdGiftItems.add(bookStoreItem);      
        }
        // 3. Get the random gift
        Random rand = new Random();
        Item item;

        if (type.equalsIgnoreCase("book")) {
            item = bookGiftItems.get(rand.nextInt(bookGiftItems.size()));
            for (Item bookStoreItem : items) 
                if (bookStoreItem.equals(item))
                    bookStoreItem.amount--;
        }
        if (type.equalsIgnoreCase("cd")) {
            item = cdGiftItems.get(rand.nextInt(bookGiftItems.size()));
            for (Item bookStoreItem : items) 
                if (bookStoreItem.equals(item))
                    bookStoreItem.amount--;
        }
        
        // 4. Reduce the points of the user
        setPoint(getPoint() - giftPoint);
  
        return true;
    }

    /**
     * Finds a specific gift 
     * @param item input item that the user wants
     * @return True if the customer can exchange it for a gift and False if not
     */
    @Override
    public boolean pointToGift(Item item) {
        // 1. Checks if customer has enough points to use as payment for a gift
        int giftPoint = 100;
        if (getPoint() < giftPoint)
            return false;
        
        // 2. Take only the items that can be used as a gift
        ArrayList<Item> giftItems = new ArrayList<>();
        for (Item bookStoreItem : items) {
            if (!bookStoreItem.isGift) {
                if (bookStoreItem.equals(item)) 
                    return false;
            }
            else {
                if (bookStoreItem.amount > 0) {
                    if (bookStoreItem.equals(item)) 
                        giftItems.add(bookStoreItem);
                }
                else                            // if store item is out of stock
                    return false;
            }
        }
        
        // 3. Find the item in the gift items collection 
        boolean isItemFound;
        for (Item giftItem : giftItems) {
            isItemFound = false;
            for (Item bookStoreItem : items) {
                if (giftItem.equals(item) && giftItem.equals(bookStoreItem)) {
                    isItemFound = true;
                    bookStoreItem.amount--;        // reduce amount of that item
                    break;
                }
            }
            if (isItemFound)        // only need to find 1 item, stop when found
                break;
        }
        
        // 4. Pay gift with points(reduce customer points)
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
     * Creates a String that represents a user
     * @return a String that represents a user
     */
    @Override
    public String toString() {
        String str = "";
        
        str += super.toString();
        str += String.format("%-15s : %s\n", "Id", id);
        str += String.format("%-15s : %d\n", "Point", point);
        
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
    public static void main(String[] args) {
        Person p1 = new Person("Haruki Murakami", "Male", "123456789", "harukimurakami@yahoo.com");
        Person p2 = new Person("John Green", "Male", "987654321", "johngreen@gmail.com");
       
        ArrayList<Person> a1 = new ArrayList<>();
        ArrayList<Person> a2 = new ArrayList<>();
        a1.add(p1);
        a1.add(p2);
       
        Book b1 = new Book("Kafka On The Shore", a1, 17.99, 50, "Fiction", false);
        Book b3 = new Book("Kafka On The Shore", a1, 17.99, 150, "Fiction", false);
        Book b2 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", false);
        Book b4 = new Book("The Invisible life of Addie LaRue", a1, 17.99, 50, "Fiction", true);
        Book b5 = new Book("Nowegian Wood", a1, 17.99, 60, "Fiction", true);
       // Book b6 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", true);
        Book b7 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", true);
        Book b8 = new Book("Echo North", a1, 17.99, 50, "Fiction", false);
        Cd c1 = new Cd("After Laughter", p1, 9.14, 50, "Pop Rock, New wave, Synth-pop, Power pop", false);
        Cd c2 = new Cd("Love in Tokyo", p2, 10.53, 1, "Alternative/Indie", true);
        Cd c3 = new Cd("Viva La Vida or Death and All His Friends", p1, 8.97, 1, "Rock", true);

        items.add(b4); //true
        items.add(b3); //false
        items.add(c1);//false
        items.add(c2);//true
        items.add(c3); //false
        items.add(b2); //false
        items.add(b1); //false
        items.add(b8); // true
        items.add(c3);//false

       
        ArrayList<Item> items1 = new ArrayList<>();
        Customer cu2 = new Customer(1, items1, 100, "Maegan Young", "Female", 
                "12731910", "maeganyoung@gmail.com");

//        cu2.addItemTocart(b2, 4);
//        cu2.addItemTocart(b1, 4);
//        System.out.println(cu2);
          System.out.println(cu2.pointToGift());
    }
}
