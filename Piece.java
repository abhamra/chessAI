import java.util.*;

public class Piece {

	protected BoardLoc pos;
	protected int pts;

	protected ArrayList<BoardLoc> moves;

	public Piece(int r, int c)
	{
		pos.r = r;
		pos.c = c;
		pos.piece = this;

		moves = new ArrayList<BoardLoc>();
	}

	public void generateValidMoves() { // OVERRIDE this method
		
	}

	public boolean move(BoardLoc location) {
		pos.piece = null;
		pos = location;

		if(location.piece == null) {
			location.piece = this;
			return true;
		}
		else {
			return false;
		}
	}
}
