package builder;

import figures.Drawing;
import figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class DrawingBuilder {
    private final double x;
    private final double y;
    private List<Figure> list;

    public DrawingBuilder(double x, double y) {
        this.x = x;
        this.y = y;
        this.list = new ArrayList<>();
    }

    public void addFigure(Figure figure) {
        this.list.add(figure);
    }

    public Drawing create() {
        return new Drawing(this.x, this.y, this.list);
    }
}