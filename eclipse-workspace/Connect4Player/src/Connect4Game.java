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
