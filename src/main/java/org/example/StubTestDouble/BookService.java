package org.example.StubTestDouble;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public List<Book> getDiscountPrice(int discountRate, int days){
        List<Book> allBooks = bookRepository.findAllBooks(days);

        for(Book book:allBooks){
            int price=book.getPrice();
            int newPrice=price-(discountRate*price/100);
            book.setPrice(newPrice);
        }
        return allBooks;
    }
}
