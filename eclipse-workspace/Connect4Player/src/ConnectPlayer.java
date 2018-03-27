
abstract class ConnectPlayer {
	private int playerPiece;
	
	public ConnectPlayer(int piece) {
		playerPiece = piece;
	}
	
	public int getPlayerPiece() {
		return playerPiece;
	}
	
	public boolean isMoveValid(int column,Connect4Grid2DArray game) {
		if(game.isValidColumn(column)&&!(game.isColumnFull(column))) {
			return true;
		}
		return false;
	}
	abstract void makeMove(Connect4Grid2DArray game);
}
