
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
        pieces.add(new Pawn(6, i, true, board, null));
      }
      // set up the rest of white pieces
      pieces.add((king = new King(7, 4, true, board, null)));
      pieces.add(new Queen(7, 3, true, board, "Q"));

      pieces.add(new Bishop(7, 2, true, board, "B"));
      pieces.add(new Bishop(7, 5, true, board, "B"));

      pieces.add(new Knight(7, 1, true, board, "N"));
      pieces.add(new Knight(7, 6, true, board, "N"));

      pieces.add(new Rook(7, 0, true, board, "R"));
      pieces.add(new Rook(7, 7, true, board, "R"));
    }
    else {
      for(int i = 0; i < 8; i++) { // set up black pawns
        pieces.add(new Pawn(1, i, false, board, null));
      }
      // set up the rest of black pieces
      pieces.add((king = new King(0, 3, false, board, "K")));
      pieces.add(new Queen(0, 4, false, board, "Q"));

      pieces.add(new Bishop(0, 2, false, board, "B"));
      pieces.add(new Bishop(0, 5, false, board, "B"));

      pieces.add(new Knight(0, 1, false, board, "K"));
      pieces.add(new Knight(0, 6, false, board, "K"));

      pieces.add(new Rook(0, 0, false, board, "R"));
      pieces.add(new Rook(0, 7, false, board, "R"));
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

  // public void generateRandomMove(){
  //   Piece randPiece = pieces.get(Math.floor(Math.random()*(pieces.size()-0+1)+0));
  //   Move randMove = randPiece.moves.get(Math.floor(Math.random()*(randPiece.moves.size()-0+1)+0));

  //   randPiece.move(randMove.move);
  // }//end

  public ArrayList generatePossibleMoves(){
    ArrayList<Move> possibleMoves = new ArrayList<Move>();
    for(int i = 0;i<pieces.size();i++){
      possibleMoves.addAll(pieces.get(i).moves);
    }//end
    return possibleMoves;
  }//end

}
