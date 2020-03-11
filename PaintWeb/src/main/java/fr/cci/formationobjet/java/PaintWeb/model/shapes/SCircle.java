package fr.cci.formationobjet.java.PaintWeb.model.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class SCircle extends SShape {

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private SPixel origin = new SPixel(0,0);
	private int radius = 1;

	public SCircle(Point p, int r) {
		origin = new SPixel(p.x, p.y);
		radius = Math.abs(r);
	}

	public SCircle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Point getLoc() {
		return this.origin.getLoc();
	}

	@Override
	public void setLoc(Point p) {
		this.origin.setLoc(p);
	}

	@Override
	public void translate(int dx, int dy) {
		this.origin.translate(dx, dy);
	}

	public void print() {
		System.out.print(this);
	}
	
	@Override
	public String toString() {
		StringBuffer monStringBuffer = new StringBuffer();
		monStringBuffer.append("Circle : location=").append(origin.getLoc().x).append("|").append(origin.getLoc().y).append(" ;");
		monStringBuffer.append(" radius=").append(this.radius).append(" ;");
		monStringBuffer.append(" isSelected=").append(this.isSelected());
		return monStringBuffer.toString();
	}
	
	

	@Override
	public Rectangle getBounds() {
		int l = this.radius *2;
		int x = this.origin.getLoc().x - radius;
		int y = this.origin.getLoc().y - radius;
		Rectangle r = new Rectangle(x, y, l, l);
		return r;
	}
	
	
	@Override
	public void drawMyseld(Graphics g) {
		Rectangle r = this.getBounds();
		g.drawOval(r.x, r.y, r.width, r.height);
		
	}
	
	
	//getters and setters for jpa
	public SPixel getOrigin() {
		return origin;
	}
	public void setOrigin(SPixel origin) {
		this.origin = origin;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	
	
	
	public static void main(String[] args) {
		SCircle c = new SCircle();
		System.out.println(c);
		
		SCircle c2 = new SCircle(new Point(10, 100), 40);
		System.out.println(c);
		c2.translate(50, 100);
		c2.setLoc(new Point(30, 10));
		c2.select();
		c2.print();
		
	}	

}
