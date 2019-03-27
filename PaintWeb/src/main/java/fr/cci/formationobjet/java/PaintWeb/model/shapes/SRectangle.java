package fr.cci.formationobjet.java.PaintWeb.model.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class SRectangle extends SShape{

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	protected SPixel origin = new SPixel(1,1); 
	protected int width=2;
	protected int height=4; 
	
	public SRectangle() {
	}
	
	public SRectangle(Point p, int l, int h) {
		origin = new SPixel(p.x, p.y);
		this.width = l;
		this.height = h;
	}
	
	public SRectangle(Point p, Point p2) {
		origin.setLoc(p);
		this.width = p2.x - p.x;
		this.height = p2.y - p.y;
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
	public Rectangle getBounds() {
		return new Rectangle(origin.getLoc().x, origin.getLoc().y, this.width, this.height);
	}
	
	@Override
	public void drawMyseld(Graphics g) {
		Rectangle r = this.getBounds();
		g.drawRect(r.x, r.y, r.width, r.height);
		
	}
	
	
	
	
	//getters and setters for jpa
	public SPixel getOrigin() {
		return origin;
	}
	public void setOrigin(SPixel origin) {
		this.origin = origin;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}	
	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		int x = this.getLoc().x;
		int y = this.getLoc().y;
		StringBuffer sb = new StringBuffer();
		sb.append("Rectangle : ")
		 .append("startPoint=").append(x).append("|").append(y)
		 .append(" ; endPoint=").append(x+this.width).append("|").append(y+this.height)
		 .append(" ; ").append(super.toString());
		return sb.toString();
	}

}
