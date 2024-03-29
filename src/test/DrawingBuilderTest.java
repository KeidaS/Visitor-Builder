package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import builder.DrawingBuilder;
import figures.*;

import java.util.ArrayList;
import java.util.List;

public class DrawingBuilderTest {
    private Circle circle;
    private Rectangle rectangle;

    @Before
    public void initialize() {
        circle = new Circle (5,5,5);
        rectangle = new Rectangle(6, 6, 8, 8);

    }
    @Test
    public void testEmptyDrawingBuilder() {
        DrawingBuilder drawingBuilder = new DrawingBuilder(5, 5);
        Drawing drawing = drawingBuilder.create();
        List<Figure> figures = drawing.getComponents();
        assertEquals(figures.size(), 0);
    }
    @Test
    public void testDrawingBuilder() {
        DrawingBuilder drawingBuilder = new DrawingBuilder(5, 5);
        drawingBuilder.addFigure(circle);
        drawingBuilder.addFigure(rectangle);
        Drawing drawing = drawingBuilder.create();
        List<Figure> figures = drawing.getComponents();
        assertSame(figures.get(0), circle);
        assertSame(figures.get(1), rectangle);
        assertEquals(figures.size(), 2);
    }
    @Test
    public void testDrawingBuilderWithDrawing() {
        DrawingBuilder drawingBuilder = new DrawingBuilder(5, 5);
        drawingBuilder.addFigure(circle);
        drawingBuilder.addFigure(rectangle);
        Drawing drawing = drawingBuilder.create();
        drawingBuilder.addFigure(drawing);
        Drawing drawing1 = drawingBuilder.create();
        List<Figure> figures = drawing1.getComponents();
        assertSame(figures.get(0), circle);
        assertSame(figures.get(1), rectangle);
        assertSame(figures.get(2), drawing);
        assertEquals(figures.size(), 3);
    }
    @Test (expected = UnsupportedOperationException.class)
    public void testDrawingUnmodifiableList() throws UnsupportedOperationException{
        DrawingBuilder drawingBuilder = new DrawingBuilder(5, 5);
        drawingBuilder.addFigure(circle);
        drawingBuilder.addFigure(rectangle);
        Drawing drawing = drawingBuilder.create();
        List<Figure> figures = drawing.getComponents();
        Circle circle1 = new Circle (6,6,6);
        figures.add(circle1);
    }
}
