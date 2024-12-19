package org.example.MockTestDouble;



public class BookService {


    private BookRepository bookrepository;

    public BookService(BookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }

    public void saveBook(Book book){
        if (book.getPrice()>1000){
            return;
        }
        bookrepository.save(book);
    }
}
