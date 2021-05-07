public class Rook extends Piece {

  protected int pts = 5;

  public Rook(int r, int c, boolean white)
  {
    super(r, c, white);
  }

  public void generateValidMoves(BoardLoc[][] board) {
    super.moves = new ArrayList<BoardLoc>();
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};
    for(int i = 0; i < 4; i++) {
      int nr = super.pos.r;
      int nc = super.pos.c;
      while(nr < board.length && nr >= 0
         && nc < board[0].length && nc >= 0) {
        nr += dr[i];
        nc += dc[i];
        if(board[nr][nc].piece == null) {
          super.moves.add(board[nr][nc]);
        }
        else if((board[nr][nc].piece.white && this.white)
              || !board[nr][nc].piece.white && !this.white) {
          break;
        }
        else if((board[nr][nc].piece.white && !this.white)
              || !board[nr][nc].piece.white && this.white) {
          super.moves.add(board[nr][nc]);
          break;
        }
      }
    }
  }
}
