import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Turtle {
    private double x;
    private double y;
    private double alpha;
    ArrayList<String> fileStr = new ArrayList<>();

    public Turtle() {
        this.x = 0.0;
        this.y = 0.0;
        this.alpha = Math.toRadians(90.0);
    }

    public void read(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            ArrayList<String> result = new ArrayList<>();

            while (line!=null)
            {
                result.add(line);
                line = reader.readLine();
            }
            reader.close();
            fileStr = result;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generate() {
        int index = 0;
        for(String command : fileStr){
            String[] commandSplited = command.split(" ", 2);
            if (commandHandler(commandSplited, index)){
                break;
            }
            index++;
        }
    }

    public boolean commandHandler(String[] commandSplited, int index){
        boolean isEnd = false;
        switch (commandSplited[0]){
            case "HOME":
                home();
                break;
            case "END":
                isEnd = true;
                break;
            case "MOVE":
                move(Integer.parseInt(commandSplited[1]));
                break;
            case "DRAW":
                draw(Integer.parseInt(commandSplited[1]));
                break;
            case "RIGHT":
                right(Integer.parseInt(commandSplited[1]));
                break;
            case "LEFT":
                left(Integer.parseInt(commandSplited[1]));
                break;
            case "REPEAT":
                repeat(Integer.parseInt(commandSplited[1]), index);
        }
        return isEnd;
    }

    public void draw(int r){
        System.out.println(this.x + " " + this.y);
        move(r);
        System.out.println(this.x + " " + this.y);
    }

    public void move(int r){
        this.x += r * cos(this.alpha);
        this.y += r * sin(this.alpha);
    }

    public void right(int alpha){
        this.alpha -= Math.toRadians(alpha);
    }

    public void left(int alpha){
        this.alpha += Math.toRadians(alpha);
    }

    public void home(){
        this.x = 0.0;
        this.y = 0.0;
        this.alpha = Math.toRadians(90.0);
    }

    public void repeat(int x, int index){
        ArrayList<String> currentCommandList = new ArrayList<>();
        for(int i = index + 1; i<fileStr.size(); i++){
            if(fileStr.get(i).equals("NEXT")){
                break;
            }
            currentCommandList.add(fileStr.get(i));
        }

        for(int i = 0; i < x; i++){
            int j = index + 1;
            for (String command : currentCommandList){
                String[] commandSplited = command.split(" ", 2);
                if (commandHandler(commandSplited, j)){
                    break;
                }
                j++;
            }
        }
    }
}
