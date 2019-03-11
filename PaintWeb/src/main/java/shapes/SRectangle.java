package shapes;

import java.awt.Point;

public class SRectangle extends SShape{

	protected SPixel origin = new SPixel(); 
	protected int l=5;
	protected int h=10; 
	
	public SRectangle() {
	}
	
	public SRectangle(Point p, int l, int h) {
		origin = new SPixel(p.x, p.y);
		this.l = l;
		this.h = h;
	}
	
	public SRectangle(Point p, Point p2) {
		origin.setLoc(p);
		this.l = p2.x - p.x;
		this.h = p2.y - p.y;
	}

	@Override
	public void translate(int dx, int dy) {
		this.origin.translate(dx, dy);
	}
	
	@Override
	public void setLoc(Point p) {
		this.origin.setLoc(p);
	}
	
	@Override
	public Point getLoc() {
		return this.origin.getLoc();
	}
	
	@Override
	public String toString() {
		return "Rectangle " + super.toString();
	}

}
