package fr.cci.formationobjet.java.PaintWeb.web.controller;



import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import fr.cci.formationobjet.java.PaintWeb.PaintWebServerApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.cci.formationobjet.java.PaintWeb.model.shapes.SCircle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SPixel;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SRectangle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SShape;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.STampon;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.DAO.ShapeDAO;

@RestController
public class PaintServerAnalysisController {

    private static final Logger logger = LogManager.getLogger(PaintWebServerApplication.class);


    @Autowired ShapeDAO shapeDAO;
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	static {
		MAPPER.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
		MAPPER.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		//MAPPER.registerSubtypes(new NamedType(SPixel.class, "Pixel"));
		//MAPPER.registerSubtypes(new NamedType(SRectangle.class, "Rectangle"));
	}
	
    @GetMapping(value = "/paint/helloworld")
    public String getHello() {
    	return "hello world how are you ?  ";
    }
	
    @GetMapping(value = "paint/shapes/{id}")
    public List<SShape> getShape(@PathVariable int id) {
        return this.shapeDAO.findAll();
    }

    @PutMapping(value = "paint/shapes/{id}/translate")
    public ResponseEntity<SShape> translateSHape(@PathVariable long id, @RequestBody Point p) {
        Optional<SShape> optionalShape = shapeDAO.findById(id);
        if (optionalShape.isPresent()) {
            SShape s = optionalShape.get();
            s.translate(p.x, p.y);
            shapeDAO.save(s);
            return ResponseEntity.ok(s);
        }
        else {
            logger.info("shape to translate with id: {} not found", id);
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping(value = "paint/shapes/{id}/setLocation")
    public ResponseEntity<SShape> setShapeLoc(@PathVariable long id, @RequestBody Point p) {
        Optional<SShape> optionalShape = shapeDAO.findById(id);
        if (optionalShape.isPresent()) {
            SShape s = optionalShape.get();
            s.setLoc(p);
            shapeDAO.save(s);
            return ResponseEntity.ok(s);
        }
        else {
            logger.info("shape to setLoc with id: {} not found", id);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(value = "paint/shapes/{id}/toggleSelect")
    public ResponseEntity<SShape> toggleSelectShape(@PathVariable long id) {
        Optional<SShape> optionalShape = shapeDAO.findById(id);
        if (optionalShape.isPresent()) {
            SShape s = optionalShape.get();
            s.toggleSelect();
            shapeDAO.save(s);
            return ResponseEntity.ok(s);
        }
        else {
            logger.info("shape to toggle with id: {} not found", id);
            return ResponseEntity.badRequest().build();
        }
    }

    
    @RequestMapping(value="/paint/shapes", method=RequestMethod.GET)
    public List<SShape> listShapes() throws JsonProcessingException {
    	List<SShape> l = shapeDAO.findAll();
    	for (SShape s : l) {
			System.out.println(s);
		}
    	//MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(shapeDAO.findAll());
    	
        return shapeDAO.findAll();
    }

    
    @DeleteMapping(value = "paint/pixels/{id}")
    public ResponseEntity<SShape> deletePixel(@PathVariable("id") long id) {
    	Optional<SShape> optionalShape = shapeDAO.findById(id);
    	if (optionalShape.isPresent()) {
    		shapeDAO.delete(optionalShape.get());
    		return ResponseEntity.noContent().build();
    	}
    	else {
            logger.info("Pixel with id: {} not found", id);
    		return ResponseEntity.notFound().build();
    	}

    }

    @DeleteMapping(value = "paint/shapes/{id}")
    public ResponseEntity<SShape> delSpixel(@PathVariable int id) {
    	SShape s = shapeDAO.findById(id);
    	if (s instanceof SPixel) {
            shapeDAO.delete(s);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();

    }
    
    @RequestMapping(value="/paint/pixels", method=RequestMethod.POST)
    public SPixel addPixel(@RequestBody SPixel px)  {
        return this.shapeDAO.save(px);
    }
    
    @RequestMapping(value="/paint/pixels", method=RequestMethod.GET)
    public List<SPixel> listPixels() throws JsonProcessingException {

    	List<SPixel> list = new ArrayList<>();
    	for (SShape s : shapeDAO.findAll()) {
			if(s instanceof SPixel )
				list.add((SPixel) s);
		}
    	/*
    	Stream<SShape>  shapes = shapeDAO.findAll().stream();
    	SPixel[] array = (SPixel[])shapes.filter(shape -> shape instanceof SPixel).toArray();
    	List<SPixel> list = Arrays.asList(array);
    	*/
    	for (SShape s : list) {
			System.out.println(s);
		}
        return list;
        
    }


    @RequestMapping(value="/paint/rectangles", method=RequestMethod.POST)
    public SRectangle addPixel(@RequestBody SRectangle r)  {
        return this.shapeDAO.save(r);
    }

    @RequestMapping(value="/paint/rectangles", method=RequestMethod.GET)
    public List<SRectangle> listRectangles()  {
        List<SRectangle> list = new ArrayList<>();
        for (SShape s : shapeDAO.findAll()) {
            if(s instanceof SRectangle )
                list.add((SRectangle) s);
        }
	    /*
    	Stream<SShape>  shapes = shapeDAO.findAll().stream();
    	SRectangle[] array = (SRectangle[])shapes.filter(shape -> shape instanceof SRectangle).toArray();
    	List<SRectangle> list = Arrays.asList(array);
        */
        return list;
    }

    @RequestMapping(value="/paint/circles", method=RequestMethod.POST)
    public SCircle addPixel(@RequestBody SCircle c)  {
        return this.shapeDAO.save(c);
    }
    @RequestMapping(value="/paint/circles", method=RequestMethod.GET)
    public List<SCircle> listCircles() {
        List<SCircle> list = new ArrayList<>();
        for (SShape s : shapeDAO.findAll()) {
            if(s instanceof SCircle )
                list.add((SCircle) s);
        }
	    /*
	    Stream<SShape>  shapes = shapeDAO.findAll().stream();
    	SCircle[] array = (SCircle[])shapes.filter(shape -> shape instanceof SRectangle).toArray();
    	List<SCircle> list = Arrays.asList(array);
        */
        return list;
    }

    @RequestMapping(value="/paint/tampons", method=RequestMethod.POST)
    public STampon addPixel(@RequestBody STampon t)  {
        return this.shapeDAO.save(t);
    }
    @RequestMapping(value="/paint/tampons", method=RequestMethod.GET)
    public List<STampon> listTampons() {
        List<STampon> list = new ArrayList<>();
        for (SShape s : shapeDAO.findAll()) {
            if(s instanceof STampon )
                list.add((STampon) s);
        }
        /*
    	Stream<SShape>  shapes = shapeDAO.findAll().stream();
    	STampon[] array = (STampon[])shapes.filter(shape -> shape instanceof SRectangle).toArray();
    	List<STampon> list = Arrays.asList(array);
        */
        return list;
    }
    
    
    
}
