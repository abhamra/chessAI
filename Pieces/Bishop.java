public class Bishop extends Piece {
    
    protected BoardLoc pos;
	protected int pts = 3;

    public Bishop(int r, int c){
        super(r, c);

    }//end constructor
    
    public void generateValidMoves(Chessboard board){
        for(int i = 0;i<pos.r;i++){//bottom left
            if(board[pos.r-i][pos.c-i]==null){
                moves.add(board[pos.r-i][pos.c-i]);
            }
        }//end for
        for(int i = 0;pos.r-i>0 || pos.c-i>0;i++){//bottom left
            if(board[pos.r-i][pos.c-i]==null){
                moves.add(board[pos.r+i][pos.c-i]);//add to r to go down
            }
        }//end for
    }//end func

}//end class
