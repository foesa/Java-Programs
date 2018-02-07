import processing.core.PApplet;
import processing.core.PFont;

public class Pong extends PApplet {
	public static void main(String[] args) {
		PApplet.main("Pong");
	}

	Player thePlayer;
	Ball theBall;

	static final int SCREENX = 320;
	static final int SCREENY = 240;
	static final int PADDLEHEIGHT = 15;
	static final int PADDLEWIDTH = 50;
	static final int MARGIN = 10;
	int playerWins = 0;
	int computerWins = 0;
	int winsRequiredToWin = 3;

	public void settings() {
		size(SCREENX, SCREENY);
	}

	public void setup() {
		thePlayer = new Player(this,SCREENY - MARGIN - PADDLEHEIGHT);
		theBall = new Ball(this);
		ellipseMode(RADIUS);
	}
	

	public void draw() {
	background(0);
	theBall.move();
	thePlayer.moveComputer(theBall.x);
	thePlayer.move(mouseX);
	theBall.computerCollide(thePlayer);
	theBall.wallCollide(thePlayer);
	theBall.draw();
	thePlayer.draw();
	if(playerWins==winsRequiredToWin) {
		size(600, 600);
		
		textFont(myFont);
		text(“All your base are belong to us!”, 20, 20);
	}
	if(theBall.outOfBounds()) {
		reset(theBall);
	}
	}
	public void reset(Ball theBall) {
		if(theBall.y<0) {
			playerWins++;
		}
		else {
			computerWins++;
		}
		if(mousePressed) {
			theBall.x = SCREENX/2;
			theBall.y = SCREENY/2;
		}
	}
	}


