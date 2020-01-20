package mouse.listener;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ControlPanel extends JPanel {
	
	private static final long serialVersionUID = 5L;
	
	//****************************************************
	//*	Sets up this Panel and Listener for mouse events.
	//* Panel listens for mouse events
	//****************************************************
	public ControlPanel() {
		//add Mouse Motion Listener this panel
	}
	
	//****************************************************
	//*	Create new circle at the location, whenever the
	//* mouse button is pressed/dragged and repaints.
	//****************************************************
	public void functionD(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		Graphics pen = getGraphics();
		pen.setColor(Color.BLACK);
		pen.drawOval(x, y, 50, 50);
		
	}
	
	//****************************************************
	//*	Create new circle at the location, whenever the
	//* mouse button is moved and repaints.
	//*****************************************************
	public void functionM(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
		
		Graphics pen = getGraphics();
		pen.setColor(Color.RED);
		pen.drawOval(x, y, 50, 50);
	}
	
}
