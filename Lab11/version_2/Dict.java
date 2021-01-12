import java.io.*;
import java.util.ArrayList;

public class Dict {
    private ArrayList<Translation> dict = new ArrayList<>();
    private String fileName;

    public void loadDict(String fileName) {
        this.fileName = fileName;

        File file = new File(fileName);
        boolean exists = file.exists();

        if(exists) {
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader(fileName));
                String line = reader.readLine();

                while (line != null) {
                    String[] splitedLine = line.split(" ");
                    Translation newTranslation = new Translation(splitedLine[0], splitedLine[1]);
                    dict.add(newTranslation);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                file.createNewFile();
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getTranslation(String s) {
        String translated = null;
        for (Translation t : this.dict) {
            translated = t.getTranslated(s);
            if(translated != null)
                return translated;
        }
        return "No such a translation in the dictionary";
    }

    public void deleteTranslation(String s) {
        int i = 0;
        int indexToDel = -1;
        for (Translation t : this.dict) {
            if(t.isPresent(s)){
                indexToDel = i;
                break;
            }
            i++;
        }
        if(indexToDel != -1){
            this.dict.remove(indexToDel);
        }
    }

    public void add(Translation translation) {
        boolean canBeAddded = true;
        for (Translation t : this.dict) {
            if(t.isPresent(translation.getKey()) || t.isPresent(translation.getValue())){
                canBeAddded = false;
                break;
            }
        }
        if(canBeAddded){
            this.dict.add(translation);
        }
    }

    public void printAll() {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (Translation t : this.dict) {
                writer.print(t);
            }
            writer.close();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
