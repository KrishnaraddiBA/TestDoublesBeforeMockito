package org.example.SpyTestdouble;

import org.example.SpyTestdouble.Bookrepository;
public class BookService {


    private Bookrepository bookRepository;

    public BookService(Bookrepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void savebooks(Book book){
        bookRepository.save(book);
    }
}
