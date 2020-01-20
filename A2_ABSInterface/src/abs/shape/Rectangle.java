package abs.shape;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private int height;
	private int width;
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		color 	= Color.RED;
		centerX = x - width / 2;
		centerY = y - height / 2;
	}
	
	public void draw(Graphics pencil) {
		pencil.setColor(color);
		pencil.fillRect(centerX, centerY, width, height);
	}
	
	public String toString() {
		return String.format("[%d, %d]", width, height);
	}
}
