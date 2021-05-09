public class Game {

  protected BoardLoc[][] board;
  protected Player player1;
  protected Player player2;

  protected int moveCount;

  public Game()
  {
    board = new BoardLoc[8][8];
    for(int r = 0; i < board.length; i++) {
      for(int c = 0; j < board[i].length; j++) {
        board[r][c] = new BoardLoc(r, c);
      }
    }

    player1 = new Player(board, true);
    player2 = new Player(board, false);

    moveCount = 0;
  }

  
}
