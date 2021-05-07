import java.util.*;

public class King extends Piece {

  //protected int pts;
  protected boolean inCheck;
  protected boolean gameOver;

  public King(int r, int c, boolean white)
  {
    super(r, c, white);
    inCheck = false;
    gameOver = false;
  }

  public void generateValidMoves(BoardLoc[][] board) {
    moves = new ArrayList<BoardLoc>();
    int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    for(int i = 0; i < dr.length; i++) { // iterate through possible moves
      int nr = pos.r + dr[i];
      int nc = pos.c + dc[i];
      if(nr < board.length && nr >= 0 && nc < board[0].length && nc >= 0) { // makes sure it's still within the bounds of the board
        if(white && board[nr][nc].whiteKingCanHere) { // checks if it's a safe spot (for white King)
          if(board[nr][nc].piece == null || !board[nr][nc].piece.white) { // checks if tile is empty or contains enemy piece that can be taken
            moves.add(board[nr][nc]);
          }
        }
        if(!white && board[nr][nc].blackKingCanHere) { // checks if it's a safe spot (for black King)
          if(board[nr][nc].piece == null || board[nr][nc].piece.white) { // checks if tile is empty or contains enemy piece that can be taken
            moves.add(board[nr][nc]);
          }
        }
      }
    }

    if(moves.size() == 0 && inCheck) { // checks for checkmate (get dad-joked, Sandro would be proud)
      gameOver = true;
    }

    // Note: I plan to handle stalemates in the Player class because stalemates depend on knowing the states of other pieces
  }
}
