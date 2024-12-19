package org.example.FakeDoubleTesting;

import java.util.Collection;

public class BookService {


    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public void saveBooks(Book book){
        bookRepository.save(book);
    }

    public Collection<Book> findAll(){
        return bookRepository.findAll();
    }

    public int findSizeOfBooks(){
        return bookRepository.findSizeOfBooks();
    }
}
