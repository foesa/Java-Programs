import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {

	public C4HumanPlayer(int piece) {
		super(piece);
		// TODO Auto-generated constructor stub
	}

	@Override
	void makeMove(Connect4Grid2DArray game) {
		System.out.println("Please enter the column you'd like to place a piece: ");
		Scanner playerScanner = new Scanner(System.in);
		int column = playerScanner.nextInt();
		if(isMoveValid(column, game)) {
			game.dropPiece(this, column);
		}
	}

}
