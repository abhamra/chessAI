public class Pawn extends Piece{

    protected int timesMoved;
    protected int pts = 1;

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

    public void move(BoardLoc location) { // I need to override the generic "move" method for the pawn because it is a special case
      if(moves.contains(location) && ) { // aaaa I didn't finish this -- incomplete code -- will revisit later
        
      }
    }

}//end class
