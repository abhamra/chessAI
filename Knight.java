
import java.util.*;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Knight extends Piece {

    protected BoardLoc pos;
	protected int pts = 3;
    protected int relStrength = 30;
    protected String pieceName = "N";

    public Knight(int r, int c, boolean white, BoardLoc[][] board, String pieceName){
        super(r, c, white, board, pieceName);
        if(white) {
          try {
    		     URL url = getClass().getResource("White_knight_(simple)-1.png");
    			   super.image = ImageIO.read(url);
    		  } catch(Exception e) {
    			   e.printStackTrace();
    		  }
        }
        else {
          try {
    		     URL url = getClass().getResource("Black_knight_(simple)-1.png");
    			   super.image = ImageIO.read(url);
    		  } catch(Exception e) {
    			   e.printStackTrace();
    		  }
        }
    }//end constructor

    public void generateValidMoves(BoardLoc[][] board) {
        moves = new ArrayList<Move>();
        int[] dr = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dc = {2, -2, 2, -2, 1, -1, 1, -1};
        for(int i = 0; i < 8; i++) {
          int nr = pos.r;
          int nc = pos.c;
            nr += dr[i];
            nc += dc[i];
            if(board[nr][nc].piece == null) {
                //moves.add(board[nr][nc]);
                super.moves.add(new Move(this.pieceName, "", board[nr][nc], board[pos.r][pos.c], this.white));
            }
            else if((board[nr][nc].piece.white && this.white)
                    || !board[nr][nc].piece.white && !this.white) {
                break;
            }
            else if((board[nr][nc].piece.white && !this.white)
                    || !board[nr][nc].piece.white && this.white) {
                //moves.add(board[nr][nc]);
                super.moves.add(new Move(this.pieceName, "x", board[nr][nc], board[pos.r][pos.c], this.white));
                break;
            }
        }
      }

}//end class
