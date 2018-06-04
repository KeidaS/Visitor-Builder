public class AreaDoubler implements Visitor {
    private Figure figure;

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
        }
    }

    public Figure getResult() {
        return this.figure;
    }
}