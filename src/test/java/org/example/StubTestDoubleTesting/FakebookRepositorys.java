package org.example.StubTestDoubleTesting;

import org.example.StubTestDouble.Book;
import org.example.StubTestDouble.BookRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FakebookRepositorys implements BookRepository {

    Map<String,Book> map=new LinkedHashMap<>();


    @Override
    public List<Book> findAllBooks(int days) {

        Book book1=new Book("101","Mahabharatha",1000,LocalDate.now());
        Book book2=new Book("102","Ramayana",1000,LocalDate.now());
        Book book3=new Book("103","Kalki",1000,LocalDate.now());

        map.put(book1.getBookId(),book1);
        map.put(book2.getBookId(),book2);
        map.put(book3.getBookId(),book3);
        List<Book> list = map.values().stream().toList();
        return list;
    }
}
