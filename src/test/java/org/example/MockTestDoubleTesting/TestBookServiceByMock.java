package org.example.MockTestDoubleTesting;

import org.example.MockTestDouble.Book;
import org.example.MockTestDouble.BookRepository;
import org.example.MockTestDouble.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestBookServiceByMock {


    @Test
    public void saveBook(){
        BookRepository bookRepository=new MockBookRepository();
        BookService bookService=new BookService(bookRepository);
        Book book1=new Book("101","Mahabharath",500, LocalDate.now());
//        Book book2=new Book("102","Ramayan",300, LocalDate.now());
//        Book book3=new Book("103","Kalki",600, LocalDate.now());
        bookRepository.save(book1);
//        bookRepository.save(book2);
//        bookRepository.save(book3);
        

       ((MockBookRepository) bookRepository).verify(book1,1);
//        ((MockBookRepository) bookRepository).verify(book2,1);
    }

    //to test mocktestdouble by using the Mockito

    //this repplacemock test doubles by using the Mockito
    @Test
    public void saveBooks(){
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);


        Book book1=new Book("101","Mahabharath",1500,LocalDate.now());
        Book book2=new Book("102","Ramayan",500,LocalDate.now());
        Book book3=new Book("103","Kalki",600,LocalDate.now());

        bookService.saveBook(book1);
        bookService.saveBook(book2);
        bookService.saveBook(book3);

        Mockito.verify(bookRepository,Mockito.times(0)).save(book1);
        Mockito.verify(bookRepository,Mockito.times(1)).save(book2);
        Mockito.verify(bookRepository,Mockito.times(1)).save(book3);
    }
}
