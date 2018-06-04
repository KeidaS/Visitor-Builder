import java.util.List;

public class DrawingBuilder {
    private final double x;
    private final double y;
    private List<Figure> list;

    public DrawingBuilder(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void addFigure(Figure figure) {
        list.add(figure);
    }

    public Drawing create() {
        return new Drawing(x, y, list);
    }
}