
import java.util.*;
public class BoardLoc {

	protected Piece piece;
	protected int r, c;

	protected boolean whiteKingCanHere;
	protected boolean blackKingCanHere;

	public BoardLoc(int r, int c)
	{
		piece = null;
		this.r = r;
		this.c = c;

		whiteKingCanHere = true;
		blackKingCanHere = true;

	}

	public BoardLoc(Piece piece, int r, int c)
	{
		this.piece = piece;
		this.r = r;
		this.c = c;

		whiteKingCanHere = true;
		blackKingCanHere = true;
	}

	public boolean equals(BoardLoc b){
		if(this.r == b.r && this.c == b.c){
			return true;
		}
		return false;
	}//end

	/*public void addPiece(Piece piece) { // perhaps not really necessary -- it's very easy to update piece object without this method
		this.piece = piece;
	}*/
}
