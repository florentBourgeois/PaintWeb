package tests.shapes;

import static org.junit.jupiter.api.Assertions.*;


import java.awt.Point;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import shapes.SCircle;


public class SCircle_tst {
	
	//objet qui sera utilisé pour récupérer le flux passant vers la console
    public final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    //connection de outContent avec le flux de sortie (redirige System.out) 
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    //libérer le flux de sortie et remettre system.out
    @AfterAll
    public void restoreStreams() {
        System.setOut(System.out);
    }

   
	// vérifier que l'affichage en texte du carré est correct.
	@Test
	public void Given_DefaultCircle_When_toString_Then_ShouldReturnText(){
		SCircle c = new SCircle();
		assertEquals("Circle : location=0|0 ; radius=1 ; isSelected=false", c.toString());
	}

	// vérifier que l'impression du cercle est correcte. // Print() prend l'affichage en texte et l'envoie sur le flux de sortie système (System.out)
	@Test
	public void Given_DefaultCircle_When_print_Then_ShouldDisplayText(){
		SCircle c = new SCircle();
		c.print();
		assertEquals("Circle : location=0|0 ; radius=1 ; isSelected=false", outContent.toString().replace("\r\n", "\n"));
	}
	
	@Test
	public void Given_DefaultCircleSelected_When_Print_Then_ShouldDisplayText(){
		SCircle c = new SCircle();
		c.select();
		c.print();
		assertEquals("Circle : location=0|0 ; radius=1 ; isSelected=true", outContent.toString().replace("\r\n", "\n"));
	}

	//vérifier le constructeur valué avec un point et une largeur
	@Test
	public void Given_Nothing_When_CreatingCircleWithPointAndRadAndPrint_Then_shouldDisplay() {
		SCircle c = new SCircle(new Point(100,10), 50);
		// vérifier que l'impression du rectangle est correcte.
		c.print();
		assertEquals("Circle : location=100|10 ; radius=50 ; isSelected=false", outContent.toString().replace("\r\n", "\n"));
	}
	
	//vérifier le constructeur valué avec deux points valides
	@Test
	public void Given_Nothing_When_CreatingCircleWithTwoPointAndNegativeRadAndPrint_Then_shouldDisplay() {
		SCircle c = new SCircle(new Point(100,10), -50);
		c.print();
		assertEquals("Circle : location=100|10 ; radius=50 ; isSelected=false", outContent.toString().replace("\r\n", "\n"));			
	}
	
		
	// vérifier que la requette de localisation est correcte. (la localisation est le point en haut à gauche du rectangle
	@Test
	public void Given_defaultCircle_When_getLocation_Then_LocationOf0_0() {
		SCircle c = new SCircle();
		Point expectedLocation = new Point(0,0); 
		assertEquals(expectedLocation, c.getLoc());
	}
	
	@Test
	public void Given_CircleWithParameters_When_getLocation_Then_Location() {
		SCircle c = new SCircle();
		Point expectedLocation = new Point(100,10); 
		c.setLoc(expectedLocation);
		assertEquals(expectedLocation, c.getLoc());
	}
	
	//vérifier que la modification de localisation est correcte.
	@Test
	public void Given_defaultCircle_When_setLocation_Then_printShouldBe() {
		SCircle c = new SCircle();
		Point expectedLocation = new Point(40,40);
		c.setLoc(expectedLocation);
		assertEquals("Circle : location=40|40 ; radius=1 ; isSelected=false", c.toString()); 
		}
	
	// vérifier que la requette de bordures est correcte.
	@Test
	public void Given_DefaultCircle_When_GettingBounds_Then_shouldReturnBounds() {
		SCircle c = new SCircle();
		Rectangle bounds = c.getBounds();
		Point expectedBoundsLocation = new Point(-1, -1);
		assertEquals(expectedBoundsLocation, bounds.getLocation());
		assertEquals(2, (int)bounds.getWidth()); 
		assertEquals(2, (int)bounds.getHeight()); 
	}
	
	//vérifier les bordures avec un constructeur valué avec deux points
	@Test
	public void Given_CircleFromPointAndRad_When_GettingBounds_Then_shouldReturnBounds() {
		SCircle c = new SCircle(new Point(100,200), 50);
		Rectangle bounds = c.getBounds();

		Point expectedBoundsLocation = new Point(50, 150);
		assertEquals(expectedBoundsLocation, bounds.getLocation());
		assertEquals((int)bounds.getWidth(), 100); 
		assertEquals((int)bounds.getHeight(), 100); 
	}
	
	
	//tester les translations
	@Test
	public void Given_DefaultSquare_When_translating_Then_boundsshouldBe() {
		SCircle c = new SCircle();
		c.translate(20, 30);
		Rectangle bounds = c.getBounds();
		
		assertEquals(new Point(20,30), c.getLoc());

		
		Point expectedBoundsLocation = new Point(19, 29); 
		assertEquals(bounds.getLocation(), expectedBoundsLocation);
		assertEquals(2, (int)bounds.getWidth()); // inchangée
		assertEquals(2, (int)bounds.getHeight()); // inchangée
	}
	
	
	@Test
	public void Given_Circle_When_translating_Then_boundsshouldBe() {
		SCircle c = new SCircle();
		c.translate(-20, -30);
		Rectangle bounds = c.getBounds();
		
		assertEquals(new Point(-20,-30), c.getLoc());
		
		Point expectedBoundsLocation = new Point(-21, -31); 
		assertEquals(expectedBoundsLocation, bounds.getLocation() );
		assertEquals(2, (int)bounds.getWidth()); // inchangée
		assertEquals(2, (int)bounds.getHeight()); // inchangée
	}
	
	@Test
	public void Given_CircleWithPoints_When_translating_Then_boundsshouldBe() {
		SCircle c = new SCircle(new Point(100,150), 50);
		c.translate(-50, -50);
		Rectangle bounds = c.getBounds();
		
		assertEquals(new Point(50,100),  c.getLoc());
		
		Point expectedBoundsLocation = new Point(0, 50); 
		assertEquals(expectedBoundsLocation, bounds.getLocation() );
		assertEquals(100, (int)bounds.getWidth()); // inchangée
		assertEquals(100, (int)bounds.getHeight()); // inchangée
	}

//*/

}
