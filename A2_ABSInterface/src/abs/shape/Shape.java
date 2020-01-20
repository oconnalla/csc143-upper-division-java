package abs.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape{
	
	protected 	int 	centerX, centerY;
	protected 	Color 	color;
	private 	int 	x;		// top left x
	private 	int 	y;		// top left y
	
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw(Graphics pencil);
	
	public Point getCenter() {
		return new Point(centerX, centerY);
	}
	
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

}
