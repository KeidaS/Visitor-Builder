package figures;
import visitor.*;

public class Circle extends Figure {
    double r;

    public Circle(double x, double y, double r) {
        super(x, y);
        this.r = r;
    }
    public double getR() {
        return this.r;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}