package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedian() {
        // Given
        Set<Book> books = new HashSet<>();
        books.add(new Book("author", "title", 2000, "AAA2000"));
        books.add(new Book("author", "title", 2005, "AAA2005"));
        books.add(new Book("author", "title", 2021, "AAA2021"));
        books.add(new Book("author", "title", 1990, "AAA1990"));
        books.add(new Book("author", "title", 1904, "AAA1904"));
        MedianAdapter medianAdapter = new MedianAdapter();
        // When
        int publicationYearMedian = medianAdapter.publicationYearMedian(books);
        // Then
        System.out.println(publicationYearMedian);
        assertEquals(publicationYearMedian, 2000);                  // [4]
    }
}
