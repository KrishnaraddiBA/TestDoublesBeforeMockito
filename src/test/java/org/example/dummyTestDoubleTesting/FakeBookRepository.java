package org.example.dummyTestDoubleTesting;



import org.example.dummyTestdoubletesting.Book;
import org.example.dummyTestdoubletesting.BookRepository;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {

    Map<String, Book> fakeBooks=new LinkedHashMap<>();


    @Override
    public void save(Book book) {
        fakeBooks.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {

        Collection<Book> values = fakeBooks.values();
        return values;
    }

    @Override
    public int findSizeOfBooks() {
        int size = fakeBooks.values().size();
        return size;
    }
}
