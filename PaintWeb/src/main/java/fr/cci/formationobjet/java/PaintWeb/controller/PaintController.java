package fr.cci.formationobjet.java.PaintWeb.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import fr.cci.formationobjet.java.PaintWeb.IHM.PaintView;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SSquare;

public class PaintController implements MouseMotionListener{

	private PaintView view;
	
	public void setView(PaintView paintview) {
		this.view = paintview;
		
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("La sourie a bougé en " + e.getPoint());
		this.view.setModel(new SSquare(e.getPoint(), 20));
		this.view.updateUI();
	}

	
	

}
