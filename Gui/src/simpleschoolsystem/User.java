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
package simpleschoolsystem;

import java.io.Serializable;
import java.util.Objects;

/**
 * A simple class of User
 * @author Chilka Castro
 */
public abstract class User implements Serializable{    // BY MAKING THIS AN ABSTRACT THEN U CANT CREATE A USER OBJECT -> ADDS RESTRICTION 
    private String userName;
    private String password;
    private String fname;
    private String lname;

    /**
     * Constructor with all data members
     * @param userName the username of the user
     * @param password the password of the user
     * @param fname the first name of the user
     * @param lname the last name of the user
     */
    public User(String userName, String password, String fname, String lname) {
        this.userName = userName;           // 's' for student, 't' for teacher
        this.password = password;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    /**
     * Checks if two objects are the same or not
     * @param obj the object to be compared with
     * @return True if both are the same and False if not
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
        if (!Objects.equals(this.userName, other.userName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-10s: %s", "Username", userName);
        str += String.format("%-10s: %s", "Password", password);
        str += String.format("%-10s: %s", "First Name", fname);
        str += String.format("%-10s: %s", "Last Name", lname);
        
        return str;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    
}
