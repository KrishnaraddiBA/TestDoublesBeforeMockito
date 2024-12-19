package org.example.SpyTestdoubleTesting;

import org.example.SpyTestdouble.Book;
import org.example.SpyTestdouble.Bookrepository;
import org.junit.jupiter.api.Test;

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
}
