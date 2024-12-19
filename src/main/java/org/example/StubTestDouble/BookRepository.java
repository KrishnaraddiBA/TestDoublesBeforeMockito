package org.example.StubTestDouble;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    public List<Book> findAllBooks(int days);

}
