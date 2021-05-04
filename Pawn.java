public class Pawn extends piece{

    protected int timesMoved;

    public Pawn(int r, int c, boolean white) {
        super(r, c, white);
        timesMoved = 0;
    }//end constructor

    public void generateValidMoves(BoardLoc[][] board) {
      moves = new ArrayList<BoardLoc>(); // YO, this is kinda not efficient, I will try to improve later...
      if(timesMoved == 0) { // first move
        if(white) {
          moves.add(board[r - 2][c]);
          moves.add(board[r - 1][c]);
        }
        else {
          moves.add(board[r + 2][c]);
          moves.add(board[r + 1][c]);
        }
      }
      else { // already moved once or more
        if(white) {
          moves.add(board[r - 1][c]);
        }
        else {
          moves.add(board[r + 1][c]);
        }
      }

    }

    public void move() {
      
    }

}//end class
