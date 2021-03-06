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

import java.util.ArrayList;

/**
 * A simple class of a BookStore
 * @author Chilka Castro
 */
public class BookStore {
    protected static ArrayList<Item> items = new ArrayList<>();
    protected static ArrayList<Employee> employees = new ArrayList<>();
    protected static ArrayList<Customer> customers = new ArrayList<>();

    /**
     * Adds an item object into the items list
     * @param item the item to be added
     */
    private static void addItem(Item item) {
        boolean isItemFound = false;
        if (item instanceof Book) 
            item = (Book) item;
        else 
            item = (Cd) item;
        
        for (Item bookStoreItem : items) {
            if (bookStoreItem.equals(item)) {
                isItemFound = true;
                bookStoreItem.amount += item.amount; 
                break;
            }  
        }
        if (!isItemFound)
            items.add(item);
    }

    /**
     * Adds an employee object into the employees list
     * @param employee the employee object  to be added
     */
    private static void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    /**
     * Adds a customer object  into the customer list
     * @param customer the customer object to be added
     */
    private static void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    /**
     * Searches items based on the input keyword
     * @param keyword the input keyword to look for in the item title/name
     * @return a collection of items that has the input keyword in their titles
     * or names
     */
    private static ArrayList<Item> searchItem(String keyword) {
        keyword = keyword.toLowerCase();
        ArrayList<Item> searchedItems = new ArrayList<>();
        
        for (Item item : items) {
            if (item instanceof Book)
                if (((Book) item).title.toLowerCase().contains(keyword))
                    searchedItems.add(item);
            else                                      // if (item instanceof Cd)
                if (((Cd) item).name.toLowerCase().contains(keyword))
                    searchedItems.add(item);
        }    
        return searchedItems;    
    }       
    
    /**
     * Pays points to each employee and update the employee's points
     */
    private static void payEmployeesPoints() {
        for (Employee employee : employees)
            employee.setPoint(employee.getPoint() + employee.calcPoint());
    }
    
    public static ArrayList<Item> getItems() {
        return items;
    }

    public static void setItems(ArrayList<Item> items) {
        BookStore.items = items;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        BookStore.employees = employees;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        BookStore.customers = customers;
    }

    public static void main(String[] args) {
        // Author/s and Artist
        Person p1 = new Person("Haruki Murakami", "Male", "123456789", "harukimurakami@yahoo.com");
        Person p2 = new Person("John Green", "Male", "987654321", "johngreen@gmail.com");
       
        ArrayList<Person> a1 = new ArrayList<>();
        a1.add(p1);
        a1.add(p2);
       
        Book b1 = new Book("Kafka On The Shore", a1, 17.99, 50, "Fiction", true);
        Book b3 = new Book("Kafka On The Shore", a1, 17.99, 150, "Fiction", true);
        Book b10 = new Book("Kafka On The Shore", a1, 17.99, 150, "Fiction", true);
        Book b11 = new Book("Kafka On The Shore", a1, 17.99, 100, "Fiction", true);
        Book b2 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", true);
        Book b4 = new Book("The Invisible life of Addie LaRue", a1, 17.99, 50, "Fiction", true);
        Book b5 = new Book("Norwegian Wood", a1, 17.99, 60, "Fiction", true);
        Book b6 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", true);
        Book b7 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 50, "Fiction", true);
        Book b12 = new Book("Colorless Tsukuru Tazaki", a1, 17.99, 230, "Fiction", true);
        Book b8 = new Book("Echo North", a1, 17.99, 50, "Fiction", true);
        Book b9 = new Book("Echo North", a1, 17.99, 120, "Fiction", true);
        Cd c1 = new Cd("After Laughter", p1, 9.14, 50, "Pop Rock, New wave, Synth-pop, Power pop", false);
        Cd c2 = new Cd("Love in Tokyo", p2, 10.53, 50, "Alternative/Indie", true);
        Cd c3 = new Cd("Viva La Vida or Death and All His Friends", p1, 8.97, 50, "Rock", false);
        Cd c4 = new Cd("Viva La Vida or Death and All His Friends", p1, 8.97, 50, "Rock", false);

        // adding items to BookStore 
        items.add(b1);
        items.add(b8);
        items.add(c3);
        
        // using the static method addItem of BookStore (just to check if it works)
        BookStore.addItem(c4);
        BookStore.addItem(b9);
        BookStore.addItem(b10);
        BookStore.addItem(b11);
        BookStore.addItem(b7);
        BookStore.addItem(b12);
        BookStore.addItem(b5);
        BookStore.addItem(b3);

        // prints all the items in the bookstore
        String str = "";
        
        str += String.format("%-10s\n", "Bookstore Items");
        for (Item item : items)  {
            str += String.format("%s\n", "---------------------------------------------");
            str += String.format("%s\n", item);
        }
        System.out.println(str);
        
        // Customer (uncomment if you want to try and play with the customer)
//        ArrayList<Item> customerCart = new ArrayList<>();
//        Customer cu2 = new Customer(1, customerCart, 200, "Maegan Young", "Female", 
//                "12731910", "maeganyoung@gmail.com");
//        cu2.addItemToCart(b2, 4);
//        cu2.addItemToCart(b1, 7);
//        System.out.println(cu2); // calls toString of Customer class
//        System.out.println(cu2.pointToGift(c2));
    }
}


