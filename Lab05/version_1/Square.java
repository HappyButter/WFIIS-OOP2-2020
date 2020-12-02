public class Square extends Point{
    protected double side_len;

    public Square(double side_len, int x0, int y0) {
        super(x0, y0);
        this.side_len = side_len;
    }

    @Override
    public String getName() {
        return "Square";
    }

    public String toString(){
        return "Corner = " + super.toString() + "; side = " + side_len;
    }

    @Override
    public double area() {
        return side_len*side_len;
    }

    @Override
    public double volume() {
        return super.volume();      // square has no volume
    }
}
