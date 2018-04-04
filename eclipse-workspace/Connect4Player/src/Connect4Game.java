/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:Game starts by asking how many players wish to play. Runs in a while loop switching turns and checking after each turn if a winner has been found. Before game starts players and board are initialised.

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment:All methods are defined with no body

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment:A 2D array is made that stores the pieces. Drops piece by placing in last row then building up. Method to check for winner is implemented also

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:Abstract method makeMove and non-abstract method getPiece and isMoveValid are implemented here

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:Asks for where to place the piece and then does so, first checking if the move is valid

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment:Ai player builds across or up depending on where the player places their piece.

Total Marks out of 100:100

*/


import java.util.Scanner;

public class Connect4Game {
	public static void main(String[] args) {
		int playerNumber = 0;
		int player1piece;
		int player2piece;
		C4HumanPlayer player1;
		C4HumanPlayer player2 = null;
		C4AiPlayer aiplayer = null;
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("How many players human player(1 or 2): ");
		playerNumber = inputScanner.nextInt();
		System.out.println("Enter the numbers you wish to represent your pieces: ");
		if (playerNumber == 2) {
			player1piece = inputScanner.nextInt();
			player1 = new C4HumanPlayer(player1piece);
			player2piece = inputScanner.nextInt();
			player2 = new C4HumanPlayer(player2piece);
		} else {
			player1piece = inputScanner.nextInt();
			player1 = new C4HumanPlayer(player1piece);
			aiplayer = new C4AiPlayer(player1piece + 1);
		}
		Connect4Grid2DArray mainGrid = new Connect4Grid2DArray();
		mainGrid.emptyGrid();
		boolean winnerfound = false;
		boolean playerTurn = true;
		while (!winnerfound) {
			if (playerTurn) {
				System.out.println(mainGrid.toString());
				player1.makeMove(mainGrid);
				playerTurn = false;
			} else {
				System.out.println(mainGrid.toString());
				System.out.println("Opponent Turn \n ");
				if (playerNumber == 2) {
					player2.makeMove(mainGrid);
					playerTurn = true;
				} else {
					aiplayer.makeMove(mainGrid);
					playerTurn = true;
				}
			}
			if (mainGrid.didLastPieceConnect4()) {
				if (mainGrid.winnerPiece() == player1.getPlayerPiece()) {
					System.out.println("The player has won, gg");
					winnerfound = true;
				} else {
					System.out.println("The computer/player 2 has won, git gud");
					winnerfound = true;
				}
			}
		}
	}
}
