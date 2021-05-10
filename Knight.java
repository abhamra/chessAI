
import java.util.*;
public class Knight extends Piece {
    
    protected BoardLoc pos;
	protected int pts = 3;

    public Knight(int r, int c, boolean white, BoardLoc[][] board){
        super(r, c, white, board);

    }//end constructor

    public void generateValidMoves(BoardLoc[][] board) {
        moves = new ArrayList<BoardLoc>();
        int[] dr = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dc = {2, -2, 2, -2, 1, -1, 1, -1};
        for(int i = 0; i < 8; i++) {
          int nr = pos.r;
          int nc = pos.c;
            nr += dr[i];
            nc += dc[i];
            if(board[nr][nc].piece == null) {
                moves.add(board[nr][nc]);
            }
            else if((board[nr][nc].piece.white && this.white)
                    || !board[nr][nc].piece.white && !this.white) {
                break;
            }
            else if((board[nr][nc].piece.white && !this.white)
                    || !board[nr][nc].piece.white && this.white) {
                moves.add(board[nr][nc]);
                break;
            }
        }
      }

}//end class
