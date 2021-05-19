
import java.util.*;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Rook extends Piece {

  protected int pts = 5;
  protected String pieceName = "R";
  protected int relStrength = 50;
  //protected int timesMoved; -- don't need anymore; made a instance variable in the Piece class

  public Rook(int r, int c, boolean white, BoardLoc[][] board, String pieceName)
  {
    super(r, c, white, board, pieceName);
    //timesMoved = 0;

    if(white) {
      try {
		     URL url = getClass().getResource("White rook (simple)-1.png.png");
			   super.image = ImageIO.read(url);
		  } catch(Exception e) {
			   e.printStackTrace();
		  }
    }
    else {
      try {
		     URL url = getClass().getResource("Black rook (simple)-1.png.png");
			   super.image = ImageIO.read(url);
		  } catch(Exception e) {
			   e.printStackTrace();
		  }
    }
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
          //super.moves.add(board[nr][nc]); // just add it to valid moves
          super.moves.add(new Move(this.pieceName, "", board[nr][nc], this.white));
        }
        else if((board[nr][nc].piece.white && this.white)
              || !board[nr][nc].piece.white && !this.white) { // if same color
          break; // don't consider as valid move and break immediately because you can't friendly fire
        }
        else if((board[nr][nc].piece.white && !this.white)
              || !board[nr][nc].piece.white && this.white) { // if diff color
          //super.moves.add(board[nr][nc]); // consider taking it
          super.moves.add(new Move(this.pieceName, "x", board[nr][nc], this.white));
          break; // then break cuz you can't move past the piece if you want to take it
        }
      }
    }
  }
}
