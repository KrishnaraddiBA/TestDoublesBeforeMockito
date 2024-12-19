package org.example.FakeTestDoubleTesting;

import org.example.FakeDoubleTesting.Book;
import org.example.FakeDoubleTesting.BookRepository;
import org.example.FakeDoubleTesting.BookService;

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
