package org.example.FakeTestDoubleTesting;


//basically instead of testing external factors we can make use of TestDoubles by replacing the external factors
//normally they are called as testdoubles
//in test doubles there are 5 types they are Fake,Spy,Mock,Stub,Dummy etc

import org.example.FakeDoubleTesting.Book;
import org.example.FakeDoubleTesting.BookRepository;
import org.example.FakeDoubleTesting.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//instead of creating the external factors like database ,httpRequest and queue we can make use of inmemmory database
//List or Map like this
public class BookserviceTest {


    @Test
    public void testsaveBookingApp(){

        BookRepository bookRepository=new FakeBookRepository();
        BookService bookService=new BookService(bookRepository);
        Book book=new Book("101","Bhagvatgita",1000, LocalDate.now());
        Book book2=new Book("102","Ramayana",1000, LocalDate.now());
        Book book3=new Book("103","Sri Venkateshwara mahime",1000, LocalDate.now());

        bookService.saveBooks(book);
        bookService.saveBooks(book2);
        bookService.saveBooks(book3);

        assertEquals(3,bookService.findSizeOfBooks());
    }

    //By using mockito replacing the Fake test double

    @Test
    public void testsaveBookingByUsingMockitoApp(){

        //we have to write a test cases according to arrange,act and assert
        //arrange
        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);
        Collection<Book> col=new ArrayList<>();
        //act
        Book book1=new Book("101","Mahabharatha",500,LocalDate.now());
        Book book2=new Book("102","Ramayan",600,LocalDate.now());
        Book book3=new Book("103","Kalki",550,LocalDate.now());
        col.add(book1);
        col.add(book2);
        col.add(book3);
        Mockito.when(bookRepository.findAll()).thenReturn(col);
        //assert
        assertEquals(3,bookService.findAll().size());
        assertEquals("Mahabharatha",bookService.findAll().stream().findFirst().get().getTitle());
    }



}
