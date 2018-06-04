package visitor;

import figures.Circle;
import figures.Drawing;
import figures.Rectangle;

public interface Visitor {
    void visit(Rectangle r);
    void visit(Circle c);
    void visit(Drawing d);
}