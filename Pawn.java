
import java.util.*;
public class Pawn extends Piece {

    protected int timesMoved;
    protected int pts = 1;
    protected int relStrength = 10;
    protected String pieceName = null;
    protected Stack<Move> prevMoves = new Stack<Move>();

    public Pawn(int r, int c, boolean white, BoardLoc[][] board, String pieceName)
    {
        super(r, c, white, board, pieceName);
        timesMoved = 0;
    }//end constructor

    public void generateValidMoves(BoardLoc[][] board) {
      super.moves = new ArrayList<Move>(); // YO, this is kinda not efficient, I will try to improve later...
      if(timesMoved == 0) { // first move
        if(white) {
          //moves.add(board[pos.r - 2][pos.c]);
          moves.add(new Move(this.pieceName, "", board[pos.r - 2][pos.c], board[pos.r][pos.c], this.white));
          //moves.add(board[pos.r - 1][pos.c]);
          moves.add(new Move(this.pieceName, "", board[pos.r - 1][pos.c], board[pos.r][pos.c], this.white));
        }
        else {
          //moves.add(board[pos.r + 2][pos.c]);
          moves.add(new Move(this.pieceName, "", board[pos.r + 2][pos.c], board[pos.r][pos.c], this.white));
          //moves.add(board[pos.r + 1][pos.c]);
          moves.add(new Move(this.pieceName, "", board[pos.r + 1][pos.c],board[pos.r][pos.c], this.white));
        }
      }
      else { // already moved once or more
        if(white) {
          //moves.add(board[pos.r - 1][pos.c]);
          moves.add(new Move(this.pieceName, "", board[pos.r - 1][pos.c], board[pos.r][pos.c],this.white));
        }
        else {
          //moves.add(board[pos.r + 1][pos.c]);
          moves.add(new Move(this.pieceName, "", board[pos.r + 1][pos.c], board[pos.r][pos.c], this.white));
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
