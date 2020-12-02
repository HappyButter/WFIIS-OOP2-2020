public class lab05 {

    public static void main(String[] args) {
        if(args.length == 1){
            String fileName = args[0];
            Turtle turtle = new Turtle();
            turtle.read(fileName);
            turtle.generate();
        }else{
            System.out.println("Zle parametry!");
        }
    }
}
