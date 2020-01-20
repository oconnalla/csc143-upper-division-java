package abs.shape;

import java.awt.Graphics;
import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	
	public static final long serialVersionUID = 2L;
	private Shape _shape_01;
	private Shape _shape_02;
	
	public ControlPanel() {
		_shape_01 = new Circle(100, 100, 25);
		_shape_02 = new Rectangle(200, 200, 200, 100);
	}

	//****************************************************
	//*	Draws the current circle, if any
	//****************************************************
	public void paintComponent(Graphics _graphics) {
		super.paintComponent(_graphics);
		if(_shape_01 != null || _shape_02 != null) {
			_shape_01.draw(_graphics);
			_shape_02.draw(_graphics);
		}
		
	}
}
