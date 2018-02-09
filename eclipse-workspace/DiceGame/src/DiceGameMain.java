import java.util.Scanner;

public class DiceGameMain {
	public static final int CHANCES_FOR_TRIPLE = 30;
	public static final int CHANCES_FOR_FIELD = 1;
	public static final int BOTTOM_RANGE_FOR_FIELD = 8;
	public static final int TOP_RANGE_FOR_FIELD = 12;
	public static final int MIN_VALUE_FOR_HIGH = 10;
	public static final int MAX_VALUE_FOR_LOW = 11;
	public static void ResolveBet(String betType, wallet Wallet) {
		double walletAmount = Wallet.check();
		double betAmount = 0;
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("You have " + walletAmount + " in you wallet. How much would you like to bet?: ");
		if (inputScanner.hasNextDouble()) {
			betAmount = inputScanner.nextDouble();
			if (!Wallet.get(betAmount)) {
				System.out.println("You have bet more than you have, place a lower bet.");
			} else {
				Dice dice1 = new Dice();
				Dice dice2 = new Dice();
				Dice dice3 = new Dice();
				int firstDiceFace = dice1.roll();
				int secondDiceFace = dice2.roll();
				int thirdDiceFace = dice3.roll();
				int total = firstDiceFace + secondDiceFace + thirdDiceFace;
				if (betType.equals("Triple") && firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace
						&& (firstDiceFace != 1 || firstDiceFace != 6)) {
					double amountWon = betAmount * CHANCES_FOR_TRIPLE;
					Wallet.put(amountWon + betAmount);
					System.out.println("You have won "+amountWon);
				} else if (betType.equals("Field") && 
						(total < BOTTOM_RANGE_FOR_FIELD || total > TOP_RANGE_FOR_FIELD)) {
					double amountWon = betAmount*CHANCES_FOR_FIELD;
					Wallet.put(amountWon+betAmount);
					System.out.println("You have won "+amountWon);
				}
				else if(betType.equals("High")&& total>MIN_VALUE_FOR_HIGH) {
					if((firstDiceFace == 6)&&!(firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace)) {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
					else if((firstDiceFace == 5)&&!(firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace)) {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
					else if((firstDiceFace == 5)&&!(firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace)) {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
					else {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
				}
				else if(betType.equals("Low")&& total>MAX_VALUE_FOR_LOW) {
					if((firstDiceFace == 1)&&!(firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace)) {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
					else if((firstDiceFace == 2)&&!(firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace)) {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
					else if((firstDiceFace == 3)&&!(firstDiceFace == secondDiceFace && secondDiceFace == thirdDiceFace)) {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
					else {
						double amountWon = betAmount*CHANCES_FOR_FIELD;
						Wallet.put(amountWon+betAmount);
						System.out.println("You have won "+amountWon);
					}
				}
				else {
					System.out.println("You lost your bet. Try again. You have lost " +betAmount);
				}
			}
		}

	}

	public static void main(String[] args) {
		boolean finished = false;
		wallet PlayerWallet = new wallet();
		Scanner inputScanner = new Scanner(System.in);
		double initialMoneyAmount = 0;
		System.out.println("How much money would you like to have in your wallet: ");
		if (inputScanner.hasNextInt()) {
			initialMoneyAmount = inputScanner.nextDouble();
		}
		while(!finished) {
			
		}
	}

}
