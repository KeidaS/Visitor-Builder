package visitor;

import figures.*;

import java.util.ArrayList;
import java.util.List;

public class AreaDoubler implements Visitor {
    private Figure figure;
    private List<Figure> figures = new ArrayList<>();

    @Override
    public void visit(Rectangle r) {
        this.figure = new Rectangle(r.getX(), r.getY(),
                r.getHeight() * Math.sqrt(2.0),
                r.getWidth() * Math.sqrt(2.0));
    }

    @Override
    public void visit(Circle c) {
        this.figure  = new Circle(c.getX(), c.getY(), c.getR() * Math.sqrt(2.0));
    }

    @Override
    public void visit(Drawing d) {
        for (Figure f: d.getComponents()){
            f.accept(this);
            figures.add(this.getResult());
        }
        this.figure = new Drawing(d.getX(), d.getY(), figures);
    }

    public Figure getResult() {
        return this.figure;
    }
}