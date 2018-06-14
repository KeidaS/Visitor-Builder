package figures;
import visitor.*;

import java.util.Collections;
import java.util.List;

public class Drawing extends Figure {
    private List<Figure> figures;

    public Drawing(double x, double y, List<Figure> figures) {
        super(x, y);
        this.figures = figures;
    }
    public List<Figure> getComponents() {
        return Collections.unmodifiableList(figures);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
