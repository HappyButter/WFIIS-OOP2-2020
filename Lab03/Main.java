public class Main {

    public static void main(String[] args) {
	    if(args.length == 4){
	        int size_x = Integer.parseInt(args[0]);
            int size_y = Integer.parseInt(args[1]);
            int steps = Integer.parseInt(args[2]);
            int preset = Integer.parseInt(args[3]);

            GameBoard board = new GameBoard(size_x, size_y);
            board.preset(preset);

            board.play(steps);
        }else{
            System.out.println("Invalid params.");
        }
    }
}
