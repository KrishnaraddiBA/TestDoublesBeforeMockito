package org.example.StubTestDoubleTesting;

import org.example.StubTestDouble.BookRepository;
import org.example.StubTestDouble.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceTest {

    @Test
    public void testDiscountRateAddedCheck(){


        BookRepository bookRepository=new FakebookRepositorys();
        BookService bookService=new BookService(bookRepository);

        assertEquals(3,bookService.getDiscountPrice(10,7).size());
        assertEquals(900,bookService.getDiscountPrice(10,7).get(0).getPrice());

    }
}
