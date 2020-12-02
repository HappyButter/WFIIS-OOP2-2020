public class Cube extends Square{

    public Cube(double depth, int x0, int y0) {
        super(depth, x0, y0);   // depth (in cube) = side_len (in square). No need to init new variable for depth
    }

    @Override
    public String getName() {
        return "Cube";
    }

    public String toString(){
        return super.toString() + "; depth = " + super.side_len;
    }

    @Override
    public double area() {
        return 6*super.area();
    }

    @Override
    public double volume() {
        return super.side_len * super.area();
    }
}
