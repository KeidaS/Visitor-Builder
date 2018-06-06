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
    public void testDrawingBuilder() {
        DrawingBuilder drawingBuilder = new DrawingBuilder(5, 5);
        drawingBuilder.addFigure(circle);
        drawingBuilder.addFigure(rectangle);
        Drawing drawing = drawingBuilder.create();
        List<Figure> figures = drawing.getComponents();
        assertSame(figures.get(0), circle);
        assertSame(figures.get(1), rectangle);
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
    }
}
