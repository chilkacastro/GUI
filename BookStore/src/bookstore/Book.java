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
import java.util.Objects;

/**
 * A simple class of Book
 * @author Chilka Castro
 */
public class Book extends Item {
    protected String title;
    protected ArrayList<Person> authors;
    private static int nextBookNo = 1;

    /**
     * Default constructor
     */
    public Book() {
        super();
        super.itemNo = String.format("%c%04d", 'B', nextBookNo++);
        this.title = "";
        this.authors = new ArrayList<>();
    }

    /**
     * Constructor with all data members
     * @param title the title of the book
     * @param authors the authors of the book
     * @param price the price of the item
     * @param amount the amount of the item in the store
     * @param category the category of the item
     * @param isGift if that item can be used as a gift or not
     */
    public Book(String title, ArrayList<Person> authors, double price, int amount, 
            String category, boolean isGift) {
        super(price, amount, category, isGift);
        super.itemNo = String.format("%c%04d", 'B', nextBookNo++);
        this.title = title;
        this.authors = authors;
    }
    
    /**
     * Copy constructor of Book class
     * @param book the book object to copy
     */
    public Book(Book book) {
        super(book);
        this.title = book.title;
        this.authors = new ArrayList<>(book.authors);
    }

    /**
     * Creates a hash code of a book object
     * @return a hash code integer value of a book object
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.price);
        hash = 19 * hash + Objects.hashCode(this.category);
        hash = 19 * hash + Objects.hashCode(this.title);
        hash = 19 * hash + Objects.hashCode(this.authors);
        return hash;
    }

    /**
     * Compares if two objects are the same or not
     * @param obj the object to bee compared with
     * @return True if both objects are the same and False if not
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Book other = (Book) obj;
        if (!Objects.equals(this.price, other.price))
            return false;
        if (!Objects.equals(this.category, other.category))
            return false;
        if (!Objects.equals(this.title, other.title))
            return false;
        if (!Objects.equals(this.authors, other.authors))
            return false;
        return true;
    }

    /**
     * Creates a String that represents a book object
     * @return a String that represents the book object
     */
    @Override
    public String toString() {
        String str = "";
        
        str += super.toString();
        str += String.format("%-15s : %s\n", "Title", title);
        str += String.format("%-15s : ", "Author/s");
        for (int i = 0; i < authors.size(); i++)
            if (i == authors.size() - 1)                             // no comma
                str += String.format("%s", authors.get(i).getName());
            else                                                     // w/ comma
                str += String.format("%s, ", authors.get(i).getName());
        return str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Person> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Person> authors) {
        this.authors = authors;
    }

    public static int getNextBookNo() {
        return nextBookNo;
    }

    public static void setNextBookNo(int nextBookNo) {
        Book.nextBookNo = nextBookNo;
    }
}
