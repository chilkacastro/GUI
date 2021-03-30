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
    protected static ArrayList<Item> items;
    protected static ArrayList<Employee> employees;
    protected static ArrayList<Customer> customers;

    /**
     * Adds an item object into the items list
     * @param item the item to be added
     */
    public static void addItem(Item item) {
        for (Item bookStoreItem: items) 
            if (bookStoreItem.equals(item))
                bookStoreItem.setAmount(bookStoreItem.amount + item.amount);
        items.add(item);
    } 
    
    /**
     * Adds an employee object into the employees list
     * @param employee the employee object  to be added
     */
    public static void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    /**
     * Adds a customer object  into the customer list
     * @param customer the customer object to be added
     */
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }
    
    public static ArrayList<Item> searchItem(String keyword) {
        ArrayList<Item> searchedItems = new ArrayList<>();
        
        for (Item item : items) {
            if (item instanceof Book)
                if (((Book) item).title.contains(keyword))
                    searchedItems.add(item);
            if (item instanceof Cd)
                if (((Cd) item).name.contains(keyword))
                    searchedItems.add(item);
        }    
        return searchedItems;    
    }       
    
    /**
     * Pays points to each employee and update the employee's points
     */
    public static void payEmployeesPoint() {
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
    
    // Main Method
    public static void main(String[] args) {
        Person p1 = new Person("Haruki Murakami", "Male", "123456789", "harukimurakami@yahoo.com");
        Person p2 = new Person("Haruki Murakami2", "Male", "0987654132", "harukimurakami02@yahoo.com");
        Person p3 = new Person("Haruki Murakami3", "Male", "16231839242", "harukimurakami03@yahoo.com");
        ArrayList<Person> a1 = new ArrayList<>();
        a1.add(p1);
        a1.add(p2);
        a1.add(p3);
        Book b1 = new Book("Kafka On The Shore", a1, 17.99, 50, "Fiction", true);
        System.out.println(b1);
    }
}
