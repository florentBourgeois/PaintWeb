package fr.cci.formationobjet.java.PaintWeb.model.shapes.DAO;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.cci.formationobjet.java.PaintWeb.model.shapes.SShape;

/**
 * ProductDAO is an interface using JPA to define the Database connexion.
 * It manages the Product classes with Integer as base key
 * @author florentbourgeoisPluton
 *
 */
@Repository
public interface ShapeDAO extends JpaRepository<SShape, Long> {
	//JpaRepository définie un ensemble de méthode d'accès à la bdd de base : 
	//findAll(Sort sort)
	//findAllById(Iterable<ID> ids) 
	//delete(int id)  
	//count() 
	//save(Product produit)  // fonctionne également avec un iterator
	
	SShape findById(int id); // parse le nom de la méthode pour l'autogénérée

}
