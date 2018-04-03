
public class C4AiPlayer extends ConnectPlayer {
	private int lastColumnPlace;
	private int column;
	public C4AiPlayer(int piece) {
		super(piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Connect4Grid2DArray game) {
		if(lastColumnPlace != 3) {
			column++;
			if(isMoveValid(column, game)) {
				game.dropPiece(this, column);
			}
		}
		else {
			if(isMoveValid(column, game)) {
				game.dropPiece(this, column);
			}
		}
	}
	public void initialMove(Connect4Grid2DArray game) {
		column = 3;
		if(isMoveValid(column, game)) {
			game.dropPiece(this, column);
			lastColumnPlace = column;
		}
		else {
			game.dropPiece(this, column+1);
			lastColumnPlace = column+1;
		}
	}
}
