import java.util.*;

public class Piece {

	protected BoardLoc pos;
	protected int pts;
	protected boolean white; // if true, white -- if false, black

	protected ArrayList<BoardLoc> moves;

	public Piece(int r, int c, boolean white)
	{
		pos.r = r;
		pos.c = c;
		pos.piece = this;

		this.white = white;

		moves = new ArrayList<BoardLoc>();
	}

	public void generateValidMoves() { // OVERRIDE this method

	}

	public boolean move(BoardLoc location) {
		pos.piece = null;
		pos = location;

		if(location.piece == null && moves.contains(location)) {
			location.piece = this;
			return true;
		}
		else if((location.piece.white && !this.white)
			 	 || (!location.piece.white && this.white)
				 && moves.contains(location)) { // this piece takes enemy piece
			location.piece = this;
			return true;
		}
		else {
			return false;
		}
	}
}
