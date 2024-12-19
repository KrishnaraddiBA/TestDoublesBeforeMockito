package org.example.StubTestDouble;



import java.time.LocalDate;

public class Book {

    private String bookId;
    private String booktitle;
    private int price;
    private LocalDate localDate;

    public Book(String bookId, String booktitle, int price, LocalDate localDate) {
        this.bookId = bookId;
        this.booktitle = booktitle;
        this.price = price;
        this.localDate = localDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
