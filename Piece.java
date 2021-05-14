
import java.util.*;

public class Piece {

	protected BoardLoc pos;
	protected int pts;
	protected boolean white; // if true, white -- if false, black
	protected String pieceName;
	protected int relStrength;

	protected ArrayList<Move> moves;

	protected int timesMoved;

	public Piece(int r, int c, boolean white)
	{
		pos = new BoardLoc(r, c);
		pos.piece = this;

		this.white = white;

		if(!white){
			relStrength*=-1;
		}

		moves = new ArrayList<Move>();
		timesMoved = 0;
	}

	public Piece(int r, int c, boolean white, BoardLoc[][] board, String pieceName)
	{
		pos = board[r][c];
		pos.piece = this;

		this.white = white;

		moves = new ArrayList<Move>();
		timesMoved = 0;
	}

	public void generateValidMoves() { // OVERRIDE this method

	}

	public boolean move(BoardLoc location) {
		//pos.piece = null;
		//pos = location;

		if(location.piece == null && moves.contains(location)) {
			location.piece = this;
			pos.piece = null;
			this.pos = location;
			timesMoved++;
			return true;
		}
		else if((location.piece.white && !this.white)
			 	 || (!location.piece.white && this.white)
				 && moves.contains(location)) { // this piece takes enemy piece
			location.piece = this;
			pos.piece = null;
			this.pos = location;
			timesMoved++;
			return true;
		}
		else {
			return false;
		}
	}

	/*public boolean sameColor() { -- I may consider implementing this since it comes up in a lot of places

	}*/
}
