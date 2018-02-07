
public class Ball {
	Pong display;
	float x;
	float y;
	float dx;
	float dy;
	int radius;
	int ballColor;
	

	Ball(Pong display) {
		this.display = display;
		x = display.random(Pong.SCREENX / 4, Pong.SCREENX / 2);
		y = display.random(Pong.SCREENY / 4, Pong.SCREENY / 2);
		dx = display.random(1, 2);
		dy = display.random(1, 2);
		radius = 5;
		ballColor = display.color(45, 123, 89);
	}


	public void move() {
		x = x + dx;
		y = y + dy;
	}

	public boolean outOfBounds() {
		if (y > Pong.SCREENY||y<0) {
			return true;
		}
		else {
			return false;
		}
	}

	public void draw(){
	   display.fill(ballColor);
	   display.ellipse(x, y, radius, radius);
	  }

	public void computerCollide(Player tp) {
		if (y + radius >= tp.compYpos && y - radius < tp.compYpos + Pong.PADDLEHEIGHT && x >= tp.compXpos
				&& x <= tp.compXpos + Pong.PADDLEWIDTH) {
			System.out.println("collided!");
			dy = -dy;
		}
	}

	public void wallCollide(Player tp) {
		if (x - radius <= 0)
			dx = -dx;
		else if (x + radius >= Pong.SCREENX)
			dx = -dx;
		if (y + radius >= tp.ypos && y - radius < tp.ypos + Pong.PADDLEHEIGHT && x >= tp.xpos
				&& x <= tp.xpos + Pong.PADDLEWIDTH) {
			System.out.println("collided!");
			dy = -dy;
		}
	}
}


