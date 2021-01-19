import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Serializer {
    ArrayList<String> dataList = new ArrayList<String>();

    public void serialize(String srcFileName, String destFileName){
        loadData(srcFileName);

        try{
            FileOutputStream fos = new FileOutputStream(destFileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dataList);
            oos.close();
            fos.close();
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println("Serialized.");
    }

    public void deserialize(String srcFileName, String destFileName){
        try {
            FileInputStream fis = new FileInputStream(srcFileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            dataList = (ArrayList<String>) ois.readObject();

            ois.close();
            fis.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
            return;
        }catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        sort();
        printAll(destFileName);

        System.out.println("Deserialized.");
    }

    public void loadData(String srcFileName){
        File file = new File(srcFileName);
        boolean exists = file.exists();

        if(exists) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(srcFileName));
                String line = reader.readLine();

                while (line != null) {
                    dataList.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("No such a file");
        }
    }

    public void sort(){
        Collections.sort(dataList);
    }

    public void printAll(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (String record : dataList) {
                writer.print(record + '\n');
            }
            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
