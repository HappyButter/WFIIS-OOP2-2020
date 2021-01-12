public class lab12 {

    public static void main(String[] args) {
        handleInput(args);
    }

    private static void handleInput(String[] args) {
        try {
            Dict dict = new Dict();
            dict.loadDict("dic.txt");

            switch (args.length){
                case 1:
                    System.out.println(dict.getTranslation(args[0]));
                    break;
                case 2:
                    dict.deleteTranslation(args[1]);
                    break;
                case 3:
                    dict.add(new Translation(args[1], args[2]));
                    break;
                default:
                    System.out.println("No such a functionality");
                    break;
            }
            dict.printAll();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
