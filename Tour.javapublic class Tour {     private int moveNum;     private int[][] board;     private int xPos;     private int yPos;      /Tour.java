public class Tour {
    private int moveNum;
    private int[][] board;
    private int xPos;
    private int yPos;

    // Possible knight moves
    private final int[][] moves = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

   
    public Tour() {
        moveNum = 1;
        board = new int[8][8];
    }

   
    public boolean moveCheck(int changeX, int changeY) {
        int newX = xPos + changeX;
        int newY = yPos + changeY;

        return newX >= 0 && newX < 8 && newY >= 0 && newY < 8 && board[newX][newY] == 0;
    }

   
    public void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }

   
   
    public boolean knightsTour(int startX, int startY) {
        xPos = startX;
        yPos = startY;
        board[xPos][yPos] = moveNum;

        return solve(xPos, yPos, moveNum + 1);
    }

 
    private boolean solve(int currentX, int currentY, int currentMove) {
        if (currentMove > 64) {
            return true;
        }

        for (int[] move : moves) {
            int newX = currentX + move[0];
            int newY = currentY + move[1];

            if (newX >= 0 && newX < 8 && newY >= 0 && newY < 8 && board[newX][newY] == 0) {
                board[newX][newY] = currentMove;

                if (solve(newX, newY, currentMove + 1)) {
                    return true;
                }

               
                board[newX][newY] = 0;
            }
        }

        return false;
    }
}
