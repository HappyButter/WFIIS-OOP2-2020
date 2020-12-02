import java.util.Scanner;
import java.util.ArrayList;

public class Lab02 {

    static class Pair {
        int zeros;
        int ones;
    }

    static public int countPairLen(Pair p){
        return p.zeros + p.ones;
    }

    private static int[] readArray(int size) { // taking input from the user
        int[] series = new int[size];
        Scanner in = new Scanner(System.in);

        System.out.println("Put the array bellow. Press enter after each 0 or 1.");
        for (int i = 0; i < size; i++){
            series[i] = in.nextInt();
            if (!(series[i] == 0 || series[i] == 1)) {
                System.out.println("Bad input! Try again!");
                --i;
            }
        }
        return series;
    }

    private static ArrayList<Integer> findZeroOnePairPositions(int[] a){
        ArrayList<Integer> occurrences = new ArrayList<>();
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] == 0 && a[i+1] == 1)
                occurrences.add(i);
        }

        return occurrences;
    }

    private static int countZerosBefore(int[] a, int posOfZeroOnePair){
        if (posOfZeroOnePair == 0)
            return 1;

        int n = 1;
        for(int i = 0; i < posOfZeroOnePair; i++)
            if(a[i] == 0)
                n++;

        return n;
    }

    private static int countOnesAfter(int[] a, int posOfZeroOnePair){
        posOfZeroOnePair += 1; // moving forward index to 1 instead of 0
        if (posOfZeroOnePair > a.length - 1)
            return 1;

        int n = 1;
        for(int i = posOfZeroOnePair + 1; i < a.length; i++)
            if(a[i] == 1)
                n++;

        return n;
    }

    private static ArrayList<Pair> findMaxSeries(int[] a, ArrayList<Integer> indexes){
        ArrayList<Pair> arr = new ArrayList<>();
        for(Integer index : indexes){
            Pair zeroOneCount= new Pair();
            zeroOneCount.zeros = countZerosBefore(a, index);
            zeroOneCount.ones = countOnesAfter(a, index);
            arr.add(zeroOneCount);
        }

        return arr;
    }

    private static void findMaxCommonSeries(ArrayList<Pair> a,ArrayList<Pair> b){
        Pair maxPair = new Pair();
        for (Pair pa : a){
            for (Pair pb : b){
                Pair tmp = new Pair();
                tmp.zeros = Math.min(pa.zeros, pb.zeros);
                tmp.ones = Math.min(pa.ones, pb.ones);
                maxPair = (countPairLen(tmp) > countPairLen(maxPair)) ? tmp : maxPair;
            }
        }
        System.out.println("MAX IS: { Zeros: " + maxPair.zeros + ", Ones: " + maxPair.ones + "}");
    }

    private static void findOrderedSeries(int[] a, int[] b){
        ArrayList<Integer> aPairIndexes = findZeroOnePairPositions(a);
        ArrayList<Integer> bPairIndexes = findZeroOnePairPositions(b);

        ArrayList<Pair> aMaxSizePairs= findMaxSeries(a, aPairIndexes);
        ArrayList<Pair> bMaxSizePairs= findMaxSeries(b, bPairIndexes);

        findMaxCommonSeries(aMaxSizePairs, bMaxSizePairs);
    }
    

    public static void main(String[] args) {
        try {
            System.out.println("What's the length of the first 0-1 series?");
            Scanner in = new Scanner(System.in);
            int firstSeriesLength = in.nextInt();
            int[] firstSeries = readArray(firstSeriesLength);
            // int[] firstSeries = {0,0,0,0,1,0,1,1};   // uncoment to test 

            System.out.println("What's the length of the second 0-1 series?");
            int secondSeriesLength = in.nextInt();
            int[] secondSeries = readArray(secondSeriesLength);
            // int[] secondSeries = {0,0,0,1,1,0,0};    // uncoment to test 
        }catch(Exception e) {
            System.out.println("Exception: invalid input type.");
        }

        findOrderedSeries(firstSeries, secondSeries);
    }
}
