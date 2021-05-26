public class Move {
    
    String pieceName;
    String action;
    BoardLoc move;
    BoardLoc currPos;
    boolean white;

    public Move(String pieceName, String action, BoardLoc move, BoardLoc currPos, boolean white){
        this.pieceName = pieceName;
        this.action = action;
        this.move = move;
        this.currPos = currPos;
        this.white = white;
    }//end constructor

    public String toString(){
        return move.r + " " + move.c;
    }//end

}//end
