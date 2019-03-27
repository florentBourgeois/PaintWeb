package fr.cci.formationobjet.java.PaintWeb.controller;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import fr.cci.formationobjet.java.PaintWeb.IHM.PaintView;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SCircle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SPixel;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SRectangle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SSquare;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.STampon;

public class PaintController implements MouseMotionListener, MouseListener{

	enum ShapeEnum{
		CIRCLE,
		RECTANGLE
	}
	
	private PaintView view;
	private STampon model = new STampon();

	private ActionListener resetActionListener;
    private ActionListener createActionListener;
	private ActionListener selectCircleActionListener;
    private ActionListener selectRectangleActionListener;
    
    private ShapeEnum shapeSelected = ShapeEnum.RECTANGLE;

    public PaintController(){
        resetActionListener = new ResetActionListener();
        createActionListener = new CreateActionListener();
        selectCircleActionListener = new SelectCircleActionListener();
        selectRectangleActionListener = new SelectRectangleActionListener();
    }


    public void setView(PaintView view) {
        this.view = view;
    }

    public ActionListener getResetActionListener() {
        return resetActionListener;
    }

    public ActionListener getCreateActionListener() {
        return createActionListener;
    }
    
	public ActionListener getSelectCircleActionListener() {
		return selectCircleActionListener;
	}


	public ActionListener getSelectRectangleActionListener() {
		return selectRectangleActionListener;
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
		if(shapeSelected == ShapeEnum.RECTANGLE)
			model.add(new SRectangle(e.getPoint(), 20,40));
		else if (shapeSelected == ShapeEnum.CIRCLE) {
			model.add(new SCircle(e.getPoint(), 40));
		}
		this.view.setModel(model);
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

	 class ResetActionListener implements ActionListener{

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            model = new STampon();
	            view.updateUI();
	        }
    }


    class CreateActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            STampon t2 = new STampon();
            t2.add(new SRectangle(new Point(1,4),10,10));
            t2.add(new SRectangle(new Point(100,100),1,50));
            t2.add(new SCircle(new Point(40,40), 200));
            t2.add(new SPixel(10,20));
            t2.add(new SPixel(30,30));
            t2.add(new SPixel(40,30));
            t2.add(new SPixel(100,101));

            model = t2;
            view.updateUI();

        }
    }
	
    

    class SelectRectangleActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	shapeSelected = ShapeEnum.RECTANGLE;
        }
    }

    
    class SelectCircleActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        	shapeSelected = ShapeEnum.CIRCLE;
        }
    }
}
