public class BoardLoc {

	protected Piece piece;
	protected int r, c;

	public BoardLoc(int r, int c)
	{
		piece = null;
		this.r = r;
		this.c = c;
	}

	public BoardLoc(Piece piece, int r, int c)
	{
		this.piece = piece;
		this.r = r;
		this.c = c;
	}

	/*public void addPiece(Piece piece) { // perhaps not really necessary -- it's very easy to update piece object without this method
		this.piece = piece;
	}*/
}
