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
 * A Gift interface
 * @author Chilka Castro
 */
public interface Gift {
    
    /**
     * Finds a random gift, could be a book or a CD
     * @return True if the user have enough point to exchange points for a gift
     * and False if not.
     */
    public boolean pointToGift();
    
    /**
     * Finds a random gift of a specific type
     * @param type input type of the gift the user wants
     * @return True if the user have enough point to exchange points for a gift
     * and False if not.
     */
    public boolean pointToGift(String type);
    
    /**
     * Finds a specific gift 
     * @param item the specific item the user wants
     * @return True if the user have enough point to exchange points for a gift
     * and False if not.
     */
    public boolean pointToGift(Item item);
}
