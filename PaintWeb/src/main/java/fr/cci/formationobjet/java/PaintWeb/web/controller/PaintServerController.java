package fr.cci.formationobjet.java.PaintWeb.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import fr.cci.formationobjet.java.PaintWeb.model.shapes.SPixel;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SRectangle;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.SShape;
import fr.cci.formationobjet.java.PaintWeb.model.shapes.DAO.ShapeDAO;

@RestController
public class PaintServerController {
	
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
    	return "hello world";
    }
	
    @GetMapping(value = "paint/shapes/{id}")
    public String getSpixel(@PathVariable int id) {
        return "Vous avez demandé un spixel avec l'id  " + id;
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
}
