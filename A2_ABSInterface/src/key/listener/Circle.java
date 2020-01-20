package key.listener;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circle {
	
	private int centerX, centerY;
	private int radius;
	private Color color;
	
	
	public Circle(Point p) {
		radius 	= 25;
		color 	= new Color(175, 0, 0);
		centerX = p.x;
		centerY = p.y;
	}

	public void draw(Graphics pen) {
		int x = centerX - radius;
		int y = centerY - radius;
		pen.setColor(color);
		pen.fillOval( x,  y, 2 * radius, 2 * radius);
	}
	
	public void move(Point p) {
		 centerX += p.x;
		 centerY += p.y;
	}
	
	public Point getCenter() {
		return new Point(centerX, centerY);
	}
	
}
