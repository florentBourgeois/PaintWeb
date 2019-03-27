package fr.cci.formationobjet.java.PaintWeb.IHM;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


public class PaintView extends JPanel{

	
	
	public PaintView() {
		this.setPreferredSize(new Dimension(500, 300));
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.drawRect(10, 10, 100, 200);
		
		
	}
	
}
