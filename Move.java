public class Move {
    
    String pieceName;
    String action;
    BoardLoc move;
    boolean white;

    public Move(String pieceName, String action, BoardLoc move, boolean white){
        this.pieceName = pieceName;
        this.action = action;
        this.move = move;
    }//end constructor

}//end
