
import java.util.*;
public class Bishop extends Piece {
    
    protected BoardLoc pos;
	protected int pts = 3;
  protected String pieceName = "B";

    public Bishop(int r, int c, boolean white, BoardLoc[][] board, String pieceName){
        super(r, c, white, board, pieceName);

    }//end constructor
    
    public void generateValidMoves(BoardLoc[][] board) {
        moves = new ArrayList<BoardLoc>();
        int[] dr = {1, -1, 1, -1};
        int[] dc = {1, 1, -1, -1};
        for(int i = 0; i < 4; i++) {
          int nr = pos.r;
          int nc = pos.c;
          while(nr < board.length && nr >= 0
             && nc < board[0].length && nc >= 0) {
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
      }

}//end class
