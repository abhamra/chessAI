
import java.util.*;
import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Piece {

	protected BoardLoc pos;
	protected int pts;
	protected boolean white; // if true, white -- if false, black
	protected String pieceName;
	protected int relStrength;

	protected ArrayList<Move> moves;
	protected Stack<Move> prevMoves;

	protected int timesMoved;

	protected Image image;

	public Piece(int r, int c, boolean white)
	{
		pos = new BoardLoc(r, c);
		pos.piece = this;

		this.white = white;

		if(!white){
			relStrength*=-1;
		}

		moves = new ArrayList<Move>();
		prevMoves = new Stack<Move>();
		timesMoved = 0;
	}

	public Piece(int r, int c, boolean white, BoardLoc[][] board, String pieceName)
	{
		pos = board[r][c];
		pos.piece = this;

		this.white = white;

		moves = new ArrayList<Move>();
		timesMoved = 0;

		this.pieceName = pieceName;
	}

	public void generateValidMoves() { // OVERRIDE this method

	}

	public void undoMove(Move move){
		//finish later, take the "currentPosition" from the move and pass that through
		pos.r = move.currPos.r;
		pos.c = move.currPos.c;
	}//end func

	public boolean move(BoardLoc location) {
		//pos.piece = null;
		//pos = location;

		if(location.piece == null) {
			if(moves.contains(location)) {
				location.piece = this;
				pos.piece = null;
				this.pos = location;
				timesMoved++;
				//prevMoves.push(new Move(pieceName, "", location, new BoardLoc(pos.r, pos.c),this.white));
				return true;
			}
		}
		else if((location.piece.white && !this.white)
			 	 || (!location.piece.white && this.white)
				 && moves.contains(location)) { // this piece takes enemy piece
			location.piece = this;
			pos.piece = null;
			this.pos = location;
			timesMoved++;
			//public Move(String pieceName, String action, BoardLoc move, boolean white){
				prevMoves.push(new Move(pieceName, "x", location, new BoardLoc(pos.r, pos.c),this.white));
			return true;
		}

		return false;
	
	}

	/*public boolean sameColor() { -- I may consider implementing this since it comes up in a lot of places

	}*/

	public void draw(Graphics window) {
		window.drawImage(image, pos.c * 100, pos.r * 100, 100, 100, null);
	}
}
