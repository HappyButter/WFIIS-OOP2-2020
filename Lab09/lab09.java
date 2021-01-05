import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class lab09 {

    public static void main(String[] args) {
        String filePath = args[0];
        BufferedReader objReader = null;
        try {

            // read number of kids and prepare variables
            objReader = new BufferedReader(new FileReader(filePath));
            int n = Integer.parseInt(objReader.readLine());

            String[] arrLine;
            int[][]  fieldsDugByKids = new int[n][4];
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            // read fields dug by kids and min/max values
            String strCurrentLine;
            for(int i = 0; i<n; ++i) {
                strCurrentLine = objReader.readLine();
                arrLine = strCurrentLine.split(" ");

                for(int j = 0; j<4; ++j){
                    fieldsDugByKids[i][j] = Integer.parseInt(arrLine[j]);
                }

                minX = Math.min(minX, fieldsDugByKids[i][0]);
                minY = Math.min(minY, fieldsDugByKids[i][1]);
                maxX = Math.max(maxX, fieldsDugByKids[i][2]);
                maxY = Math.max(maxY, fieldsDugByKids[i][3]);
            }

            // create matrix of field
            int sizeX = maxX - minX + 1;
            int sizeY = maxY - minY + 1;
            int[][] field = new int[sizeX][sizeY];
            for (int[] row: field)
                Arrays.fill(row, 0);

            // count number of digs
            for(int i = 0; i<sizeX; ++i){
                for(int j = 0; j<sizeY; ++j){
                    for(int nthChild = 0; nthChild < n; ++nthChild){
                        if(i >= fieldsDugByKids[nthChild][0] && i <=fieldsDugByKids[nthChild][2] && j >= fieldsDugByKids[nthChild][1] && j <=fieldsDugByKids[nthChild][3])
                            field[i][j]++;
                    }
                }
            }

            // count number of fields to be checked again
            int result = 0;
            for(int i = 0; i<sizeX; ++i){
                for(int j = 0; j<sizeY; ++j) {
                    System.out.print(field[i][j]);
                    if(field[i][j] < 2)
                        result++;
                }
                System.out.println();
            }
            System.out.println("Fields to be dug: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (objReader != null)
                    objReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
