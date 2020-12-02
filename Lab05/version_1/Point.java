public class Point extends Shape{
    private final double x_pos;
    private final double y_pos;

    Point( double x0, double y0 ){
        x_pos = x0;
        y_pos = y0;
    }

    @Override
    public String getName() {
        return "Point";
    }

    public String toString(){
        return "[" + x_pos + ", " + y_pos + "]";
    }

    @Override
    public double area() {
        return 0;   // point has no area - return 0
    }

    @Override
    public double volume() {
        return 0;   // point has no volume - return 0
    }

}
