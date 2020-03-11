package fr.cci.formationobjet.java.PaintWeb.model.companies.DAO;

import fr.cci.formationobjet.java.PaintWeb.model.companies.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
