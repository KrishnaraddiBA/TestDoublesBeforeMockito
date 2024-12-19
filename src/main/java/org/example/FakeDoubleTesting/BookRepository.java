package org.example.FakeDoubleTesting;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    public void save(Book book);

    public Collection<Book> findAll();

    public int findSizeOfBooks();

}
