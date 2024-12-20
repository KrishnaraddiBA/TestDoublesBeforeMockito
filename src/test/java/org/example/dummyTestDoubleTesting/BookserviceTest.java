package org.example.dummyTestDoubleTesting;


//basically instead of testing external factors we can make use of TestDoubles by replacing the external factors
//normally they are called as testdoubles
//in test doubles there are 5 types they are Fake,Spy,Mock,Stub,Dummy etc


import org.example.dummyTestdoubletesting.Book;
import org.example.dummyTestdoubletesting.BookRepository;
import org.example.dummyTestdoubletesting.BookService;
import org.example.dummyTestdoubletesting.EmailService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//instead of creating the external factors like database ,httpRequest and queue we can make use of inmemmory database
//List or Map like this
public class BookserviceTest {


    @Test
    public void testsaveBookingApp(){

        BookRepository bookRepository=new FakeBookRepository();

        EmailService emailService=new FakeEmailSendingService();
        BookService bookService=new BookService(bookRepository,emailService);
        Book book=new Book("101","Bhagvatgita",1000, LocalDate.now());
        Book book2=new Book("102","Ramayana",1000, LocalDate.now());
        Book book3=new Book("103","Sri Venkateshwara mahime",1000, LocalDate.now());

        bookService.saveBooks(book);
        bookService.saveBooks(book2);
        bookService.saveBooks(book3);

        assertEquals(3,bookService.findSizeOfBooks());
    }

    //using the mockito framework we have to test booking app when we saved

    @Test
    public void testsaveBookingAppByUsingmockito(){

        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        //now we have to satisfy compiler by using mockito not to depend dummy external service by using mockito will satisfy
        EmailService emailService=Mockito.mock(EmailService.class);
        BookService bookService=new BookService(bookRepository,emailService);

        List<Book> li=new ArrayList<>();
        Book book=new Book("101","Bhagvatgita",1000, LocalDate.now());
        Book book2=new Book("102","Ramayana",1000, LocalDate.now());
        Book book3=new Book("103","Sri Venkateshwara mahime",1000, LocalDate.now());
        li.add(book);
        li.add(book2);
        li.add(book3);

        Mockito.when(bookRepository.findAll()).thenReturn(li);

        assertEquals(3,bookService.findAll().size());

    }



}
