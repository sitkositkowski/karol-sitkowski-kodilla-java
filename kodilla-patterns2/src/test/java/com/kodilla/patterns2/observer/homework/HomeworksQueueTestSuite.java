package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeworksQueueTestSuite {

    @Test
    public void testUpdate() {
        //Given
        HomeworksQueue homeworksQueue1 = new HomeworksQueue("KodillaUser 1");
        HomeworksQueue homeworksQueue2 = new HomeworksQueue("KodillaUser 2");
        HomeworksQueue homeworksQueue3 = new HomeworksQueue("KodillaUser 3");
        HomeworksQueue homeworksQueue4 = new HomeworksQueue("KodillaUser 4");
        HomeworksQueue homeworksQueue5 = new HomeworksQueue("KodillaUser 5");

        KodillaMentor kodillaMentor1 = new KodillaMentor("Mentor 1");
        KodillaMentor kodillaMentor2 = new KodillaMentor("Mentor 2");

        homeworksQueue1.registerObserver(kodillaMentor1);
        homeworksQueue2.registerObserver(kodillaMentor1);
        homeworksQueue3.registerObserver(kodillaMentor2);
        homeworksQueue4.registerObserver(kodillaMentor2);
        homeworksQueue5.registerObserver(kodillaMentor2);

        //When
        homeworksQueue1.addHomework("1");
        homeworksQueue1.addHomework("2");
        homeworksQueue1.addHomework("3");
        homeworksQueue2.addHomework("1");
        homeworksQueue3.addHomework("1");
        homeworksQueue3.addHomework("2");
        homeworksQueue5.addHomework("1");
        homeworksQueue5.addHomework("2");

        // Then
        assertEquals(4, kodillaMentor1.getUpdateCount());
        assertEquals(4, kodillaMentor2.getUpdateCount());
    }
}
