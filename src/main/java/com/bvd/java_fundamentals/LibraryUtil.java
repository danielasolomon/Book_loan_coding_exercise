package com.bvd.java_fundamentals;

import com.bvd.java_fundamentals.model.BookLoan;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

/*
 * Implement the methods below so that the requirements are met.
 */
public class LibraryUtil {

    // private constructor to prevent instantiation
    private LibraryUtil() {
    }

    // load resource file from resources folder
    static List<String> loadResourceFile(final String fileName) {

        var classLoader = LibraryUtil.class.getClassLoader();
        var resource = classLoader.getResourceAsStream(fileName);

        if (resource == null) {
            return Collections.emptyList();
        }

        var read = new BufferedReader(new InputStreamReader(resource));

        try (read) {
            return read.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }

    }

    // retrieve loans from csv lines
    // return a map of "valid" and "malformed" lines as keys and list of BookLoan objects as values
    protected static Map<String, List<BookLoan>> parseCsvLines(final List<String> file) {


        //loanId,memberId,loanDate,bookTitle,genre,author,daysLoaned
        //L-1001 , M-001 , 2024-06-01 , The Hobbit , Fantasy , J.R.R. Tolkien , 14 ,

        List<BookLoan> allBookLoans = file.stream()
                .map(x -> x.split(","))
                .map(x -> Arrays.stream(x).map(y -> y.trim()).toList())
                .map(x -> {
                    try {

                        if(x.size()<7) {
                            return new BookLoan("Malformed_wrong_nr_columns", "", null,
                                    "", "", "", 0);
                        }


                        if (x.get(0).isEmpty() || x.get(1).isEmpty() ||
                                x.get(2).isEmpty() || x.get(3).isEmpty() ||
                                x.get(4).isEmpty() || x.get(5).isEmpty() || x.get(6).isEmpty()) {
                            return new BookLoan("Malformed_empty_field", "", null,
                                    "", "", "", 0);
                        }

                        return new BookLoan(
                                x.get(0),
                                x.get(1),
                                LocalDate.parse(x.get(2)),
                                x.get(3),
                                x.get(4),
                                x.get(5),
                                Integer.parseInt(x.get(6))
                        );

                    } catch (Exception e) {
                        return new BookLoan("Malformed_parse_error", "", null,
                                "", "", "", 0);
                    }
                })
                .toList();

        List<BookLoan> valid = allBookLoans.stream()
                .filter(loan -> !loan.getLoanId().startsWith(("Malformed")))
                .toList();

        List<BookLoan> malformed = allBookLoans.stream()
                .filter(loan -> loan.getLoanId().startsWith(("Malformed")))
                .toList();

        return Map.of(
                "valid", valid,
                "malformed", malformed
        );

    }

    // count loans per genre
    // sorted alphabetically by genre
    protected static Map<String, Long> loansByGenre(final List<BookLoan> loans) {
        // Write your code here and replace the return statement
        return Collections.emptyMap();
    }

    // get top "n" authors by number of loans
    protected static List<String> topAuthorsByLoans(final List<BookLoan> loans, final int n) {
        // Write your code here and replace the return statement
        return Collections.emptyList();
    }

    // get members who borrowed books from at least K genres
    protected static List<String> membersWithGenreDiversity(final List<BookLoan> loans, final int k) {
        // Write your code here and replace the return statement
        return Collections.emptyList();
    }

    // find the first book title containing a substring (case-insensitive)
    protected static Optional<BookLoan> findFirstBookContaining(final List<BookLoan> loans, final String book) {
        // Write your code here and replace the return statement
        return Optional.empty();
    }

    // checks if the book is present in the loans (case-insensitive)
    protected static Boolean isBookPresent(final List<BookLoan> loans, final String book) {
        // Write your code here and replace the return statement
        return null;
    }
}
