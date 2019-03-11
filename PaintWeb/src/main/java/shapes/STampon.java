package shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class STampon extends SShape{

	ArrayList<SShape> formes = new ArrayList<SShape>();
	
	
	public STampon() {
		formes.add(new SPixel());
		formes.add(new SSquare());
		formes.add(new SCircle());

	}
	
	public void add(SShape s) {
		formes.add(s);
	}
	
	public void remove(int x) {
		formes.remove(x);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Tampon : \n");
		/*for(int i = 0; i<formes.size(); i++) {
			SShape s = formes.get(i);
			sb.append(s).append("\n");
		}
		Iterator<SShape> it = formes.iterator();
		while(it.hasNext()) {
			SShape s = it.next();
			sb.append(s).append("\n");
		}*/
		for (SShape s : formes) {
			sb.append(s).append("\n");
		}
		return sb.toString();
	}
	
	
	@Override
	public Point getLoc() {
		int x = 99999;
		int y = 99999;
		for (SShape s : formes) {
			if(s.getLoc().x < x)
				x = s.getLoc().x;
			if(s.getLoc().y < y)
				y = s.getLoc().y;
		}
		return new Point(x, y);
	}

	@Override
	public void setLoc(Point p) {
		int dx = p.x - this.getLoc().x;
		int dy = p.y - this.getLoc().y;		
		
		translate(dx, dy);
	}

	@Override
	public void translate(int dx, int dy) {
		for (SShape sShape : formes) {
			sShape.translate(dx, dy);
		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static void main(String[] args) {
		STampon list = new STampon();
		
		list.add(new SRectangle());
		System.out.println(list);
		
		
		STampon t2 = new STampon();
		t2.add(new SRectangle());
		t2.add(new SRectangle());
		t2.add(new SRectangle());
		t2.add(new SRectangle());
		t2.add(new SRectangle());
		t2.add(new SRectangle());
		t2.add(list);
		System.out.println(t2);
	}

	
	
}
