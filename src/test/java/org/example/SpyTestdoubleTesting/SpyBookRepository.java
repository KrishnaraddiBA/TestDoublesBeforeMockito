package org.example.SpyTestdoubleTesting;

import org.example.SpyTestdouble.Book;
import org.example.SpyTestdouble.Bookrepository;


//in a spy what we do is that will count the data how many times it got saved and or to maintain records which the last book saved
//and how much count did it has
public class SpyBookRepository implements Bookrepository {


    int count=0;
    Book book;
    @Override
    public void save(Book book) {
        count++;
        this.book=book;
    }

    public int totalNumberOfCountDidItCall(){
        return count;
    }

    public Book lastBooksgotAdded(){
        return book;
    }
}
