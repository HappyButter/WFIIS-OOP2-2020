public class lab13
{
    public static void main(String[] args){
        handleInput(args);
    }

    private static void handleInput(String[] args) {
        if (args.length == 2) {
            if (args[0].endsWith(".txt") && args[1].endsWith(".ser")){
                Serializer ser = new Serializer();
                ser.serialize(args[0], args[1]);
            }else if (args[1].endsWith(".txt") && args[0].endsWith(".ser")){
                Serializer ser = new Serializer();
                ser.deserialize(args[0], args[1]);
            }else{
                System.out.println("Invalid files extensions.");
            }
        }else{
            System.out.println("Invalid number of files.");
        }
    }
}