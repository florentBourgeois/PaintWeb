package fr.cci.formationobjet.java.PaintWeb.model.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;



@Entity
public class STampon extends SShape{

	@ElementCollection
	List<SShape> shapes;
	
	
	public STampon() {
		this.shapes = new ArrayList<SShape>();
	}
	
	public void add(SShape s) {
		shapes.add(s);
	}
	
	public void remove(int x) {
		shapes.remove(x);
	}
	
	
	@Override
	public Point getLoc() {
		if (this.shapes.size()==0) {
			return new Point(0,0);
		}
		int x = 99999;
		int y = 99999;
		for (SShape s : shapes) {
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
		for (SShape sShape : shapes) {
			sShape.translate(dx, dy);
		}
	}

	@Override
	public Rectangle getBounds() {
		Point loc = this.getLoc();
		Point end = new Point(0, 0);
		for (SShape s : shapes) {
			Rectangle r = s.getBounds();
			if (r.getMaxX() > end.getX()) {
				end.x = (int) r.getMaxX();
			}
			if (r.getMaxY() > end.getY()) {
				end.y = (int) r.getMaxY();
			}
		}
		int w = end.x - loc.x;
		int h = end.y - loc.y;
		return new Rectangle(loc.x, loc.y, w, h);
	}
	
	
	@Override
	public void drawMyseld(Graphics g) {
		for (SShape s : shapes) {
			s.drawMyseld(g);
		}
	}
	
	
	//getters and setters for jpa
	public List<SShape> getShapes() {
		return shapes;
	}

	public void setShapes(List<SShape> shapes) {
		this.shapes = shapes;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Tampon : ").append(super.toString());
		/*for(int i = 0; i<formes.size(); i++) {
			SShape s = formes.get(i);
			sb.append(s).append("\n");
		}
		Iterator<SShape> it = formes.iterator();
		while(it.hasNext()) {
			SShape s = it.next();
			sb.append(s).append("\n");
		}*/
		for (SShape s : shapes) {
			sb.append("\n\t").append(s);
		}
		return sb.toString();
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
