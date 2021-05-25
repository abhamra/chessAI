

import java.util.*;
public class Game {

  protected BoardLoc[][] board;
  protected Player player1;
  protected Player player2;

  protected Piece p1Selected;
  protected Piece p2Selected;

  protected int moveCount;

  public Game()
  {
    board = new BoardLoc[8][8];
    for(int r = 0; r < board.length; r++) {
      for(int c = 0; c < board[0].length; c++) {
        board[r][c] = new BoardLoc(r, c);
      }
    }

    player1 = new Player(board, true);//white
    player2 = new Player(board, false);

    p1Selected = null;
    p2Selected = null;

    moveCount = 0;
  }

  public int evaluateBoard(BoardLoc[][] board){
    int totalEvaluation = 0;
    for(int r = 0;r<board.length;r++){
      for(int c = 0;c<board[0].length;c++){
        totalEvaluation += board[r][c].piece.relStrength;
      }//end nested for
    }
    return totalEvaluation;
  }//end func

  public Move minimaxRoot(int depth, Game game, Player white, Player black, int moveCount){
    //initializing variables
    int bestMove = -9999;
    Move bestMoveFound = null;

    ArrayList<Move> possibleMoves = new ArrayList<Move>();
    if(moveCount%2==0){
      possibleMoves = white.generatePossibleMoves();
    } else if(moveCount%2!=0){
      possibleMoves = black.generatePossibleMoves();
    }//end if for possible moves generation

    for(int i = 0;i<possibleMoves.size();i++){

      Move m = possibleMoves.get(i);

      game.board[m.currPos.r][m.currPos.c].piece.move(m.move);//make the move

      int value = minimax(depth-1, game, white, black, moveCount+1);
      //UNDO THE MOVE
      game.board[m.move.r][m.move.c].piece.undoMove(m);

      if(value>=bestMove){
        bestMove = value;
        bestMoveFound = m;
      }

    }//end

    return bestMoveFound;

  }//end func

  public int minimax(int depth, Game game, Player white, Player black, int moveCount){

    moveCount++;

    //initialize
    ArrayList<Move> possibleMoves = new ArrayList<Move>();

    if (depth == 0) {//checking if "leaf node"
      return -evaluateBoard(game.board);
    }
    if(moveCount%2==0){
      possibleMoves = white.generatePossibleMoves();
    } else if(moveCount%2!=0){
      possibleMoves = black.generatePossibleMoves();
    }//end if for possible moves generation

    if(moveCount%2==0){
      int bestMove = -9999;
        for (int i = 0; i < possibleMoves.size(); i++) {
            //MAKE THE MOVE FROM POSSIBLEMOVES.GET(I);

            Move m = possibleMoves.get(i);

            game.board[m.currPos.r][m.currPos.c].piece.move(m.move);//make the move

            bestMove = Math.max(bestMove, minimax(depth - 1, game, white, black, moveCount));
            //UNDO THE MOVE
            game.board[m.move.r][m.move.c].piece.undoMove(m);

        }//end

        return bestMove;

    } else {

        int bestMove = 9999;
        for (int i = 0; i < possibleMoves.size(); i++) {
            //MAKE THE MOVE FROM POSSIBLEMOVES.GET(I);
            bestMove = Math.min(bestMove, minimax(depth - 1, game, white, black, moveCount));
            //UNDO THE MOVE
        }

        return bestMove;

    }//end if & else

  }//end func

}//end class
