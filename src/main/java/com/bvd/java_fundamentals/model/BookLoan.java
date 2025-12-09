package com.bvd.java_fundamentals.model;

import java.time.LocalDate;

public class BookLoan {

    //loanId,memberId,loanDate,bookTitle,genre,author,daysLoaned
    //L-1001 , M-001 , 2024-06-01 , The Hobbit , Fantasy , J.R.R. Tolkien , 14 ,

    private final String loanId;
    private final String memberId;
    private final LocalDate loanDate;
    private final String bookTitle;
    private final String genre;
    private final String author;
    private final int daysLoaded;

    public BookLoan(String loanId, String memberId, LocalDate loanDate,
                    String bookTitle, String genre, String author, int daysLoaded) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.author = author;
        this.daysLoaded = daysLoaded;

    }

    public String getLoanId() {
        return loanId;
    }
    public String getMemberId() {
        return memberId;
    }
    public LocalDate getLoanDate() {
        return loanDate;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public int getDaysLoaded() {
        return daysLoaded;
    }
}
