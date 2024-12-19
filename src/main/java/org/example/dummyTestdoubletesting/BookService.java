package org.example.dummyTestdoubletesting;

import java.util.Collection;

public class BookService {


    private BookRepository bookRepository;

    private EmailService emailService;

    //suppose if we want to implrment the emailsendingservice then it must compulsary passed in the constructorso we use dummy test double

    public BookService(BookRepository bookRepository,EmailService emailService){
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
