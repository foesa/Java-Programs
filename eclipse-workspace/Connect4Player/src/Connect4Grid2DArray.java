import java.util.Arrays;

public class Connect4Grid2DArray implements Connect4Grid {
	private int[][] connect4Grid;
	private int columnOflastPiece;
	private int rowOfLastPiece;

	public Connect4Grid2DArray() {
		connect4Grid = new int[6][7];
	}

	public void emptyGrid() {
		Arrays.fill(connect4Grid, 0);
	}

	public boolean isValidColumn(int column) {
		if (column < connect4Grid[0].length) {
			return true;
		}
		return false;
	}

	public boolean isColumnFull(int column) {
		if (connect4Grid[5][column] != 0) {
			System.out.println("Full column");
			return true;
		}
		return false;
	}

	public void dropPiece(ConnectPlayer player, int column) {
		int droppiece = player.getPlayerPiece();
		boolean madeMove = false;
		if (isValidColumn(column) && !isColumnFull(column)) {
			while (!madeMove) {
				int count = 0;
				if (count < 6) {
					if (connect4Grid[count][column] == 0) {
						connect4Grid[count][column] = droppiece;
						madeMove = true;
						columnOflastPiece = column;
						rowOfLastPiece = count;
					} else {
						count++;
					}
				} else {
					madeMove = true;
				}
			}
		}
	}

	public boolean didLastPieceConnect4() {
		if (columnOflastPiece >= 3) {
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece][columnOflastPiece
						- count]) && count == 3) {
					return true;
				}
			}
		} else if (columnOflastPiece <= 3) {
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece][columnOflastPiece
						+ count]) && count == 3) {
					return true;
				}
			}
		} else if ((columnOflastPiece > 2 && rowOfLastPiece > 2) || (columnOflastPiece >= 2 && rowOfLastPiece < 3)) {
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						- count][columnOflastPiece - count]) && count == 3) {
					return true;
				}
			}
		} else if (rowOfLastPiece > 2) {
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						- count][columnOflastPiece + count]) && count == 3) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isGridFull() {
		for (int count = 0; count < connect4Grid.length; count++) {
			if (connect4Grid[5][count] != 0 && count == connect4Grid.length - 1) {
				return true;
			}
		}
		return false;
	}

}
