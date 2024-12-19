package org.example.dummyTestdoubletesting;

import java.util.Collection;

public interface BookRepository {

    public void save(Book book);

    public Collection<Book> findAll();

    public int findSizeOfBooks();

}
