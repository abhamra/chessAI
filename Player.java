
import java.util.*;

public class Player {

  protected boolean white;
  protected ArrayList<Piece> pieces;
  protected BoardLoc[][] board;

  protected King king;

  protected boolean isStalemate;

  public Player(BoardLoc[][] board, boolean white)
  {
    this.board = board;
    this.white = white;
    pieces = new ArrayList<Piece>();
    if(white) {
      for(int i = 0; i < 8; i++) { // set up white pawns
        pieces.add(new Pawn(6, i, true, board));
      }
      // set up the rest of white pieces
      pieces.add((king = new King(7, 4, true, board)));
      pieces.add(new Queen(7, 3, true, board));

      pieces.add(new Bishop(7, 2, true, board));
      pieces.add(new Bishop(7, 5, true, board));

      pieces.add(new Knight(7, 1, true, board));
      pieces.add(new Knight(7, 6, true, board));

      pieces.add(new Rook(7, 0, true, board));
      pieces.add(new Rook(7, 7, true, board));
    }
    else {
      for(int i = 0; i < 8; i++) { // set up black pawns
        pieces.add(new Pawn(1, i, true, board));
      }
      // set up the rest of black pieces
      pieces.add((king = new King(0, 3, true, board)));
      pieces.add(new Queen(0, 4, true, board));

      pieces.add(new Bishop(0, 2, true, board));
      pieces.add(new Bishop(0, 5, true, board));

      pieces.add(new Knight(0, 1, true, board));
      pieces.add(new Knight(0, 6, true, board));

      pieces.add(new Rook(0, 0, true, board));
      pieces.add(new Rook(0, 7, true, board));
    }

    isStalemate = false;
  }

  public boolean checkIsStalemate() {
    for(Piece p : pieces) {
      if(p.moves.size() > 0) {
        isStalemate = false;
        return isStalemate;
      }
    }

    if(!king.inCheck) {
      isStalemate = true;
      return isStalemate;
    }
    else {
      isStalemate = false;
      return isStalemate;
    }
  }

  public void checkIfPinned(Piece p) {

  }

  public void promotePawn(Pawn pawn, Piece promotion) {
    if((white && pawn.white && pawn.pos.r == 0)
    || (!white && !pawn.white && pawn.pos.r == 7)) {
      promotion.pos = pawn.pos;
      pawn.pos.piece = promotion;
      pawn = null;
    }
    if(white) {
      promotion.white = true;
    }
    else {
      promotion.white = false;
    }
  }
}
