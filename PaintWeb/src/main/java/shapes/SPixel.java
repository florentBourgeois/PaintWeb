package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SPixel extends SShape{
	private int x=1, y=1;
	
	
	public SPixel() {
	}
	
	public SPixel(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public SPixel(SPixel pix) {
		this.x = pix.x;
		this.y = pix.y;
	}
	
	@Override
	public Point getLoc() {
		return new Point(this.x, this.y);
	}
	
	@Override
	public void setLoc(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	@Override
	public void translate(int dx, int dy) {
		this.x = this.x +dx;
		this.y = this.y +dy;
	}
	
	

	@Override
	public String toString() {
		return "Pixel";
	}

	
	
	public static void main(String[] args) {
		SPixel p = new SPixel();
		SPixel p2 = new SPixel(100, 500);
		SPixel p3 = new SPixel(p2);
		
		System.out.println(p.getLoc());
		System.out.println(p2.getLoc());
		System.out.println(p3.getLoc());
		
		System.out.println();
		System.out.println(p.getLoc());
		p.translate(5, 6);
		System.out.println(p.getLoc());

		System.out.println();
		System.out.println(p.isSelected());
		p.select();
		System.out.println(p.isSelected());
		p.unselect();
		System.out.println(p.isSelected());
		p.toggleSelect();
		System.out.println(p.isSelected());
	}


	
	
}
