import java.util.*;
public class Rook extends Piece {

  protected int pts = 5;
  //protected int timesMoved; -- don't need anymore; made a instance variable in the Piece class

  public Rook(int r, int c, boolean white)
  {
    super(r, c, white);
    //timesMoved = 0;
  }

  public void generateValidMoves(BoardLoc[][] board) {
    super.moves = new ArrayList<BoardLoc>();
    int[] dr = {0, 1, 0, -1}; // handles the four directions
    int[] dc = {1, 0, -1, 0}; // handles the four directions
    for(int i = 0; i < 4; i++) { // iterates through the four directions
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
}
