package shapes;

import java.awt.Point;
import java.awt.Rectangle;

import utilities.Printable;


public abstract class SShape implements Printable{
	//ATTRIBUTS
	private boolean isSelected=false;

	//METHODES
	public abstract Point getLoc() ;
	
	public abstract void setLoc(Point p);

	public abstract void translate(int dx, int dy);
	
	public void select() {
		this.isSelected = true;
	}
	
	public void unselect() {
		this.isSelected = false;
	}
	
	public void toggleSelect() {
		this.isSelected = ! this.isSelected;
	}
	
	public boolean isSelected(){
		return this.isSelected;
	}
	
	public abstract Rectangle getBounds();
	
	public void print() {
		System.out.print(this);
		
	}
	
	
	@Override
	public String toString() {
		return "isSelected="+this.isSelected;
	}

}

