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
 *A simple class of Person
 * @author Chilka Castro
 */
public class Person {
    private String name;
    private String gender;
    private String phoneNo;
    private String email;

    /**
     * Default constructor
     */
    public Person() {
        this.name = "";
        this.gender = "";
        this.phoneNo = "";
        this.email = "";
    }
    
    /**
     * Constructor with all data members
     * @param name the name of the person
     * @param gender the gender of the person
     * @param phoneNo the phone number of the person
     * @param email the email of the person
     */
    public Person(String name, String gender, String phoneNo, String email) {
        this.name = name;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    
    /**
     * Copy constructor
     * @param person the person object to copy
     */
    public Person(Person person) {
        this.name = person.name;
        this.gender = person.gender;
        this.phoneNo = person.phoneNo;
        this.email = person.email;
    }

    /**
     * Creates a hash code integer value for a person object
     * @return a hash code integer value for a person object
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.gender);
        hash = 83 * hash + Objects.hashCode(this.phoneNo);
        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    /**
     * Checks if two objects are the same or not
     * @param obj the object to be compared with
     * @return True if the objects are the same or not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name))
            return false;
        if (!Objects.equals(this.gender, other.gender))
            return false;
        if (!Objects.equals(this.phoneNo, other.phoneNo))
            return false;
        if (!Objects.equals(this.email, other.email))
            return false;
        return true;
    }

    /**
     * Creates a String that represents a person object
     * @return a String that represents a person object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("\t%-15s : %s\n", "Name", name);
        str += String.format("\t%-15s : %s\n", "Gender", gender);
        str += String.format("\t%-15s : %s\n", "Phone Number", phoneNo);
        str += String.format("\t%-15s : %s\n", "Email", email);
        
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
