package com.bvd.java_fundamentals;

import com.bvd.java_fundamentals.model.BookLoan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.bvd.java_fundamentals.LibraryUtil.*;
import static org.junit.jupiter.api.Assertions.*;

class LibraryUtilTest {

    private static List<String> loans;
    private static Map<String, List<BookLoan>> parsedLoans;
    private static List<BookLoan> validLoans;

    @BeforeAll
    static void setUp() {

        loans = LibraryAnalytics.loadedFile;
        parsedLoans = parseCsvLines(loans);
        validLoans = parsedLoans.get("valid");
    }

    @Test
    void testLoadResourceFile_returnsFile() {
        assertNotNull(loans);
        assertFalse(loans.isEmpty());
        assertEquals(35, loans.size());
    }

    @Test
    void testParsedCsvLines_validMalfrmedCounts() {
        assertNotNull(parsedLoans);
        assertTrue(parsedLoans.containsKey("valid"));
        assertTrue(parsedLoans.containsKey("malformed"));

        List<BookLoan> valid = parsedLoans.get("valid");
        List<BookLoan> malformed = parsedLoans.get("malformed");

        assertEquals(32, valid.size());
        assertEquals(3, malformed.size());

    }

    @Test
    void testLoansByGenre_counts() {
        Map<String, Long> countByGenre = loansByGenre(validLoans);

        assertEquals(5, countByGenre.size());
        assertEquals(9, countByGenre.get("Classic"));
        assertEquals(5, countByGenre.get("Dystopian"));
        assertEquals(7, countByGenre.get("Fantasy"));
        assertEquals(4, countByGenre.get("Horror"));
        assertEquals(7, countByGenre.get("Science Fiction"));

    }

    @Test
    void testTopAuthorsByLoans_top2() {
        var top2 = topAuthorsByLoans(validLoans, 2);
        assertEquals(List.of("J.R.R. Tolkien", "Fyodor Dostoevsky"), top2);
    }

    @Test
    void testMembers_atLeast3Genres(){
        List<String> result = membersWithGenreDiversity(validLoans, 3);
        List<String> expected = List.of("M-002", "M-003", "M-008", "M-009", "M-010");

        assertEquals(expected.size(), result.size());
        assertEquals(expected, result);
    }

}
