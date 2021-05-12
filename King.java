
import java.util.*;

public class King extends Piece {

  //protected int pts;
  protected boolean inCheck;
  protected boolean gameOver;

  protected int pts;

  public King(int r, int c, boolean white, BoardLoc[][] board)
  {
    super(r, c, white, board);
    inCheck = false;
    gameOver = false;

    pts = 0; // I'm just making a point value because I will use it to determine if a piece is the King
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

    if(moves.size() == 0 && inCheck) { // checks for CHECKMATE (get dad-joked, Sandro would be proud)
      gameOver = true;
    }

    // Note: I plan to handle stalemates in the Player class because stalemates depend on knowing the states of other pieces
  }

  public boolean isInCheck(Player opponent) {
    /*for(int i = 0; i < opponent.pieces.size(); i++) { // I've commented this part out because I will need to edit it when the Move class is done
      Piece p = opponent.pieces(i);
      for(int j = 0; j < p.moves; j++) {
        if(super.pos = p.moves.get(j)) {
          return true;
        }
      }
    }
    return false;
    */
    return false;
  }//end

  public void castle(BoardLoc[][] board, Rook rook) {
    if(rook.timesMoved == 0 && super.timesMoved == 0) { // if both have not been moved before
      if((rook.white && this.white) || (!rook.white && !this.white)) { // See, this is where I might use the sameColor method instead, but we'll see...
        if(this.white) {
          if(rook.pos.c < super.pos.c) { // white queen's side castle
            BoardLoc b = super.pos;
            // checks if the spaces are threatened by enemy pieces or occupied by pieces (whether friendly or enemy)
            if(board[super.pos.r][super.pos.c - 2].whiteKingCanHere && board[super.pos.r][super.pos.c - 2].piece == null
            && board[super.pos.r][super.pos.c - 1].whiteKingCanHere && board[super.pos.r][super.pos.c - 1].piece == null) {
              // move King
              super.pos.piece = null;
              super.pos = board[b.r][b.c - 2];
              super.pos.piece = this;

              // move Rook
              rook.pos.piece = null;
              rook.pos = board[rook.pos.r][rook.pos.c + 3];
              rook.pos.piece = rook;
            }
          }
          else { // white king's side castle
            BoardLoc b = super.pos;
            // checks if the spaces are threatened by enemy pieces or occupied by pieces (whether friendly or enemy)
            if(board[super.pos.r][super.pos.c + 2].whiteKingCanHere && board[super.pos.r][super.pos.c + 2].piece == null
            && board[super.pos.r][super.pos.c + 1].whiteKingCanHere && board[super.pos.r][super.pos.c + 1].piece == null) {
              // move King
              super.pos.piece = null;
              super.pos = board[b.r][b.c + 2];
              super.pos.piece = this;

              // move Rook
              rook.pos.piece = null;
              rook.pos = board[rook.pos.r][rook.pos.c - 2];
              rook.pos.piece = rook;
            }
          }
        }
        else {
          if(rook.pos.c < super.pos.c) { // black king's side castle
            BoardLoc b = super.pos;
            // checks if the spaces are threatened by enemy pieces or occupied by pieces (whether friendly or enemy)
            if(board[super.pos.r][super.pos.c - 2].blackKingCanHere && board[super.pos.r][super.pos.c - 2].piece == null
            && board[super.pos.r][super.pos.c - 1].blackKingCanHere && board[super.pos.r][super.pos.c - 1].piece == null) {
              // move King
              super.pos.piece = null;
              super.pos = board[b.r][b.c - 2];
              super.pos.piece = this;

              // move Rook
              rook.pos.piece = null;
              rook.pos = board[rook.pos.r][rook.pos.c + 2];
              rook.pos.piece = rook;
            }
          }
          else { // black queen's side castle
            BoardLoc b = super.pos;
            // checks if the spaces are threatened by enemy pieces or occupied by pieces (whether friendly or enemy)
            if(board[super.pos.r][super.pos.c + 2].blackKingCanHere && board[super.pos.r][super.pos.c + 2].piece == null
            && board[super.pos.r][super.pos.c + 1].blackKingCanHere && board[super.pos.r][super.pos.c + 1].piece == null) {
              // move King
              super.pos.piece = null;
              super.pos = board[b.r][b.c + 2];
              super.pos.piece = this;

              // move Rook
              rook.pos.piece = null;
              rook.pos = board[rook.pos.r][rook.pos.c - 3];
              rook.pos.piece = rook;
            }
          }
        }
      }
    }
  }
}
