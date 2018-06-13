package figures;
import visitor.*;

public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}