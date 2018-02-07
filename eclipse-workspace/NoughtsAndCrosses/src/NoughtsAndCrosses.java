
/* SELF ASSESSMENT 
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment: followed coding standard
Did I use loops to set each position to the BLANK character?
Mark out of 5:5
Comment: used a for loop
   2. printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment: followed coding standard
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment: prints out to look like aboard
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment:followed coding standard
Did I check if a specified location was BLANK?
Mark out of 5: 5
Comment:if blank returns true
   4. makeMove
Did I have the correct function definition?
Mark out of 5: 5
Comment: Follows coding standard
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5:5
Comment: Checked by printing out the board after to see if it works
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5: 5
Comment: doesn't return anything(void) and defined according to the coding standard       
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5: 5
Comment: Loops through the board and if there's a blank board returns false
   6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5:5
Comment: returns winning character if 3 are in a row, followed coding standard     
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15:15 
Comment: checked each of the possibilities to ensure they work before submitting 
7.main
Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3: 3
Comments:loops through the array placing a blank character in each cell
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:5
Comments: asks for a new position and piece each time till there's a winner or the bord is full
Did I call all of the methods above?
Mark out of 5:5
Comments: all methods called when necessary
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:3
Comments: error message comes up if space is occupied or invalid
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:3
Comments: asks for the new piece every time.
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3: 3
Comments: Says who won and if board is full and no winner then it asks to reset the game.

   8. Overall
Is my code indented correctly?
Mark out of 3: 3
Comments: used auto indent
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments: variable names and constant are self explanitory 
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments: tried to follow the coding standard as much as possible
      Total Mark out of 100 (Add all the previous marks): 
*/

import java.util.Arrays;
import java.util.Scanner;

public class NoughtsAndCrosses {
	public static final char BLANK_CHAR = ' ';
	public static final char NOUGHT = 'O';
	public static final char CROSS = 'X';
	public static final int NUMBER_OF_ROWS_AND_COLUMNS = 3;

	public static void clearBoard(char[][] board) {
		for (char[] row : board)
			Arrays.fill(row, BLANK_CHAR);
	}

	public static void printBoard(char[][] board) {
		int row = 0;
		int oldRowNumber = 0;
		for (int count = 0; count < board[0].length; count++) {
			if (row < board.length) {
				if (row == oldRowNumber) {
					System.out.print("|" + board[row][count] + "|");
				} else {
					System.out.print("\n|" + board[row][count] + "|");
					oldRowNumber = row;
				}
				if (count == 2) {
					row++;
					count = -1;
				}
			}
		}
	}

	public static boolean canMakeMove(char[][] board, int row, int column) {
		if (board[row][column] == BLANK_CHAR) {
			return true;
		} else {
			return false;
		}
	}

	public static void makeMove(char[][] board, char playerPiece, int row, int column) {
		board[row][column] = playerPiece;
	}

	public static boolean isBoardFull(char[][] board) {
		int row = 0;
		for (int count = 0; count < board.length; count++) {
			if (row < board.length) {
				if (board[row][count] == ' ') {
					return false;
				}
				if (count == 2) {
					row++;
					count = -1;
				}
			}
		}
		return true;
	}

	public static char winnner(char[][] board) {
		// horizontal check//
		int row = 0;
		int column = 0;
		char firstChar = board[row][0];
		for (int count = 0; count < board.length; count++) {
			if (row < board.length) {
				firstChar = board[row][0];
				if (firstChar == board[row][column]) {
					if (firstChar == board[row][column + 1]) {
						if (firstChar == board[row][column + 2]) {
							return firstChar;
						}
					}
				}
				if (count == 2) {
					row++;
					count = -1;
				}
			}
		}
		// vertical check//
		row = 0;
		firstChar = board[0][column];
		for (int count = 0; count < board.length; count++) {
			if (column < board.length) {
				firstChar = board[0][column];
				if (firstChar == board[row][column]) {
					if (firstChar == board[row + 1][column]) {
						if (firstChar == board[row + 2][column]) {
							return firstChar;
						}
					}
				}
				if (count == 2) {
					column++;
					count = -1;
				}
			}
		}
		/// diagonal check///
		firstChar = board[0][0];
		int counter = 0;
		for (int count = 0; count < board.length; count++) {
			if (firstChar == board[count][count]) {
				firstChar = board[count][count];
				counter++;
			}
			if (counter == 3) {
				return firstChar;
			}
		}
		// other diagonal check//
		firstChar = board[0][2];

		if (firstChar == board[1][1]) {
			if (firstChar == board[2][0]) {
				return firstChar;

			}
		}
		return BLANK_CHAR;
	}

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		boolean finished = false;
		char playerPiece = BLANK_CHAR;
		char[][] board = new char[NUMBER_OF_ROWS_AND_COLUMNS][NUMBER_OF_ROWS_AND_COLUMNS];
		clearBoard(board);
		while (!finished) {
			System.out.println("Noughts or cross? enter either 'noughts' or 'cross' or 'exit' to exit: ");
			String input = inputScanner.next();
			if ((input.equals("noughts")) || (input.equals("cross"))) {
				if (input.equals("noughts")) {
					playerPiece = NOUGHT;
				} else if (input.equals("cross")) {
					playerPiece = CROSS;
				}
				System.out.println(
						"Please choose the position to place your piece in the format row then column seperated by a space: ");
				if (inputScanner.hasNextInt()) {
					int row = inputScanner.nextInt();
					int column = inputScanner.nextInt();
					if (row < board.length && column < board.length) {
						if (canMakeMove(board, row, column)) {
							makeMove(board, playerPiece, row, column);
							printBoard(board);
							char winningChar = winnner(board);
							if (winningChar != BLANK_CHAR) {
								System.out.println("\n" + winningChar + " Has won");
							}
						} else if (isBoardFull(board)) {
							System.out.println("The Board is full. Clear and restart? enter 'yes' or 'no': ");
							if (inputScanner.hasNext("yes")) {
								clearBoard(board);
							}
						} else if (!canMakeMove(board, row, column)) {
							System.out.println("This space is occupied. Try another space");
						}
					}
				}
			} else if (inputScanner.hasNext("exit")) {
				finished = true;
			} else {
				System.out.println("You have entered an invalid input pleasee try again");
			}
		}
	}
}
