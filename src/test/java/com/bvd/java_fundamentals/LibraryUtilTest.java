package com.bvd.java_fundamentals;

import com.bvd.java_fundamentals.model.BookLoan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static com.bvd.java_fundamentals.LibraryUtil.parseCsvLines;
import static org.junit.jupiter.api.Assertions.*;

class LibraryUtilTest {

    private static List<String> loans;
    private static Map<String, List<BookLoan>> parsedLoans;

    @BeforeAll
    static void setUp() {

        loans = LibraryAnalytics.loadedFile;
        parsedLoans = parseCsvLines(loans);
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
}
