package org.example.MockTestDoubleTesting;

import org.example.MockTestDouble.Book;
import org.example.MockTestDouble.BookRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockBookRepository implements BookRepository {
    int count=0;
    Book book=null;

    @Override
    public void save(Book book) {
        count++;
        this.book=book;
    }

    public void  verify(Book book,int times){
        assertEquals(times,count);
        assertEquals(this.book,book);
    }
}
