package fr.cci.formationobjet.java.PaintWeb.IHM;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import fr.cci.formationobjet.java.PaintWeb.controller.PaintController;




public class PaintApp extends JFrame{
	
	public PaintApp() {
		super("Mon paint");
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});
		
		PaintView paintview = new PaintView();
		this.getContentPane().add(paintview, BorderLayout.CENTER);
		
		PaintController controller = new PaintController();
		paintview.addMouseMotionListener(controller);
		paintview.addMouseListener(controller);
		controller.setView(paintview);
	}
	
	
	
	public static void main(String[] args) {
		PaintApp p = new PaintApp();
		p.setVisible(true);
		p.pack();

	}
}
