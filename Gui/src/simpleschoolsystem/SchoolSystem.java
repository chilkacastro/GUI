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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * A simple class of School System
 * @author Chilka Castro
 */
public class SchoolSystem {
    protected static ArrayList<User> users;
    
    /**
     * To load the stored data or the serialized data back to an array list of users
     */
    public static void intiData() {
        String path = "users.ser";
        File userFile = new File(path); // need this so we can use the .isFile() method to check if it already exists physically on the table
        
        if (userFile.isFile())
            users = (ArrayList<User>) deserializeData(path);
        else
            users = new ArrayList<>();  // if it isnt a file then create a new arraylist of user so we can store the users externally 
    }
    
    /**
     * Serializes data into a file
     * @param path the path of the file
     * @param object the data to be serialized
     */
    public static void serializeData(String path, Object object) {              // can be boolean too (true for success and false for failure)    | or int 0  or 1 but it means something
        try (FileOutputStream fos = new FileOutputStream(path)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);        
        } catch (Exception e) {
            
        }  
    }
    
    /**
     * De-serializes a file to data
     * @param path the path of the file
     * @return the de-serialize object
     */
    public static Object deserializeData(String path) {                         // if you want it to be general then just use the return type Object
        Object object = null;
        try (FileInputStream fis = new FileInputStream(path)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = ois.readObject();                                            
        } catch (Exception e) {
            
        }
        return object;
        
    }
           
}
