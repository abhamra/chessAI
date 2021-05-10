
import java.util.*;
public class Pawn extends Piece {

    protected int timesMoved;
    protected int pts = 1;

    public Pawn(int r, int c, boolean white, BoardLoc[][] board)
    {
        super(r, c, white, board);
        timesMoved = 0;
    }//end constructor

    public void generateValidMoves(BoardLoc[][] board) {
      moves = new ArrayList<BoardLoc>(); // YO, this is kinda not efficient, I will try to improve later...
      if(timesMoved == 0) { // first move
        if(white) {
          moves.add(board[pos.r - 2][pos.c]);
          moves.add(board[pos.r - 1][pos.c]);
        }
        else {
          moves.add(board[pos.r + 2][pos.c]);
          moves.add(board[pos.r + 1][pos.c]);
        }
      }
      else { // already moved once or more
        if(white) {
          moves.add(board[pos.r - 1][pos.c]);
        }
        else {
          moves.add(board[pos.r + 1][pos.c]);
        }
      }

    }

    public boolean move(BoardLoc location) { // I need to override the generic "move" method for the pawn because it is a special case
      if(moves.contains(location) && location.piece == null) {
        location.piece = this;
        super.pos.piece = null;
        super.pos = location;
        timesMoved++;
        return true;
      }
      else {
        if(white) {
          if(Math.abs(location.c - super.pos.c) == 1 && location.r - super.pos.r == -1 && !location.piece.white) {
            location.piece = this;
            super.pos.piece = null;
            super.pos = location;
            timesMoved++;
            return true;
          }
        }
        else {
          if(Math.abs(location.c - super.pos.c) == 1 && location.r - super.pos.r == 1 && location.piece.white) {
            location.piece = this;
            super.pos.piece = null;
            super.pos = location;
            timesMoved++;
            return true;
          }
        }
      }

      if(location.r == super.pos.r && location.piece.pts == 1 && ((Pawn)location.piece).timesMoved == 1) {
        location.piece = this;
        super.pos.piece = null;
        super.pos = location;
        timesMoved++;
        return true;
      }

      return false;
    }

}//end class
