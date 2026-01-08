package com.bvd.java_fundamentals.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookLoan {

    //loanId,memberId,loanDate,bookTitle,genre,author,daysLoaned
    //L-1001 , M-001 , 2024-06-01 , The Hobbit , Fantasy , J.R.R. Tolkien , 14 ,

    private final String loanId;
    private final String memberId;
    private final LocalDate loanDate;
    private final String bookTitle;
    private final String genre;
    private final String author;
    private final int daysLoaned;

    @JsonCreator
    public BookLoan(@JsonProperty("loanId") String loanId,
                    @JsonProperty("memberId") String memberId,
                    @JsonProperty("loanDate") LocalDate loanDate,
                    @JsonProperty("bookTitle") String bookTitle,
                    @JsonProperty("genre") String genre,
                    @JsonProperty("author") String author,
                    @JsonProperty("daysLoaned") int daysLoaned) {
        this.loanId = loanId;
        this.memberId = memberId;
        this.loanDate = loanDate;
        this.bookTitle = bookTitle;
        this.genre = genre;
        this.author = author;
        this.daysLoaned = daysLoaned;

    }



}
