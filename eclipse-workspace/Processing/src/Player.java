
public class Player {
	Pong display;
	int xpos; int ypos;
	  float compXpos; float compYpos;
	  int paddlecolor = 50;
	  
	  Player(Pong display,int screen_y){
		  this.display = display;
	    xpos=Pong.SCREENX/2;
	    ypos = screen_y;
	  }
	  
	  public void Computer(int screen_y){
	    compXpos = Pong.SCREENX;
	    compYpos = screen_y;
	  }
	  public void moveComputer(float x){
	    if( x>compXpos){
	      compXpos = x;
	    }
	    else if(x<compXpos){
	      compXpos = x;
	    }
	  }
	  public void move(int x){
	    if(x>Pong.SCREENX-Pong.PADDLEWIDTH) xpos = Pong.SCREENX-Pong.PADDLEWIDTH;
	    else xpos = x;
	  }
	  
	  public void draw()
	  {
	    display.fill(paddlecolor);
	    display.rect(xpos,ypos,Pong.PADDLEWIDTH,Pong.PADDLEHEIGHT);
	    display.rect(compXpos,compYpos,Pong.PADDLEWIDTH,Pong.PADDLEHEIGHT);
	  }
	}
	    


