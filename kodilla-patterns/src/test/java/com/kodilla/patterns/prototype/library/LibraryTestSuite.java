package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTestSuite {

    @Test
    void testGetBooks(){
        //Given
        Book book1 = new Book("Secrets of Alamo", "John Smith", LocalDate.of(2008,12,31));
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", LocalDate.of(203,8,1));
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", LocalDate.of(2012,5,18));
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", LocalDate.of(2018,3,4));

        Library library = new Library("Library");

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);

        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowClone();
            clonedLibrary.setName("Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepClone();
            deepClonedLibrary.setName("Deep Cloned Library");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book1);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);

        assertEquals(3,library.getBooks().size());
        assertEquals(3,clonedLibrary.getBooks().size());
        assertEquals(4,deepClonedLibrary.getBooks().size());

        assertEquals(clonedLibrary.getBooks(),library.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(),library.getBooks());
    }
}
