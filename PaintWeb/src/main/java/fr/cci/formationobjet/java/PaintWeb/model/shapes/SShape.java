package fr.cci.formationobjet.java.PaintWeb.model.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import fr.cci.formationobjet.java.PaintWeb.model.utilities.Drawable;
import fr.cci.formationobjet.java.PaintWeb.model.utilities.Printable;

@JsonTypeInfo(use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS,
				include = JsonTypeInfo.As.PROPERTY,
				property = "type")
@JsonSubTypes({
	@Type(value = SPixel.class),
	@Type(value = SRectangle.class),
	@Type(value = SCircle.class),
	@Type(value = SSquare.class),
	@Type(value = STampon.class),
})
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SShape implements Printable, Drawable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable=false, nullable=false)
    protected Long id;

	@Column(nullable=false)
	private boolean isSelected=false;

	//METHODES
	@Transient
	public abstract Point getLoc() ;
	@Transient
	public abstract void setLoc(Point p);
	@Transient
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
	
	@Transient
	public abstract Rectangle getBounds();
	
	public void print() {
		System.out.print(this);
		
	}
	
	
	
	/*
	 * constructor, getters and setters for jpa
	 */
    public SShape() {
    	
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	@Override
	public String toString() {
		return "isSelected="+this.isSelected;
	}

}

