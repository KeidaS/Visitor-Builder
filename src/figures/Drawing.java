package figures;
import visitor.*;

import java.util.Collections;
import java.util.List;

public class Drawing extends Figure {
    private List<Figure> list;

    public Drawing(double x, double y, List<Figure> list) {
        super(x, y);
        this.list = list;
    }
    public List<Figure> getComponents() {
        return Collections.unmodifiableList(list);
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
