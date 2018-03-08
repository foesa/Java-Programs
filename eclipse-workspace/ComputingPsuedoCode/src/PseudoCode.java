
public class PseudoCode {
	public static int getValue(int row, int column) {
		return 0;
	}

	public static boolean isValidBox(int row, int column) {
		int currentIndexRow = row;
		int currentIndexColumn = column;
		int boxBoundaryRow = row + 3;
		int boxBoundaryColumn = column + 3;
		int compChar;
		int nextRowAdder = 0;
		compChar = getValue(currentIndexRow, currentIndexColumn);
		for (int columnCount = 0; columnCount < boxBoundaryColumn - currentIndexColumn; columnCount++) {
			if (compChar == 0) {
				if (currentIndexColumn + columnCount == boxBoundaryColumn) {
					nextRowAdder++;
					columnCount = 0;
				}
				if (nextRowAdder >= boxBoundaryRow - currentIndexRow) {
					columnCount = boxBoundaryColumn;
				}
				compChar = getValue(currentIndexRow + nextRowAdder, currentIndexColumn + columnCount);
			} else {
				for (int count = 0; count < boxBoundaryColumn - currentIndexColumn; count++) { // remember to increase
																								// count second it
																								// branches it not at
																								// end )
					if (!(currentIndexColumn + count == currentIndexColumn)) {
						int nextRowAdder1 = 0;
						if (compChar == getValue(currentIndexRow + nextRowAdder1, currentIndexColumn + count)) {
							return false;
						}
						if (currentIndexColumn + count == boxBoundaryColumn) {
							nextRowAdder1++;
							count = 0;
						}
						if (nextRowAdder1 >= boxBoundaryRow - currentIndexRow) {
							count = boxBoundaryColumn;
						}
					}
				}
				if (currentIndexColumn + columnCount == boxBoundaryColumn) {
					nextRowAdder++;
					columnCount = 0;
				}
				if (nextRowAdder >= boxBoundaryRow - currentIndexRow) {
					columnCount = boxBoundaryColumn;
				}
				compChar = getValue(currentIndexRow + nextRowAdder, currentIndexColumn + columnCount);
			}
		}
		return true;
	}

	boolean isValidRow(int row, int column) {
		int maxNumberofReps = 9;
		int compChar = getValue(row, column);
		int increaseRow = 1;
		for (int outerCount = 0; outerCount < maxNumberofReps; outerCount++) {
			int innerIncreaseRow = 1;
			if (compChar == 0) {
				compChar = getValue(row + increaseRow, column);
				increaseRow++;
			} else {
				for (int innerCount = 0; innerCount < maxNumberofReps - (increaseRow + row - 1); innerCount++) {
					if (compChar == getValue(row + innerIncreaseRow, column)) {
						return false;
					} else {
						innerIncreaseRow++;
					}
				}
				compChar = getValue(row + increaseRow, column);
				increaseRow++;
			}
		}
		return true;
	}

	boolean isValidColumn(int column, int row) {
		int maxNumberofReps = 9;
		int compChar = getValue(row, column);
		int increaseColumn = 1;
		for (int outerCount = 0; outerCount < maxNumberofReps; outerCount++) {
			int innerIncreaseColumn = 1;
			if (compChar == 0) {
				compChar = getValue(row, column + increaseColumn);
				increaseColumn++;
			} else {
				for (int innerCount = 0; innerCount < maxNumberofReps - (increaseColumn + row - 1); innerCount++) {
					if (compChar == getValue(row, column + innerIncreaseColumn)) {
						return false;
					} else {
						innerIncreaseColumn++;
					}
				}
				compChar = getValue(row, column + increaseColumn);
				increaseColumn++;
			}
		}
		return true;
	}
}
