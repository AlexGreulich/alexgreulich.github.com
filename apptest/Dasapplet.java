import java.applet.*;
import java.awt.*;
import java.lang.*;
import java.net.*;			
import java.awt.event.*;
//import javax.swing.*;
public class Dasapplet extends Applet implements Runnable, KeyListener{		

	private Image dbImage;
	private Graphics dbg;
	//private int game_position;

	private Player spieler;
	int speed;
	//int linkerRand;
	//int rechterRand;
	int scrollSpeed;
	int radius=50;
	int x_pos=100;
	int y_pos=100;
	int x_speed=0;
	int y_speed=0;


	Image backImage;


	public void init(){

		addKeyListener(this);
		spieler = new Player(getImage(getCodeBase(), "still_right.gif"),200,500, this);

	//	game_position =200;
	//	linkerRand = -200;
	//	rechterRand = 400;
		
		speed=50;
		backImage= getImage(getCodeBase(),"bckgrd.gif");
		
	}
	public void start(){
		Thread th = new Thread(this);
		th.start();
	}
	
	public void stop(){
	
	}
	public void keyPressed(KeyEvent e){
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			//x_speed-=5;
			
			spieler.movePlayer(-5,0);
		 }
		 else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			//x_speed+=5;	
			spieler.movePlayer(5,0);
		
		 
		 }
		 else if (e.getKeyCode() == KeyEvent.VK_UP) {
			y_speed-=20;
		 }					
		
		
		
	}
	public void keyReleased(KeyEvent e){
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			x_speed=0;
		 
		 }
		 else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			x_speed=0;
		 
		 }
		 else if (e.getKeyCode() == KeyEvent.VK_UP) {
			y_speed+=4;
		 }
		
		
	}

	public void keyTyped(KeyEvent e)
	{

	}
	public void destroy(){
	
	}
	
	public void update(Graphics g){
		
		if (dbImage==null){
			dbImage= createImage(this.getSize().width,this.getSize().height);
			dbg=dbImage.getGraphics();
		
		}
		dbg.setColor(getBackground());
		dbg.fillRect(0,0,this.getSize().width,this.getSize().height);
		
		dbg.setColor(getForeground());
		paint(dbg);
		
		g.drawImage(dbImage,0,0,this);
		
	}
	
	public void createImage(){
	
	}
	
	public void run(){
		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		
		while (true){
			
			
			//x_pos += x_speed;
			
			spieler.movePlayer(x_speed,y_speed);
			
			repaint();
			try{
				Thread.sleep (speed);	//Stoppen des threads für 20 millisec
			}
		
			catch(InterruptedException ex){
				
			}
			
			Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
			
		}
		
	}
	
	public void paint (Graphics g){
		g.drawImage (backImage, 0, 0, this); 
		
		g.setColor (Color.yellow);
		g.fillOval (x_pos - radius, y_pos - radius,2*radius,2*radius);
						
		spieler.movePlayer(x_speed,y_speed);				
		spieler.paintPlayer(g);
	}
}