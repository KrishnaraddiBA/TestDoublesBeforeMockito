package org.example.StubTestDoubleTesting;

import org.example.StubTestDouble.Book;
import org.example.StubTestDouble.BookRepository;
import org.example.StubTestDouble.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    @Test
    public void testDiscountRateAddedCheck(){


        BookRepository bookRepository=new FakebookRepositorys();
        BookService bookService=new BookService(bookRepository);

        assertEquals(3,bookService.getDiscountPrice(10,7).size());
        assertEquals(900,bookService.getDiscountPrice(10,7).get(0).getPrice());

    }

    //by using the mockito framework we have to write a code

    //we have used a mockito framework to replace the testDoubles
    @Test
    public void testDiscountRate(){

        BookRepository bookRepository= Mockito.mock(BookRepository.class);
        BookService bookService=new BookService(bookRepository);

        List<Book> li=new ArrayList<>();

        Book book1=new Book("101","Mahabharatha",500, LocalDate.now());
        Book book2=new Book("102","Ramayan",600, LocalDate.now());
        Book book3=new Book("103","Kalki",400, LocalDate.now());
        li.add(book1);
        li.add(book2);
        li.add(book3);

        Mockito.when(bookRepository.findAllBooks(7)).thenReturn(li);

        assertEquals(3,bookService.getDiscountPrice(10,7).size());

    }


}
