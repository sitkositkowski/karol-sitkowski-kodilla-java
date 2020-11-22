package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for addind/removing")
    class TestAddRemove{
        @Test
        void testAddShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(10);
            //When
            shapeCollector.addFigure(circle);
            //Then
            Assertions.assertTrue(shapeCollector.getShapes().contains(circle));
        }

        @Test
        void testRemoveShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape circle = new Circle(10);
            shapeCollector.addFigure(circle);
            boolean isContained = shapeCollector.getShapes().contains(circle);
            //When
            shapeCollector.removeFigure(circle);
            //Then
            Assertions.assertTrue(isContained && !shapeCollector.getShapes().contains(circle));
        }
    }

    @Nested
    @DisplayName("Tests for getting/showing")
    class TestGetShow{

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            for (int i = 0; i<10; i++) {
                shapeCollector.addFigure(new Circle(10));
            }
            //When
            Shape figure = shapeCollector.getFigure(5);
            //Then
            Assertions.assertEquals(shapeCollector.getShapes().get(5),figure);
        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            StringBuilder expected = new StringBuilder();
            Circle circle;
            for (int i = 0; i<10; i++) {
                circle = new Circle(10);
                shapeCollector.addFigure(circle);
                expected.append(circle.getShapeName());
            }
            String expected2 = expected.toString();
            //When
            String result = shapeCollector.showFigures();
            //Then
            Assertions.assertEquals(expected2, result);
        }
    }
}
