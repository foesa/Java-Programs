import java.util.Arrays;

public class Connect4Grid2DArray implements Connect4Grid {
	private int[][] connect4Grid;
	private int columnOflastPiece;
	private int rowOfLastPiece;

	public Connect4Grid2DArray() {
		connect4Grid = new int[6][7];
	}

	public void emptyGrid() {
		for (int count = 0; count < connect4Grid.length; count++) {
			Arrays.fill(connect4Grid[count], 0);
		}
	}

	public boolean isValidColumn(int column) {
		if (column < connect4Grid.length) {
			return true;
		}
		return false;
	}

	public boolean isColumnFull(int column) {
		if (connect4Grid[0][column] != 0) {
			System.out.println("Full column");
			return true;
		}
		return false;
	}

	public void dropPiece(ConnectPlayer player, int column) {
		int droppiece = player.getPlayerPiece();
		boolean madeMove = false;
		if (isValidColumn(column) && !isColumnFull(column)) {
			int count = 0;
			while (!madeMove) {
				if (count < 6) {
					if (connect4Grid[5 - count][column] == 0) {
						connect4Grid[5 - count][column] = droppiece;
						madeMove = true;
						columnOflastPiece = column;
						rowOfLastPiece = 5 - count;
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
		}
		if (columnOflastPiece <= 3) {
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece][columnOflastPiece
						+ count]) && count == 3) { 
					return true;
				}
			}
		}
		if (rowOfLastPiece < 3) {
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						+ count][columnOflastPiece]) && count == 3) {
					return true;
				}
			}
		}
		// diagonal down left
		if (rowOfLastPiece <= 2 && columnOflastPiece >= 3) {
			int numOfmatches = 0;
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						+ count][columnOflastPiece - count])) {
					numOfmatches++;
				}
				if (numOfmatches == 3) {
					return true;
				}
			}
		}
		// diagonal down right
		if (rowOfLastPiece <= 2 && columnOflastPiece <= 3) {
			int numOfmatches = 0;
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						+ count][columnOflastPiece + count])) {
					numOfmatches++;
				}
				if (numOfmatches == 3) {
					return true;
				}
			}
		}
		// diagonal up right
		if (rowOfLastPiece > 2 && columnOflastPiece <= 3) {
			int numOfmatches = 0;
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						- count][columnOflastPiece + count])) {
					numOfmatches++;
				}
				if (numOfmatches == 3) {
					return true;
				}
			}
		}
		// diagonal up left
		if (rowOfLastPiece > 2 && columnOflastPiece >= 3) {
			int numOfmatches = 0;
			for (int count = 0; count < 4; count++) {
				if ((connect4Grid[rowOfLastPiece][columnOflastPiece] == connect4Grid[rowOfLastPiece
						- count][columnOflastPiece - count])) {
					numOfmatches++;
				}
				if (numOfmatches == 3) {
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

	public int[][] returnGrid() {
		int[][] returnGrid = this.connect4Grid;
		return returnGrid;
	}

	public String toString() {
		int row = 0;
		int oldRowNumber = 0;
		String boardString = "";
		for (int count = 0; count < connect4Grid[0].length; count++) {
			if (row < connect4Grid.length) {
				if (row == oldRowNumber) {
					boardString += ("|" + connect4Grid[row][count] + "|");
				} else {
					boardString += "\n|" + connect4Grid[row][count] + "|";
					oldRowNumber = row;
				}
				if (count == 6) {
					row++;
					count = -1;
				}
			}
		}
		return boardString;
	}

	public int winnerPiece() {
		return connect4Grid[rowOfLastPiece][columnOflastPiece];
	}
}
