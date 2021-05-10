
import java.util.*;

public class Queen extends Piece {

  protected int pts = 9;

  public Queen(int r, int c, boolean white, BoardLoc[][] board)
  {
    super(r, c, white, board);
  }

  public void generateValidMoves(BoardLoc[][] board) {
    super.moves = new ArrayList<BoardLoc>();
    int[] dr = {0, 1, 1, 1, 0, -1, -1, -1}; // handles the eight directions
    int[] dc = {1, 1, 0, -1, -1, -1, 0, 1}; // handles the eight directions
    for(int i = 0; i < dr.length; i++) { // iterates through the eight directions
      int nr = super.pos.r;
      int nc = super.pos.c;
      while(nr < board.length && nr >= 0
         && nc < board[0].length && nc >= 0) { // while edge has not been found
        nr += dr[i];
        nc += dc[i];
        if(board[nr][nc].piece == null) { // if no piece in current tile
          super.moves.add(board[nr][nc]); // just add it to valid moves
        }
        else if((board[nr][nc].piece.white && this.white)
              || !board[nr][nc].piece.white && !this.white) { // if same color
          break; // don't consider as valid move and break immediately because you can't friendly fire
        }
        else if((board[nr][nc].piece.white && !this.white)
              || !board[nr][nc].piece.white && this.white) { // if diff color
          super.moves.add(board[nr][nc]); // consider taking it
          break; // then break cuz you can't move past the piece if you want to take it
        }
      }
    }
  }
}//end of class

