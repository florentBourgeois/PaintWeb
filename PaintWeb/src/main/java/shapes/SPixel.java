package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SPixel extends SShape{
	private int x=0, y=0;
	
	
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
	
	public SPixel(Point p) {
		this(new SPixel(p.x, p.y));
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
	public Rectangle getBounds() {
		return new Rectangle(x, y, 1, 1);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Pixel : ")
			.append(this.x).append("|").append(this.y)
			.append(" ; ").append(super.toString());
		
		return sb.toString();
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
