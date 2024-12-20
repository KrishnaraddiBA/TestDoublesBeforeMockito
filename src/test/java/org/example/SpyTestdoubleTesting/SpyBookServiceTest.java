package org.example.SpyTestdoubleTesting;

import org.example.SpyTestdouble.Book;
import org.example.SpyTestdouble.BookService;
import org.example.SpyTestdouble.Bookrepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpyBookServiceTest {


    @Test
    public void verifySave(){
        Bookrepository bookrepository=new SpyBookRepository();
        Book book1=new Book("101","Ramayan",1500, LocalDate.now());
        Book book2=new Book("102","Mahabharat",1600, LocalDate.now());
        Book book3=new Book("103","Kalki",1700, LocalDate.now());

        bookrepository.save(book1);
        bookrepository.save(book2);
        bookrepository.save(book3);

        assertEquals(3, ((SpyBookRepository) bookrepository).totalNumberOfCountDidItCall());
        assertEquals("Kalki",((SpyBookRepository) bookrepository).lastBooksgotAdded().getTitle());
    }

    //now replacing the spy with the mockito
    @Test
    public void verifySaves(){
        Bookrepository bookrepository= Mockito.spy(Bookrepository.class);
        BookService bookService=new BookService(bookrepository);

        Book book1=new Book("101","Mahabharath",900,LocalDate.now()) ;
        Book book2=new Book("102","Ramayan",700,LocalDate.now()) ;
        Book book3=new Book("103","Kalki",900,LocalDate.now()) ;
       bookService.savebooks(book1);
        bookService.savebooks(book2);
        bookService.savebooks(book3);
        //spy is differnt as compared to mocking of data will learn detail in the theory episode
        Mockito.verify(bookrepository,Mockito.times(1)).save(book1);
        Mockito.verify(bookrepository,Mockito.times(1)).save(book2);
        Mockito.verify(bookrepository,Mockito.times(1)).save(book3);


    }
}
