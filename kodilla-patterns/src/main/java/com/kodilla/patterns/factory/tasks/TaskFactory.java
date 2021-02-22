package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.shapes.Circle;
import com.kodilla.patterns.factory.shapes.Rectangle;
import com.kodilla.patterns.factory.shapes.Shape;
import com.kodilla.patterns.factory.shapes.Square;

import static com.kodilla.patterns.factory.shapes.ShapeFactory.SQUARE;

public class TaskFactory {
    public static final String DRIVING_TASK = "DRIVING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String SHOPPING_TASK = "SHOPPING_TASK";

    public final Task makeTask(final String shapeClass) {
        switch (shapeClass) {
            case DRIVING_TASK:
                return new DrivingTask("Driving Task", "Prague", "Car");
            case PAINTING_TASK:
                return new PaintingTask("Painting Task", "Red", "House");
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping Task", "Orange", 3.0);
            default:
                return null;
        }

    }
}
