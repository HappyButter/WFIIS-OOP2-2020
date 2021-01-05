import java.io.*;

public class lab08 {

    public static void main(String[] args) {

        try{
            checkParamsNumber(args);
            String srcFileName = args[0];
            String outFileName = args[1];

            double avg = calculateAverage(srcFileName);

            saveResult(avg, outFileName);

        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static void checkParamsNumber(String[] args) throws Exception{
        if(args.length != 2){
            throw new Exception("Invalid number of parameters.");
        }
    }

    private static double calculateAverage(String srcFileName) {

        double sum = 0.0;
        int lineCounter = 0;
        String line = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(srcFileName));

            while (( line = reader.readLine() ) != null){
                lineCounter++;
                sum += Integer.parseInt(line);
            }
            reader.close();

            if(lineCounter == 0){
                throw new Exception("Empty file. Provide file with numbers.");
            }

        } catch (IOException e) {
            System.out.println("File cannot be read.");
            e.printStackTrace();
            System.exit(0);
        } catch (NumberFormatException e) {
            System.out.println("File cannot be read - not a number in a file.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(0);
        }

        return sum/lineCounter;
    }

    private static void saveResult(double avg, String outFileName) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFileName));
        writer.write(String.valueOf(avg));
        writer.close();
    }
}
