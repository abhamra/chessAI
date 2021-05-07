public class Bishop extends Piece {
    
    protected BoardLoc pos;
	protected int pts = 3;

    public Bishop(int r, int c){
        super(r, c);

    }//end constructor
    
    public void generateValidMoves(BoardLoc[][] board) {
        super.moves = new ArrayList<BoardLoc>();
        int[] dr = {1, -1, 1, -1};
        int[] dc = {1, 1, -1, -1};
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

}//end class
