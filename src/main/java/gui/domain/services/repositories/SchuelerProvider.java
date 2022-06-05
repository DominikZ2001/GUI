package gui.domain.services.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gui.domain.entities.Klasse;
import gui.domain.entities.Schueler;

@Repository
public interface SchuelerProvider extends JpaRepository<Schueler, Integer>
{
	@Query("SELECT s FROM schueler s WHERE klasse = :klasse")
	public List<Schueler> getAllSchuelerByKlasse(@Param("klasse") Klasse klasse);
}
