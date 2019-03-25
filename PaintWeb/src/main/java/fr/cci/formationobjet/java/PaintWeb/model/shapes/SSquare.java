package fr.cci.formationobjet.java.PaintWeb.model.shapes;

import java.awt.Point;

import javax.persistence.Entity;

@Entity
public class SSquare extends SRectangle {

	public SSquare() {
		this.origin = new SPixel(0,0);
		this.width = 1;
		this.height= this.width;
	}
	
	public SSquare(Point p, int l) {
		origin = new SPixel(p.x, p.y);
		this.width = l;
		this.height = l;
	}
	
	
	public SSquare(Point p, Point p2) throws Exception {
		origin.setLoc(p);
		int width = p2.x - p.x;
		int height = p2.y - p.y;
		if(width != height)
			throw new Exception("The two points does not form a square : width="+width +" height="+height);
		if(p.x <0 || p.y <0 || p2.x <0 || p2.y <0)
			throw new Exception("point négatif");
		this.width = width;
		this.height = height;
		

	}
	

	@Override
	public String toString() {
		int x = this.getLoc().x;
		int y = this.getLoc().y;
		StringBuffer sb = new StringBuffer();
		sb.append("Square : ")
		 .append("location=").append(x).append("|").append(y)
		 .append(" ; width=").append(this.width)
		 .append(" ; ").append("isSelected=").append(this.isSelected());
		return sb.toString();
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
