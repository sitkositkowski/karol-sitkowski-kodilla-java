package com.kodilla.testing.shape;

import java.util.LinkedList;
import java.util.List;

public class ShapeCollector {
    private final List<Shape> shapes;

    public ShapeCollector() {
        this.shapes = new LinkedList<>();
    }

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public void removeFigure(Shape shape){
        shapes.remove(shape);
    }

    public Shape getFigure(int n){
        return shapes.get(n);
    }

    public String showFigures(){
        StringBuilder result = new StringBuilder();
        for(Shape shape: shapes) {
            result.append(shape.getShapeName());
        }
        return result.toString();
    }

    public List<Shape> getShapes() {
        return shapes;
    }
}
