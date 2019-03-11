package shapes;

import java.awt.Point;

public class SSquare extends SRectangle {

	public SSquare() {
		this.origin = new SPixel();
		this.l = 10;
		this.h=10;
	}
	
	public SSquare(Point p, int l) {
		origin = new SPixel(p.x, p.y);
		this.l = l;
		this.h = l;
	}
	
	
	public SSquare(Point p, Point p2) throws Exception {
		origin.setLoc(p);
		int l = p2.x - p.x;
		int h = p2.y - p.y;
		if(l != h)
			throw new Exception("erreur longuer != largeur");
		if(p.x <0 || p.y <0 || p2.x <0 || p2.y <0)
			throw new Exception("point négatif");
		this.l = l;
		this.h = l;
		

	}
	
	@Override
	public String toString() {
		
		return "Carre";
	}
	
	public static void main(String[] args) {
		SSquare s = new SSquare();
		s.print();
		
		s.translate(50, 50);
		System.out.println();
		
		try {
			SSquare s2 = new SSquare(new Point(1,1), new Point(30,30));
		
		s.print();
		System.out.println();
		
		SSquare s3 = new SSquare(new Point(1,1), new Point(2,30));
		s.print();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		try {
			SSquare s4 = new SSquare(new Point(-10, -10), new Point(10, 10));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		s.print();
		System.out.println();
		s.print();
		
	}

}
