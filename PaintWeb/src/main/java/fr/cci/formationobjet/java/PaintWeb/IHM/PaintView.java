package fr.cci.formationobjet.java.PaintWeb.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import fr.cci.formationobjet.java.PaintWeb.model.shapes.SCircle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SPixel;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SRectangle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SShape;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SSquare;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.STampon;


public class PaintView extends JPanel{

	private SShape model = new SSquare(new Point(10, 20),200);
	
	public PaintView() {
		this.setPreferredSize(new Dimension(500, 300));
		
		
		STampon t = new STampon();
		t.add(new SRectangle());
		t.add(new SRectangle(new Point(10, 10),100, 200));
		t.add(new SCircle(new Point(100, 100), 200));
		t.add(new SPixel(100,100));
		t.add(new SPixel(110,110));
		t.add(new SPixel(115,105));
		
		model = t;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		g.setColor(Color.BLUE); 
		g.drawRect(10, 10, 100, 200);
		
	
		//*/
		/*
		Rectangle r = model.getBounds();
		switch (model.getClass().getSimpleName()) {
		
		case "SRectangle":
		case "SPixel":
		case "SSquare" :
			g.drawRect(r.x, r.y, r.width, r.height);
			break;
		case "SCircle" :
			g.drawOval(r.x, r.y, r.width, r.height);
			break;
		}
		//*/
		
		model.drawMyseld(g);
		
	}
	
}
