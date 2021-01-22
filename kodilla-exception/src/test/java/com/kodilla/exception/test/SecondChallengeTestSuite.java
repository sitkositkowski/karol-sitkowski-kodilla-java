package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    public void testReadFileWithName() {
        // given
        //(x >= 2 || x < 1 || y == 1.5)
        SecondChallenge secondChallenge = new SecondChallenge();
        // when & then
        assertAll(
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2.0,1.0)),
                () -> assertThrows(Exception.class, () ->  secondChallenge.probablyIWillThrowException(1.0,1.5)),
                () -> assertDoesNotThrow(() ->  secondChallenge.probablyIWillThrowException(1.0,1.0))
        );
    }
}


