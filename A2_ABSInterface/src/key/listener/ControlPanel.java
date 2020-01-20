package key.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;


public class ControlPanel extends JPanel {
	
	private static final long serialVersionUID = 5L;
	private Circle circle;
	Point 	point;
	
	
	//****************************************************
	//*	Sets up this Panel and Listener for key events.
	//* Panel listens for key events
	//****************************************************
	public ControlPanel() {
		point 	= new Point(200,100);
		circle 	= new Circle(point);
		//add Key Listener this panel
		setFocusable(true);
	}
	
	//****************************************************
	//*	Draws the current circle, if any
	//****************************************************
	public void paintComponent(Graphics _graphics) {
		super.paintComponent(_graphics);
		if(circle != null) {
			circle.draw(_graphics);
		}
		
	}
	
	//****************************************************
	//*	Moves the circle whenever the
	//* key button is pressed and repaints.
	//****************************************************
	
	public void functionP(KeyEvent event){
	
		int keyPress = event.getKeyCode();
		
		if (keyPress == KeyEvent.VK_UP){
			up();
		}

		if (keyPress == KeyEvent.VK_DOWN){
			down();
		}

		if (keyPress == KeyEvent.VK_LEFT){
			left();
		}

		if (keyPress == KeyEvent.VK_RIGHT){
			right();
		}
		
		repaint();
	}
	
	public void up(){
		point.x = 0;
		point.y = -10;
		circle.move(point);
	}
	
	public void down(){
		point.x = 0;
		point.y = 10;
		circle.move(point);
	}

	public void left(){
		point.x = -10;
		point.y = 0;
		circle.move(point);
	}

	public void right(){
		point.x = 10;
		point.y = 0;
		circle.move(point);
	}
	
	//****************************************************
	//*	Provides empty definitions for the unused
	//* key methods of the Listener interface.
	//****************************************************
	public void funtionT(KeyEvent event){}	
	
	public void keyReleased(KeyEvent event){}	

}
