import java.util.ArrayList;
import java.util.Random;

public class Rnd {
    ArrayList<Double> arr = new ArrayList<>();

    public Rnd(int listSize, int numberOfRands) {
        Random randomGenerator = new Random();
        for(int i = 0; i < listSize; i++){
            double sum = 0.0;
            for(int j = 0; j < numberOfRands; j++)
                sum += randomGenerator.nextDouble();
            arr.add(sum);
        }
    }

    public void Print() {
        int index = 0;
        for(Double d : arr) {
            System.out.println("[" + index + "]=" + d);
            index++;
        }
    }

    public double Min() {
        Double min = 1000000.0;
        for(Double x : arr)
            min = x < min ? x : min;
        return min;
    }

    public double Max() {
        Double max = 0.0;
        for(Double x : arr)
            max = x > max ? x : max;
        return max;
    }

    public double Average() {
        double sum = 0.0;
        for (Double x : arr)
            sum += x;
        return sum / arr.size();
    }

    public void Draw() {
        int maxStarsNumber = 50;
        int index = 0;
        double min = Min();
        double max = Max();
        double diff = max - min;

        for(Double x : arr){
            int starsToDraw = (int) ( (x - min) * maxStarsNumber / diff);
            System.out.print("[" + index++ + "]:");
            for(int i = 0; i < starsToDraw; i++)
                System.out.print("*");
            System.out.println("");
        }
    }
}
