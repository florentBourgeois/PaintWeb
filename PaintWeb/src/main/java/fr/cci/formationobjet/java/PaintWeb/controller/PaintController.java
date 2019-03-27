package fr.cci.formationobjet.java.PaintWeb.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.cci.formationobjet.java.PaintWeb.IHM.PaintView;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SSquare;

public class PaintController implements MouseMotionListener, MouseListener{

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

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("La sourie a été clickée en " + e.getPoint());
		this.view.setModel(new SSquare(e.getPoint(), 20));
		this.view.updateUI();		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	

}
