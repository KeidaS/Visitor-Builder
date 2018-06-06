package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import builder.DrawingBuilder;
import figures.*;
import visitor.*;

import java.util.ArrayList;
import java.util.List;

public class AreaDoublerTest {
    private Circle circle;
    private Rectangle rectangle;
    private Drawing drawing;

    @Before
    public void initialize() {
        circle = new Circle (9,9,9);
        rectangle = new Rectangle(6, 6, 8, 8);
        DrawingBuilder drawingBuilder = new DrawingBuilder(5, 5);
        drawingBuilder.addFigure(circle);
        drawingBuilder.addFigure(rectangle);
        drawing = drawingBuilder.create();
    }

    @Test
    public void testAreaDoublerWithCircle() {
        AreaDoubler areaDoubler = new AreaDoubler();
        circle.accept(areaDoubler);
        circle = (Circle) areaDoubler.getResult();
        assertEquals(12.727922061, circle.getR(), 1);
        assertEquals(9, circle.getX(), 1);
        assertEquals(9, circle.getY(), 1);

    }

    @Test
    public void testAreaDoublerWithRectangle() {
        AreaDoubler areaDoubler = new AreaDoubler();
        rectangle.accept(areaDoubler);
        rectangle = (Rectangle) areaDoubler.getResult();
        assertEquals(11.313708499, rectangle.getWidth(), 1);
        assertEquals(11.313708499, rectangle.getHeight(), 1);
        assertEquals(6, rectangle.getX(), 1);
        assertEquals(6, rectangle.getY(), 1);
    }

    @Test
    public void testAreaDoublerWithDrawing() {
        AreaDoubler areaDoubler = new AreaDoubler();
        drawing.accept(areaDoubler);
        List<Figure> figures = drawing.getComponents();
        circle = (Circle) figures.get(0);
        areaDoubler.getResult();
        rectangle = (Rectangle) figures.get(1);
        assertEquals(12.727922061,circle.getR(), 1);
        assertEquals(11.313708499,rectangle.getWidth(), 1);
        assertEquals(11.313708499,rectangle.getHeight(), 1);
    }

}
