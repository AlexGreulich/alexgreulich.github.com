import java.applet.*;
import java.awt.*;

public class Player{
	int lives;
	int energy;
	
	public int x_pos;
	public int y_pos;
	public int x_speed;
	public int betragX;
	public int betragY;
	
	public Image avatar;
	private Component parent;
	
	public Player(Image avatar,int x_pos, int y_pos, Component parent){
		
		this.avatar=avatar;
		this.parent=parent;
		this.x_pos= x_pos;
		this.y_pos= y_pos;
		int x_speed=0;
		int lives= 5;
		int energy= 100;
		
		
	}
	
	public void init(){}
	
	public void paintPlayer(Graphics g){
		g.drawImage(avatar, x_pos, y_pos,parent);
	}
	
	public void scrollPlayer(int speed){
		x_pos += speed;
	
	
	
	}
	public void movePlayer(int betragX,int betragY){
		/*if (betragX >0){
			avatar = getImage(getCodeBase(), "zweiter_rechts.gif");
		}
		else if (betragX<0){
			avatar = getImage(getCodeBase(), "zweiter_links.gif");
		}
		else {
			avatar = getImage(getCodeBase(), "still_right.gif");
		}*/
		x_pos += betragX;
		y_pos += betragY;
	}
	public int getX(){
		return x_pos;
	}
	
	public int getY(){
		return y_pos;
	}

}