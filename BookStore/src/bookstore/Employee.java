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
import java.util.Random;

/**
 * A simple class of Employee
 * @author Chilka Castro
 */
public class Employee extends User {
    private double salary;
    private static int nextEmployeeId = 1;


    /**
     * Default constructor
     */
    public Employee() {
        super();
        super.setId(String.format("%c%04d", 'E', nextEmployeeId++));
        this.salary = -1;
    }
    
    /**
     * Constructor with all data members
     * @param salary the salary of the employee
     * @param point the amount of points of the employee
     * @param name the name of the employee
     * @param gender the gender of the employee
     * @param phoneNo the phone number of the employee
     * @param email the email of the employee
     */
    public Employee(double salary, int point, String name, 
            String gender, String phoneNo, String email) {
        super(point, name, gender, phoneNo, email);
        super.setId(String.format("%c%04d", 'E', nextEmployeeId++));
        this.salary = salary;
    }
     
    /**
     * Copy constructor
     * @param employee the employee object to copy
     */
    public Employee(Employee employee) {
        super(employee);
        this.salary = employee.salary;
    }

    /**
     * Calculates the points for an employee 
     * @return the amount of points of the employee
     */
    @Override
    public int calcPoint() {
        double salaryRatio = 0.01;
        
        int point = 0;
        point += (int) salary * salaryRatio;
        
        return point;
    }
    
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
     * @param item item that the employee wants
     * @return True if the employee can exchange it for a gift and False if not
     */
    @Override
    public boolean pointToGift(Item item) {
        int giftPoint = 100;

        if (getPoint() < giftPoint)
            return false;
   
        // Items that can be used as gift | isGift is TRUE
        ArrayList<Item> giftItems = new ArrayList<>();
        for (Item bookStoreItem : items) 
            if (bookStoreItem.isGift && bookStoreItem.amount > 0)
                giftItems.add(bookStoreItem);
        
        // finds the specific gift the employee wants 
        for (Item giftItem : giftItems) 
            for (Item bookStoreItem : items)
                if (giftItem.equals(item))
                    bookStoreItem.amount--;
        
        setPoint(getPoint() - giftPoint);
               
        return true;
    }
    
    /**
     * Creates a hash code for the employee object
     * @return a hash code integer value for the employee object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + super.hashCode();
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.salary) 
                ^ (Double.doubleToLongBits(this.salary) >>> 32));
        return hash;
    }

    /**
     * Checks if two objects are the same or not
     * @param obj the object to compare with
     * @return True if both object are the same and False if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Employee other = (Employee) obj;
        if (!super.equals(other))
            return false;
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary))
            return false;
        return true;
    }

    /**
     * Creates a String that represents an employee object
     * @return a String that represents an employee object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += super.toString();
        str += String.format("%-10s : %.2f\n", "Salary", salary);
        
        return str;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getNextEmployeeId() {
        return nextEmployeeId;
    }

    public static void setNextEmployeeId(int nextEmployeeId) {
        Employee.nextEmployeeId = nextEmployeeId;
    }
}
