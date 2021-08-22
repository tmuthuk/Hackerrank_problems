package udemy.backtracking;


/**
 * Udemy Tutorial Source: Backtracking NQueens Solver
 *
 * Input: NxN Chess Board and N queens
 * Task: Find the position of each queen in the NxN chessboard in such a way that.
 * each of the queen is not in the offensive position to the other. In other words, find the position
 * for each queen in such a way that they cannot attack each other
 *
 *
 * Time Complexity: O(N!)
 */
public class NQueenSolver {
    int[][] chessBoard;
    int queens;
    public static void main(String[] args) {
        NQueenSolver solver = new NQueenSolver(4);
        solver.printChessBoard();
        solver.solve(0);
        System.out.println("=====");
        solver.printChessBoard();
    }

    public NQueenSolver(int N) {
        chessBoard = new int[N][N];
        queens = N;
    }

    public boolean solve(int columnIndex) {

        if(columnIndex == queens) return true;

        for(int i=0; i<queens; i++){
            if(checkIfValidMove(i, columnIndex)) {
                chessBoard[i][columnIndex] = 1;
                if(solve(columnIndex + 1)) {
                    return true;
                }
                // Backtracking
                // reset
                chessBoard[i][columnIndex] = 0;
            }

        }
        return false;
    }


    // see if it is safe to place the queen in that position
    // if yes == set [row][column] = 1
    //  move onto the next index
    public boolean checkIfValidMove(int rowIndex, int currentColumn) {
        int row = currentColumn;
        // Check if there are any queens in current row
        for(int i=0; i<currentColumn; i++) {
            if(chessBoard[rowIndex][i] == 1) return false;
        }
        // Check if there are any queens in upward diagonal
         for(int i= rowIndex, j=currentColumn; i>=0 && j>=0; i--,j--){
             if(chessBoard[i][j] == 1) return false;
         }

        // Check if there are any queens in downward diagonal
        for(int i=rowIndex, j=currentColumn; i<chessBoard.length && j>=0; i++,j--) {
            if(chessBoard[i][j] == 1) return false;
        }

        return true;
    }

    /**
     * Method to print the current state of the chessboard
     */
    public void printChessBoard() {
        for(int i=0; i<chessBoard.length; i++) {
            for(int j=0; j<chessBoard[i].length; j++) {
                if(chessBoard[i][j] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }

    // Two main functionalities
    // 1. Find if the Queen at columnIndex is in an attack position to other queens
        // Diagonal Attack - two diagonals 1. left to right and 2. right to left
        // Horizontal Attack

    // 2. Backtracking logic
         // Start at a column
}
