package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@DisplayName("Forum Test Suite")
public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when exterminate empty list, " +
            "then exterminate() should return empty list"
    )
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals(numbers, result);
    }

    @DisplayName("when exterminate normal list, " +
            "then exterminate() should return  of even numbers"
    )
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        List<Integer> numbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i<10; i++) {
            evenNumbers.add(rand.nextInt(100)*2);
            oddNumbers.add(rand.nextInt(100)*2+1);
        }
        numbers.addAll(evenNumbers);
        numbers.addAll(oddNumbers);
        Collections.shuffle(numbers);
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing " + result);
        Collections.sort(result);
        Collections.sort(evenNumbers);
        //Then
        Assertions.assertEquals(evenNumbers, result);
    }
}
