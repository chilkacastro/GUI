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
 * A simple class of CD
 * @author Chilka Castro
 */
public class Cd extends Item {
    protected String name;
    protected Person artist;
    private static int nextCdNo = 1;

    /**
     * Default constructor
     */
    public Cd() {
        super();
        this.itemNo = String.format("%c%04d", 'C', nextCdNo++);
        this.name = "";
        this.artist = new Person();
    }

    /**
     * Constructor with all data members
     * @param name the name of the CD
     * @param artist the artist of the CD
     * @param price the price of the CD
     * @param amount the amount of the CD
     * @param category the category of the CD
     * @param isGift if this CD can be used as a gift or not
     */
    public Cd(String name, Person artist, double price, int amount, 
            String category, boolean isGift) {
        super(price, amount, category, isGift);
        super.itemNo = String.format("%c%04d", 'C', nextCdNo++);
        this.name = name;
        this.artist = artist;
    }
    
    /**
     * Copy constructor
     * @param cd the CD object to copy 
     */
    public Cd(Cd cd) {
        super(cd);
        this.name = cd.name;
        this.artist = new Person(cd.artist);
    }

    /**
     * Creates a hash code value for a CD object
     * @return a hash code value for a CD object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.price);
        hash = 67 * hash + Objects.hashCode(this.category);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.artist);
        return hash;
    }

    /**
     * Checks if two objects are the same or not
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
        final Cd other = (Cd) obj;
        if (!Objects.equals(this.price, other.price))
            return false;
        if (!Objects.equals(this.category, other.category))
            return false;
        if (!Objects.equals(this.name, other.name))
            return false;
        if (!Objects.equals(this.artist, other.artist))
            return false;
        return true;
    }

    /**
     * Creates a String that represents a CD object
     * @return a String that represents a CD object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += super.toString();
        str += String.format("%-15s : %s\n", "Name", name);
        str += String.format("%-15s : %s\n", "Artist", artist.getName());
        
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getArtist() {
        return artist;
    }

    public void setArtist(Person artist) {
        this.artist = artist;
    }

    public static int getNextCdNo() {
        return nextCdNo;
    }

    public static void setNextCdNo(int nextCdNo) {
        Cd.nextCdNo = nextCdNo;
    }
}
