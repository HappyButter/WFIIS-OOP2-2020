public class GameBoard {
    boolean[][] board;
    int sizeX;
    int sizeY;

    GameBoard(int size_x, int size_y){
        this.board = new boolean[size_x][size_y];
        this.sizeX = size_x;
        this.sizeY = size_y;
    }

    private void presetRandom() {
        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                double rnd = Math.random();
                if(rnd > 0.5){
                    board[i][j] = true;
                }
            }
        }
    }

    private void presetBoat() {
        int middleIndexX = sizeX / 2;
        int middleIndexY = sizeY / 2;

        board[middleIndexX-1][middleIndexY-1] = true;
        board[middleIndexX][middleIndexY-1] = true;
        board[middleIndexX-1][middleIndexY] = true;
        board[middleIndexX+1][middleIndexY] = true;
        board[middleIndexX][middleIndexY+1] = true;
    }

    private void presetBlinker() {
        int middleIndexX = sizeX / 2;
        int middleIndexY = sizeY / 2;

        board[middleIndexX][middleIndexY-1] = true;
        board[middleIndexX][middleIndexY] = true;
        board[middleIndexX][middleIndexY+1] = true;
    }

    private void presetGlider() {
        int middleIndexX = sizeX / 2;
        int middleIndexY = sizeY / 2;

        board[middleIndexX-1][middleIndexY-1] = true;
        board[middleIndexX][middleIndexY-1] = true;
        board[middleIndexX+1][middleIndexY-1] = true;
        board[middleIndexX-1][middleIndexY] = true;
        board[middleIndexX][middleIndexY+1] = true;
    }

    public void preset(int preset) {
        switch (preset) {
            case 0:
                presetRandom();
                break;
            case 1:
                presetBoat();
                break;
            case 2:
                presetBlinker();
                break;
            case 3:
                presetGlider();
                break;
        }
    }


    public void print(int iter) {
        for (int i = 0; i < sizeX; i++){
            if(i == sizeX/2)
                System.out.print(iter);
            else
                System.out.print("=");
        }
        System.out.println();

        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){
                char c = board[i][j] ? 'X' : '.';
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private int countNumberOfAlivesInTheNeighbourhood(int x, int y){
    	int countAlive = 0;
        for(int m = -1; m <= 1; m++) { 			 
            for (int n = -1; n <= 1; n++) {										// matrix [mxn] of neighbours
                if (!(m == 0 && n == 0)){										// prevent counting center cell	
                    if(i+m >= 0 && i+m < sizeX && j+n >= 0 && j+n < sizeY){		// prevent crossing the boarders 
                        if(board[i+m][j+n] == true)								// checking if cell alive
                            countAlive++;
                    }
                }
            }
        }
        return countAlive;
    }

    private void makeStepForward() {
        boolean[][] newBoard = new boolean[sizeX][sizeY];
        int countAlive = 0;

        for(int i = 0; i < sizeX; i++){
            for(int j = 0; j < sizeY; j++){

                countAlive = countNumberOfAlivesInTheNeighbourhood(i,j);

                if(board[i][j] == true){
                    if(countAlive == 2 || countAlive == 3) {
                        newBoard[i][j] = true;
                    }else{
                        newBoard[i][j] = false;
                    }
                }else{
                    if(countAlive == 3) {
                        newBoard[i][j] = true;
                    }else{
                        newBoard[i][j] = false;
                    }
                }
            }
        }
        board = newBoard;
    }

    public void play(int steps) {
        for(int i = 0; i < steps; i++){
            print(i);
            makeStepForward();
        }
    }

}
