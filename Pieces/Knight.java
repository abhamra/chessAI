public class Knight extends Piece {
    
    protected BoardLoc pos;
	protected int pts = 3;

    public Knight(int r, int c){
        super(r, c);

    }//end constructor
    
    public void generateValidMoves(Chessboard board){
        for(int i = -2;i<3;i++){
            for(int j = -2;j<3;j++){
                if((Math.abs(i)+Math.abs(j))==3){
                    if(board[pos.r+i][pos.c+j]==null){
                        moves.add(board[pos.r+i][pos.c+j]);
                    }
                }
            }//end nested for
        }
    }//end func

}//end class
