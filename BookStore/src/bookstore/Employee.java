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
     * Calculates the points of an employee 
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
        str += String.format("%-15s : %.2f\n", "Salary", salary);
        
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
