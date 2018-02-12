/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: ResolveBet calls uses a wallet and a string as parameters and returns nothing as everything is accessed within and changed in the function.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: Calls the check method in the wallet class and returns the amount in their wallet as an int and prints out and also asks for how much they'd like to bet
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: Program does this by checking the boolean returned when get() is called and seeing if it's true or false
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15 ]..
Comment: Dice 1,2 and 3 are all made in the method using the dice class and rolled by calling the function in the dice class. the total is then added up and stored in a variable.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:20 ].
Comment: amount won is determined by the bet type and computed within the bet check. used constants as the multipliers. checks by comparing the first 2 dice and if they are the same then the last 2 dice
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].
Comment: print statement is used to print how much has been won/lost then that amount is added or subtracted from the wallet.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: amount of cash to be put in is asked first then the wallet object is created and that amount is placed in the wallet
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment:when the amount in the wallet reaches 0 an error message is displayed after the bet has been placed.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: if exit is entered the loop breaks or the game continues if some string has been entered
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: if there is some sort of input resolveBet gets called and then it checks for the bet type etc
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5 ]
Comment: if the game is ended and there's still money in the wallet it says how much has been made or lost.

 Total Mark out of 100 (Add all the previous marks):100
*/
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
				else if(betType.equals("Low")&& total<MAX_VALUE_FOR_LOW) {
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
			PlayerWallet.put(initialMoneyAmount);
		}
		while(!finished) {
			System.out.println("What bet type would you like to place? Please enter either 'High', 'Low', 'Triple' or 'Field' or type 'exit': ");
			
			if (inputScanner.hasNext("exit")){
				double difference = PlayerWallet.check()-initialMoneyAmount;
				System.out.println("You now have " + PlayerWallet.check()+"in you wallet. You have made " + difference + " You started with "+initialMoneyAmount);
				finished = true;
			}
			else if(PlayerWallet.check()==0){
				System.out.println("You have no more money in your wallet. You have Lost");
				System.out.println("You now have " + PlayerWallet.check()+"in you wallet. You have lost " + initialMoneyAmount );
				finished = true;
			}
			else {
				String betmade = inputScanner.next();
				ResolveBet(betmade, PlayerWallet);
			}
		}
	}
}
