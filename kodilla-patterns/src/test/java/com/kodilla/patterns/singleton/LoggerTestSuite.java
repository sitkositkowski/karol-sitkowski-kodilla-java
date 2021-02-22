package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerTestSuite {

    private static Logger logger = Logger.INSTANCE;

    @Test
    void testGetLastLog(){
        //Given
        logger.log("First log");
        logger.log("Last log");
        //When
        String lastLog = logger.getLastLog();
        //Then
        assertEquals("Last log", lastLog);
    }
}
